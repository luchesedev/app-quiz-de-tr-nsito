# 🚦 QuizPlacas - Android Java

---

### 📖 Sobre o Projeto
Este aplicativo é um **projeto acadêmico** desenvolvido para a disciplina de **Programação Orientada a Objetos (POO)** na **FATEC Guarulhos**. O objetivo é testar o conhecimento do usuário sobre placas de sinalização brasileiras (Lombada, Obras, Pare, etc.) através de uma interface dinâmica no Android.

---

## 🚀 Funcionalidades Identificadas no Código

* **🎲 Embaralhamento Duplo:** O app utiliza `Collections.shuffle` tanto para a lista de perguntas quanto para as alternativas (botões), garantindo que a resposta correta mude de posição a cada rodada.
* **⏱️ Feedback Visual Temporizado:** Implementação de um `Handler().postDelayed` de **400ms** que altera a cor do botão (`BackgroundTintList`) para Verde (acerto) ou Vermelho (erro) antes de seguir para a próxima questão.
* **🛡️ Prevenção de Cliques Duplos:** Durante o tempo de resposta, o código bloqueia (`setEnabled(false)`) todos os botões para evitar que o usuário responda duas vezes à mesma pergunta.
* **📊 Persistência de Resultado:** Uso de `Intent.putExtra` para transferir o número total de acertos da `TelaQuiz` para a `TelaAcertos`.
* **🧹 Gestão de Memória:** Uso do método `finish()` ao trocar de tela para limpar a Activity anterior da pilha, otimizando o fluxo de navegação.

---

## 🛠️ Tecnologias e Ferramentas

<div style="display: inline_block">
  <img align="center" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg">
  <img align="center" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/androidstudio/androidstudio-original.svg">
  <img align="center" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/xml/xml-original.svg">
</div>

<br>

* **Linguagem:** Java
* **Interface:** XML com suporte a `EdgeToEdge` (layout de tela cheia).
* **Componentes Android:** `Intent`, `Handler`, `ColorStateList`, `WindowInsets`.

---

## 🏗️ Estrutura de Classes (Conforme o Código)

O projeto está organizado em 4 pilares principais:

1.  **`Questao.java`**: A classe modelo (POO) que encapsula o ID da imagem (`Idimagem`) e as 4 opções de resposta.
2.  **`MainActivity.java`**: Tela inicial que prepara o ambiente e inicia a transição para o quiz.
3.  **`TelaQuiz.java`**: O "coração" do app. Gerencia a lista de questões, aplica o embaralhamento e controla a lógica de verificação de acertos.
4.  **`TelaAcertos.java`**: Recupera os dados enviados pela Intent e exibe o placar final ao usuário.

---

## 🧩 Detalhes da Lógica de Negócio

> "A lógica de cores utiliza `#81C7F3` como cor padrão e faz a transição via código para `Color.GREEN` ou `Color.RED` conforme a resposta do usuário."

---
