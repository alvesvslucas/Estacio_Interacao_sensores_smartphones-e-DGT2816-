# ListaDeTarefas – Wear OS

## Missão Prática – Interação com Sensores de Smartphones e Wearables

Este repositório contém o projeto desenvolvido para a **Missão Prática da disciplina Interação com Sensores de Smartphones e Wearables**, utilizando a plataforma **Wear OS**, conforme os requisitos propostos pelo Centro Universitário Estácio.

---

## 📌 Informações Acadêmicas

- **Aluno:** Lucas Alves Vieira da Silva
- **Matrícula:** 202310363402
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

## 📱 Execução do Aplicativo

O aplicativo foi executado e testado em **emulador Wear OS**, demonstrando corretamente:

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

está disponível no arquivo:
