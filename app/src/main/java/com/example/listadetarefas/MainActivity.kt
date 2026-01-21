package com.example.listadetarefas

import android.content.Intent
import android.media.AudioDeviceCallback
import android.media.AudioDeviceInfo
import android.media.AudioManager
import android.os.Bundle
import android.provider.Settings
import android.speech.tts.TextToSpeech
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var audioManager: AudioManager
    private lateinit var audioHelper: AudioHelper

    private lateinit var listView: ListView
    private lateinit var btn: Button

    private lateinit var tts: TextToSpeech

    private val logs = mutableListOf<String>()
    private lateinit var adapter: ArrayAdapter<String>

    private val deviceCallback = object : AudioDeviceCallback() {
        override fun onAudioDevicesAdded(addedDevices: Array<out AudioDeviceInfo>?) {
            super.onAudioDevicesAdded(addedDevices)
            addLog("✅ Dispositivo de áudio adicionado.")
            refreshAudioStatus()
        }

        override fun onAudioDevicesRemoved(removedDevices: Array<out AudioDeviceInfo>?) {
            super.onAudioDevicesRemoved(removedDevices)
            addLog("⚠️ Dispositivo de áudio removido.")
            refreshAudioStatus()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        audioManager = getSystemService(AUDIO_SERVICE) as AudioManager
        audioHelper = AudioHelper(this)

        listView = findViewById(R.id.listView)
        btn = findViewById(R.id.btnAudioCheck)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, logs)
        listView.adapter = adapter

        tts = TextToSpeech(this, this)

        // Detecta conectar/desconectar dispositivos de áudio (Bluetooth etc.)
        audioManager.registerAudioDeviceCallback(deviceCallback, null)

        refreshAudioStatus()

        btn.setOnClickListener {
            val bt = audioHelper.isBluetoothA2dpConnected()
            val speaker = audioHelper.isSpeakerAvailable()

            refreshAudioStatus()

            // Se não tiver Bluetooth A2DP, abre configurações
            if (!bt) {
                addLog("➡️ Abrindo configurações Bluetooth (A2DP não detectado).")
                val intent = Intent(Settings.ACTION_BLUETOOTH_SETTINGS).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    putExtra("EXTRA_CONNECTION_ONLY", true)
                    putExtra("EXTRA_CLOSE_ON_CONNECT", true)
                    putExtra("android.bluetooth.devicepicker.extra.FILTER_TYPE", 1)
                }
                startActivity(intent)
                return@setOnClickListener
            }

            // “Ler” mensagem (TTS)
            val msg = if (speaker) {
                "Mensagem de teste. Áudio disponível no alto falante."
            } else {
                "Mensagem de teste. Áudio disponível via Bluetooth."
            }
            speak(msg)
        }
    }

    private fun refreshAudioStatus() {
        val speaker = audioHelper.isSpeakerAvailable()
        val bt = audioHelper.isBluetoothA2dpConnected()
        addLog("Status -> Speaker: ${if (speaker) "SIM" else "NÃO"} | Bluetooth A2DP: ${if (bt) "SIM" else "NÃO"}")
    }

    private fun addLog(text: String) {
        logs.add(0, text)
        adapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        audioManager.unregisterAudioDeviceCallback(deviceCallback)
        tts.shutdown()
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts.language = Locale("pt", "BR")
            addLog("🔊 TextToSpeech pronto (pt-BR).")
        } else {
            addLog("❌ Falha ao iniciar TextToSpeech.")
        }
    }

    private fun speak(text: String) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "MSG_1")
        addLog("🗣️ Falando: $text")
    }
}
