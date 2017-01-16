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
import com.luke.unoplacar.entidade.Jogo;
import com.luke.unoplacar.helper.GerenciadorDeSessao;
import com.luke.unoplacar.helper.JogadoresDAO;
import com.luke.unoplacar.helper.JogoDAO;
import com.luke.unoplacar.helper.UnoDBHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InicioActivity extends AppCompatActivity {

    private EditText edtQtdJogadores;
    private Button btnIniciarPartida;
    private Button btnContinuarPartida;
    private Jogo jogo;
    private JogoDAO jogoDAO;
    private UnoDBHelper unoDBHelper;
    List<Jogo> lista;
    //private GerenciadorDeSessao gSessao;

    boolean temJogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        //unoDBHelper = new UnoDBHelper(getApplicationContext());

        //gSessao = new GerenciadorDeSessao(getApplicationContext());

        /*if (gSessao.isLoggedIn()) {

            Intent intent = new Intent(InicioActivity.this, PlacarActivity.class);
            startActivity(intent);
            finish();
            //vaiProQueInteressa();
        }*/

        //temJogo = false;
    }

    @Override
    protected void onResume() {
        super.onResume();

        edtQtdJogadores = (EditText) findViewById(R.id.edtQtdJogadores);

        btnIniciarPartida = (Button) findViewById(R.id.btnIniciar);
        btnIniciarPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String qtdJogadores = edtQtdJogadores.getText().toString();

                if(!qtdJogadores.isEmpty()){
                    if (Integer.parseInt(qtdJogadores) > 1 && Integer.parseInt(qtdJogadores) <= 8){

                        /*JogoDAO jogoDAO = new JogoDAO(InicioActivity.this);
                        jogo = new Jogo(0, Integer.parseInt(qtdJogadores), 0);
                        jogoDAO.salvarJogo(jogo);*/

                        Intent telaJogadores = new Intent(InicioActivity.this, JogadoresActivity.class);
                        Bundle params = new Bundle();
                        params.putString("qtdJogadores", qtdJogadores);
                        telaJogadores.putExtras(params);
                        startActivity(telaJogadores);
                        edtQtdJogadores.setText("");
                        finish();
                    }else{
                        Toast.makeText(InicioActivity.this, "A App suporta de 2 a 8 jogadores!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(InicioActivity.this, "Informe a quantiade de jogadores.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnContinuarPartida = (Button) findViewById(R.id.btnContinuarPartida);
        btnContinuarPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(InicioActivity.this, "Não existem partidas em aberto.", Toast.LENGTH_SHORT).show();


                if(carregaListaJogadores()){

                    Intent intent = new Intent(InicioActivity.this, PlacarActivity.class);
                    startActivity(intent);

                    finish();
                }else{
                    Toast.makeText(InicioActivity.this, "Não existem partidas em aberto.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        finish();
    }

    public boolean carregaListaJogadores() {

        JogoDAO jogoDAO = new JogoDAO(this);
        List<Jogo> listaJogos = jogoDAO.getListaJogos();

        if(listaJogos.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    /*private void vaiProQueInteressa() {
        gSessao.setLogin(true);

        Intent intent = new Intent(InicioActivity.this, PlacarActivity.class);
        startActivity(intent);
        finish();
    }*/
}
