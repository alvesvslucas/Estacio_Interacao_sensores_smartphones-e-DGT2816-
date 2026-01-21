package com.example.listadetarefas

import android.content.Context
import android.content.pm.PackageManager
import android.media.AudioDeviceInfo
import android.media.AudioManager

class AudioHelper(private val context: Context) {

    private val audioManager =
        context.getSystemService(Context.AUDIO_SERVICE) as AudioManager

    private fun audioOutputAvailable(type: Int): Boolean {
        if (!context.packageManager.hasSystemFeature(PackageManager.FEATURE_AUDIO_OUTPUT)) {
            return false
        }
        return audioManager.getDevices(AudioManager.GET_DEVICES_OUTPUTS).any { it.type == type }
    }

    fun isSpeakerAvailable(): Boolean =
        audioOutputAvailable(AudioDeviceInfo.TYPE_BUILTIN_SPEAKER)

    fun isBluetoothA2dpConnected(): Boolean =
        audioOutputAvailable(AudioDeviceInfo.TYPE_BLUETOOTH_A2DP)
}
