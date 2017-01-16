package com.luke.unoplacar.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.luke.unoplacar.R;
import com.luke.unoplacar.entidade.Jogador;
import com.luke.unoplacar.helper.JogadoresDAO;

public class PontuarActivity extends AppCompatActivity {

    private TextView txtNomeJogador;
    private TextView txtPontuacaoAntiga;
    private EditText edtPontuacaoNova;
    private Button btnPontuar;
    private Bundle args;
    Jogador jogador;
    //int pontuacaoAntigaJogador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontuar);

        Intent it = getIntent();

        jogador = (Jogador) it.getSerializableExtra("jogador");
        //pontuacaoAntigaJogador = args.getInt("pontuacaoAtual");
    }

    @Override
    protected void onResume() {
        super.onResume();

        txtNomeJogador = (TextView) findViewById(R.id.txtNomeJogadorParaPontuar);
        txtNomeJogador.setText(this.jogador.getNome());

        txtPontuacaoAntiga = (TextView) findViewById(R.id.txtPontuacaoAtual);
        txtPontuacaoAntiga.setText(String.valueOf(this.jogador.getPontuacao()));

        edtPontuacaoNova = (EditText)findViewById(R.id.edtPontuacaoNova);

        btnPontuar = (Button) findViewById(R.id.btnPontuar);
        btnPontuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int resultado = jogador.getPontuacao() + Integer.parseInt(edtPontuacaoNova.getText().toString());

                JogadoresDAO jogadoresDAO = new JogadoresDAO(PontuarActivity.this);
                jogador.setPontuacao(resultado);
                jogador.setIsNovo(1);
                jogadoresDAO.alterarJogador(jogador);

                /*Intent it = new Intent(PontuarActivity.this, PlacarActivity.class);
                startActivity(it);*/
                finish();
            }
        });

    }
}
