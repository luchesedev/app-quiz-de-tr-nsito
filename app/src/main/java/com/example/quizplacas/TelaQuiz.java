package com.example.quizplacas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TelaQuiz extends AppCompatActivity {

    // Variáveis globais
    List<Questao> questoes = new ArrayList<>();
    ImageView imgplaca;
    Button btn1, btn2, btn3, btn4;
    int cont = 0, acertos = 0;
    TextView textview3, textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_quiz);

        // Ajuste de preenchimento para as barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. INICIALIZAÇÃO dos componentes (Onde o app costuma travar se esquecer)
        imgplaca = findViewById(R.id.imgplaca);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        textview3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);

        // 2. ADICIONAR AS QUESTÕES (Usando os IDs do seu drawable)
        questoes.add(new Questao(R.drawable.lombada, "lombada", "pista sinuosa", "curva acentuada", "passagem de nível"));
        questoes.add(new Questao(R.drawable.obras, "obras", "trabalhadores na pista", "projeção de cascalho", "área com desmoronamento"));
        questoes.add(new Questao(R.drawable.pistaescorregadia, "pista escorregadia", "pista irregular", "proibido trânsito de veículos", "vento lateral"));
        questoes.add(new Questao(R.drawable.placaintersecaoemcirculo, "interseção em círculo", "entroncamento oblíquo", "bifurcação em Y", "passagem sinalizada"));
        questoes.add(new Questao(R.drawable.proibidoestacionareparar, "proibido estacionar e parar", "estacionamento regulamentado", "proibido virar à esquerda", "proibido retornar"));
        questoes.add(new Questao(R.drawable.sigaemfrenteouesquera, "siga em frente ou à esquerda", "siga em frente ou à direita", "passagem obrigatória", "sentido proibido"));
        questoes.add(new Questao(R.drawable.ultrapassagemproibida, "ultrapassagem proibida", "sentido único", "proibido mudar de faixa", "trânsito de pedestres"));
        questoes.add(new Questao(R.drawable.decliveacentuado, "declive acentuado", "aclive acentuado", "ponte estreita", "confluência à esquerda"));
        questoes.add(new Questao(R.drawable.estreitamentodefaixa, "estreitamento de faixa", "mão dupla adiante", "início de pista dupla", "pista dividida"));
        questoes.add(new Questao(R.drawable.curvaacentuadaems, "curva acentuada em s", "curva acentuada à direita", "curva acentuada à esquerda", "pista sinuosa à direita"));

        // 3. EMBARALHAR AS PERGUNTAS
        Collections.shuffle(questoes);

        // 4. CHAMAR A PRIMEIRA QUESTÃO
        atualizarTela();
    }

    public void atualizarTela() {
        if (cont < questoes.size()) {
            Questao q = questoes.get(cont);

            // Define a imagem da placa
            imgplaca.setImageResource(q.getIdimagem());

            // Cria e embaralha as alternativas (Botões)
            List<String> alternativas = new ArrayList<>();
            alternativas.add(q.getRespostaCorreta());
            alternativas.add(q.getRespostaErrada1());
            alternativas.add(q.getRespostaErrada2());
            alternativas.add(q.getRespostaErrada3());

            Collections.shuffle(alternativas);

            // Define o texto nos botões
            btn1.setText(alternativas.get(0));
            btn2.setText(alternativas.get(1));
            btn3.setText(alternativas.get(2));
            btn4.setText(alternativas.get(3));

            // Atualiza os textos de progresso e acertos
            textview3.setText("Questão " + (cont + 1) + " de " + questoes.size());
            textView4.setText("Acertos: " + acertos);
        }
    }


    public void verificarResposta(View view) {
        Button btnClicado = (Button) view;
        String respostaEscolhida = btnClicado.getText().toString();
        String respostaCorreta = questoes.get(cont).getRespostaCorreta();

        if (respostaEscolhida.equals(respostaCorreta)) {
            acertos++;
        }

        cont++; // Vai para o índice da próxima questão

        if (cont < questoes.size()) {
            atualizarTela();
        } else {
            // Fim do Quiz: Envia para a tela final
            Intent intent = new Intent(this, TelaAcertos.class);
            intent.putExtra("acertos", acertos);
            startActivity(intent);
            finish(); // Encerra esta atividade para não voltar ao quiz ao apertar 'voltar'
        }
    }
}