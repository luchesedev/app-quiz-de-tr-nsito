package com.example.quizplacas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TelaQuiz extends AppCompatActivity {
    List<Questao> questoes = new ArrayList<>();
    ImageView imgplaca;
    Button btn1,btn2,btn3,btn4;
    int cont =0, acertos = 0;
    Intent it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_quiz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imgplaca = findViewById(R.id.imgplaca);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);

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

        Collections.shuffle(questoes);

    }
    public void proxima(View view){
        if (fim()){
            it = new Intent();
        }
    }
    public boolean fim(){
        return cont <10;
    }
}