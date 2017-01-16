package com.luke.unoplacar.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.luke.unoplacar.R;
import com.luke.unoplacar.entidade.Jogador;
import com.luke.unoplacar.helper.JogadoresDAO;

public class NovoJogadorActivity extends AppCompatActivity {

    private EditText edtNomeNovoJogador;
    private Button btnConfirmarJogador;
    private Button btnLimparJogador;
    private Button btnSalvarJogador;

    int pontuacaoPerdedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_jogador);

        Intent it = getIntent();
        Bundle args = it.getExtras();
        pontuacaoPerdedor = args.getInt("mediaPontuacaoPerdedor");
    }

    @Override
    protected void onResume() {
        super.onResume();

        edtNomeNovoJogador = (EditText) findViewById(R.id.edtNovoJogador);

        btnConfirmarJogador = (Button) findViewById(R.id.btnAddNovoJogador);
        btnConfirmarJogador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtNomeNovoJogador.setEnabled(false);
                edtNomeNovoJogador.setTextColor(Integer.valueOf(R.color.cor_edt_desabilitado));
            }
        });

        btnLimparJogador = (Button) findViewById(R.id.btnExcNovoJogador);
        btnLimparJogador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtNomeNovoJogador.setEnabled(true);
                edtNomeNovoJogador.setText("");
            }
        });

        btnSalvarJogador = (Button) findViewById(R.id.btnSalvarNovoJogador);
        btnSalvarJogador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!edtNomeNovoJogador.getText().toString().isEmpty()){
                    Jogador jogador = new Jogador(edtNomeNovoJogador.getText().toString(), pontuacaoPerdedor, 0);
                    JogadoresDAO jogadoresDAO = new JogadoresDAO(NovoJogadorActivity.this);
                    jogadoresDAO.salvarJogador(jogador);

                    finish();
                }else{
                    Toast.makeText(NovoJogadorActivity.this, "Preencha o nome do Novo Jogador!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
