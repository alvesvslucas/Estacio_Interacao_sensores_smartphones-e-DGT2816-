# ListaDeTarefas – Wear OS

## Missão Prática – Interação com Sensores de Smartphones e Wearables

Este repositório contém o projeto desenvolvido para a **Missão Prática da disciplina Interação com Sensores de Smartphones e Wearables**, utilizando a plataforma **Wear OS**, conforme os requisitos propostos pelo Centro Universitário Estácio.

---

## 📌 Informações Acadêmicas

- **Aluno:** Lucas Alves Vieira da Silva
- **Curso:** Análise e Desenvolvimento de Sistemas
- **Disciplina:** Interação com Sensores de Smartphones e Wearables
- **Turma:** DGT2816 - 9001
- **Semestre:** 2025.4
- **Instituição:** Centro Universitário Estácio – Campus Parangaba

---

## 🎯 Objetivo do Projeto

O objetivo deste projeto é desenvolver um aplicativo para **Wear OS** com foco na **interação com sensores e recursos de áudio**, voltado à **comunicação e assistência**, especialmente para usuários com necessidades especiais.

O aplicativo permite:

- Identificar dispositivos de saída de áudio disponíveis;
- Detectar dinamicamente alterações em dispositivos de áudio;
- Realizar leitura de mensagens por síntese de voz (TextToSpeech);
- Exibir logs de funcionamento em tempo real.

---

## 🛠️ Tecnologias Utilizadas

- **Android Studio**
- **Kotlin**
- **Wear OS**
- **AudioManager**
- **AudioDeviceCallback**
- **TextToSpeech**
- **Emulador Wear OS (API 36)**

---

## ⚙️ Funcionalidades Implementadas

- Interface simples contendo:
  - Botão de ação para verificação de áudio;
  - ListView para exibição de logs.
- Detecção de dispositivos de saída de áudio:
  - Alto-falante interno (Speaker);
  - Bluetooth A2DP.
- Monitoramento dinâmico de dispositivos de áudio através de `AudioDeviceCallback`.
- Leitura de mensagens utilizando a API `TextToSpeech`.
- Tratamento de falhas de inicialização do TTS no ambiente de emulação.

---

## Preparar e executar esta cópia

Abra a raiz no Android Studio e sincronize o Gradle. A configuração declara **Android Gradle Plugin 9.0.0**, wrapper **Gradle 9.1.0**, `compileSdk/targetSdk 36` e `minSdk 30`. Instale o SDK Android 36 e use um JDK compatível com esse plugin; a compatibilidade de fontes Java 11 não define o JDK de execução do Gradle.

No Windows, a partir da raiz:

```powershell
git clone https://github.com/alvesvslucas/Estacio_Interacao_sensores_smartphones-e-DGT2816-.git
cd Estacio_Interacao_sensores_smartphones-e-DGT2816-
.\gradlew.bat :app:assembleDebug
```

No Android Studio, selecione um emulador Wear OS compatível e execute o módulo `app`. Verifique saída de áudio, recursos Bluetooth e disponibilidade do mecanismo TTS no dispositivo. O build e a execução não foram realizados nesta revisão documental.

## 📱 Execução registrada na entrega

O relato original da entrega informa execução em **emulador Wear OS**, com as seguintes evidências descritas:

- Abertura da Activity principal;
- Identificação dos dispositivos de áudio disponíveis;
- Registro de eventos de adição/remoção de dispositivos;
- Exibição de logs na interface.

---

## 📸 Evidências

As evidências da execução do aplicativo (prints do emulador Wear OS) estão documentadas no relatório em PDF presente neste repositório.

---

## 📄 Documentação

A documentação completa da Missão Prática, incluindo:

- Descrição do projeto;
- Análise crítica;
- Prints da implementação;

deve ser consultada nos arquivos da entrega presentes no repositório.
