package com.luke.unoplacar.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.luke.unoplacar.R;
import com.luke.unoplacar.entidade.Jogador;
import com.luke.unoplacar.entidade.Jogo;
import com.luke.unoplacar.helper.JogadoresDAO;
import com.luke.unoplacar.helper.JogoDAO;

public class JogadoresActivity extends AppCompatActivity implements View.OnClickListener{

    public EditText edtJogador1;
    public EditText edtJogador2;
    public EditText edtJogador3;
    public EditText edtJogador4;
    public EditText edtJogador5;
    public EditText edtJogador6;
    public EditText edtJogador7;
    public EditText edtJogador8;

    public Button btnAddJogador1;
    public Button btnAddJogador2;
    public Button btnAddJogador3;
    public Button btnAddJogador4;
    public Button btnAddJogador5;
    public Button btnAddJogador6;
    public Button btnAddJogador7;
    public Button btnAddJogador8;

    public Button btnExcJogador1;
    public Button btnExcJogador2;
    public Button btnExcJogador3;
    public Button btnExcJogador4;
    public Button btnExcJogador5;
    public Button btnExcJogador6;
    public Button btnExcJogador7;
    public Button btnExcJogador8;

    public Button btnIniciarPartida;

    private Jogo jogo;
    private JogoDAO jogoDAO;
    private ListView lista;
    public Jogo jogoParaPosicao;
    int qtdJogadores = 0;

    public String j1, j2, j3, j4, j5, j6, j7, j8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogadores);

        Intent it = getIntent();
        Bundle args = it.getExtras();
        qtdJogadores = Integer.parseInt(args.getString("qtdJogadores"));

    }

    @Override
    protected void onResume() {
        super.onResume();

        carregaSelecaoJogadores();
    }

    public void carregaSelecaoJogadores(){

        edtJogador1 = (EditText) findViewById(R.id.edtJogador1);
        edtJogador2 = (EditText) findViewById(R.id.edtJogador2);
        edtJogador3 = (EditText) findViewById(R.id.edtJogador3);
        edtJogador4 = (EditText) findViewById(R.id.edtJogador4);
        edtJogador5 = (EditText) findViewById(R.id.edtJogador5);
        edtJogador6 = (EditText) findViewById(R.id.edtJogador6);
        edtJogador7 = (EditText) findViewById(R.id.edtJogador7);
        edtJogador8 = (EditText) findViewById(R.id.edtJogador8);

        btnAddJogador1 = (Button) findViewById(R.id.btnAddJogador1);
        btnAddJogador1.setOnClickListener(this);

        btnAddJogador2 = (Button) findViewById(R.id.btnAddJogador2);
        btnAddJogador2.setOnClickListener(this);

        btnAddJogador3 = (Button) findViewById(R.id.btnAddJogador3);
        btnAddJogador3.setOnClickListener(this);

        btnAddJogador4 = (Button) findViewById(R.id.btnAddJogador4);
        btnAddJogador4.setOnClickListener(this);

        btnAddJogador5 = (Button) findViewById(R.id.btnAddJogador5);
        btnAddJogador5.setOnClickListener(this);

        btnAddJogador6 = (Button) findViewById(R.id.btnAddJogador6);
        btnAddJogador6.setOnClickListener(this);

        btnAddJogador7 = (Button) findViewById(R.id.btnAddJogador7);
        btnAddJogador7.setOnClickListener(this);

        btnAddJogador8 = (Button) findViewById(R.id.btnAddJogador8);
        btnAddJogador8.setOnClickListener(this);

        btnExcJogador1 = (Button) findViewById(R.id.btnExcJogador1);
        btnExcJogador1.setOnClickListener(this);

        btnExcJogador2 = (Button) findViewById(R.id.btnExcJogador2);
        btnExcJogador2.setOnClickListener(this);

        btnExcJogador3 = (Button) findViewById(R.id.btnExcJogador3);
        btnExcJogador3.setOnClickListener(this);

        btnExcJogador4 = (Button) findViewById(R.id.btnExcJogador4);
        btnExcJogador4.setOnClickListener(this);

        btnExcJogador5 = (Button) findViewById(R.id.btnExcJogador5);
        btnExcJogador5.setOnClickListener(this);

        btnExcJogador6 = (Button) findViewById(R.id.btnExcJogador6);
        btnExcJogador6.setOnClickListener(this);

        btnExcJogador7 = (Button) findViewById(R.id.btnExcJogador7);
        btnExcJogador7.setOnClickListener(this);

        btnExcJogador8 = (Button) findViewById(R.id.btnExcJogador8);
        btnExcJogador8.setOnClickListener(this);

        btnIniciarPartida = (Button) findViewById(R.id.btnIniciarPartida);
        btnIniciarPartida.setOnClickListener(this);

        if(qtdJogadores == 2){
            edtJogador2.setImeOptions(0);

            edtJogador3.setVisibility(View.INVISIBLE);
            btnAddJogador3.setVisibility(View.INVISIBLE);
            btnExcJogador3.setVisibility(View.INVISIBLE);
            edtJogador4.setVisibility(View.INVISIBLE);
            btnAddJogador4.setVisibility(View.INVISIBLE);
            btnExcJogador4.setVisibility(View.INVISIBLE);
            edtJogador5.setVisibility(View.INVISIBLE);
            btnAddJogador5.setVisibility(View.INVISIBLE);
            btnExcJogador5.setVisibility(View.INVISIBLE);
            edtJogador6.setVisibility(View.INVISIBLE);
            btnAddJogador6.setVisibility(View.INVISIBLE);
            btnExcJogador6.setVisibility(View.INVISIBLE);
            edtJogador7.setVisibility(View.INVISIBLE);
            btnAddJogador7.setVisibility(View.INVISIBLE);
            btnExcJogador7.setVisibility(View.INVISIBLE);
            edtJogador8.setVisibility(View.INVISIBLE);
            btnAddJogador8.setVisibility(View.INVISIBLE);
            btnExcJogador8.setVisibility(View.INVISIBLE);
        }else if(qtdJogadores == 3){
            edtJogador3.setVisibility(View.VISIBLE);
            btnAddJogador3.setVisibility(View.VISIBLE);
            btnExcJogador3.setVisibility(View.VISIBLE);

            edtJogador3.setImeOptions(0);

            edtJogador4.setVisibility(View.INVISIBLE);
            btnAddJogador4.setVisibility(View.INVISIBLE);
            btnExcJogador4.setVisibility(View.INVISIBLE);
            edtJogador5.setVisibility(View.INVISIBLE);
            btnAddJogador5.setVisibility(View.INVISIBLE);
            btnExcJogador5.setVisibility(View.INVISIBLE);
            edtJogador6.setVisibility(View.INVISIBLE);
            btnAddJogador6.setVisibility(View.INVISIBLE);
            btnExcJogador6.setVisibility(View.INVISIBLE);
            edtJogador7.setVisibility(View.INVISIBLE);
            btnAddJogador7.setVisibility(View.INVISIBLE);
            btnExcJogador7.setVisibility(View.INVISIBLE);
            edtJogador8.setVisibility(View.INVISIBLE);
            btnAddJogador8.setVisibility(View.INVISIBLE);
            btnExcJogador8.setVisibility(View.INVISIBLE);
        }else if(qtdJogadores == 4){
            edtJogador4.setVisibility(View.VISIBLE);
            btnAddJogador4.setVisibility(View.VISIBLE);
            btnExcJogador4.setVisibility(View.VISIBLE);

            edtJogador4.setImeOptions(0);

            edtJogador5.setVisibility(View.INVISIBLE);
            btnAddJogador5.setVisibility(View.INVISIBLE);
            btnExcJogador5.setVisibility(View.INVISIBLE);
            edtJogador6.setVisibility(View.INVISIBLE);
            btnAddJogador6.setVisibility(View.INVISIBLE);
            btnExcJogador6.setVisibility(View.INVISIBLE);
            edtJogador7.setVisibility(View.INVISIBLE);
            btnAddJogador7.setVisibility(View.INVISIBLE);
            btnExcJogador7.setVisibility(View.INVISIBLE);
            edtJogador8.setVisibility(View.INVISIBLE);
            btnAddJogador8.setVisibility(View.INVISIBLE);
            btnExcJogador8.setVisibility(View.INVISIBLE);
        }else if(qtdJogadores == 5){
            edtJogador5.setVisibility(View.VISIBLE);
            btnAddJogador5.setVisibility(View.VISIBLE);
            btnExcJogador5.setVisibility(View.VISIBLE);

            edtJogador5.setImeOptions(0);

            edtJogador6.setVisibility(View.INVISIBLE);
            btnAddJogador6.setVisibility(View.INVISIBLE);
            btnExcJogador6.setVisibility(View.INVISIBLE);
            edtJogador7.setVisibility(View.INVISIBLE);
            btnAddJogador7.setVisibility(View.INVISIBLE);
            btnExcJogador7.setVisibility(View.INVISIBLE);
            edtJogador8.setVisibility(View.INVISIBLE);
            btnAddJogador8.setVisibility(View.INVISIBLE);
            btnExcJogador8.setVisibility(View.INVISIBLE);
        }else if(qtdJogadores == 6){
            edtJogador6.setVisibility(View.VISIBLE);
            btnAddJogador6.setVisibility(View.VISIBLE);
            btnExcJogador6.setVisibility(View.VISIBLE);

            edtJogador6.setImeOptions(0);

            edtJogador7.setVisibility(View.INVISIBLE);
            btnAddJogador7.setVisibility(View.INVISIBLE);
            btnExcJogador7.setVisibility(View.INVISIBLE);
            edtJogador8.setVisibility(View.INVISIBLE);
            btnAddJogador8.setVisibility(View.INVISIBLE);
            btnExcJogador8.setVisibility(View.INVISIBLE);
        }else if(qtdJogadores == 7){
            edtJogador7.setVisibility(View.VISIBLE);
            btnAddJogador7.setVisibility(View.VISIBLE);
            btnExcJogador7.setVisibility(View.VISIBLE);

            edtJogador7.setImeOptions(0);

            edtJogador8.setVisibility(View.INVISIBLE);
            btnAddJogador8.setVisibility(View.INVISIBLE);
            btnExcJogador8.setVisibility(View.INVISIBLE);
        }else if(qtdJogadores == 8){
            // Implements
            edtJogador8.setVisibility(View.VISIBLE);
            btnAddJogador8.setVisibility(View.VISIBLE);
            btnExcJogador8.setVisibility(View.VISIBLE);

            edtJogador8.setImeOptions(0);
        }else{
            // Implements
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnAddJogador1:
                j1 = edtJogador1.getText().toString();
                edtJogador1.setEnabled(false);
                edtJogador1.setTextColor(Integer.valueOf(R.color.cor_edt_desabilitado));
                break;

            case R.id.btnAddJogador2:
                j2 = edtJogador2.getText().toString();
                edtJogador2.setEnabled(false);
                edtJogador2.setTextColor(Integer.valueOf(R.color.cor_edt_desabilitado));
                break;

            case R.id.btnAddJogador3:
                j3 = edtJogador3.getText().toString();
                edtJogador3.setEnabled(false);
                edtJogador3.setTextColor(Integer.valueOf(R.color.cor_edt_desabilitado));
                break;

            case R.id.btnAddJogador4:
                j4 = edtJogador4.getText().toString();
                edtJogador4.setEnabled(false);
                edtJogador4.setTextColor(Integer.valueOf(R.color.cor_edt_desabilitado));
                break;

            case R.id.btnAddJogador5:
                j5 = edtJogador5.getText().toString();
                edtJogador5.setEnabled(false);
                edtJogador5.setTextColor(Integer.valueOf(R.color.cor_edt_desabilitado));
                break;

            case R.id.btnAddJogador6:
                j6 = edtJogador6.getText().toString();
                edtJogador6.setEnabled(false);
                edtJogador6.setTextColor(Integer.valueOf(R.color.cor_edt_desabilitado));
                break;

            case R.id.btnAddJogador7:
                j7 = edtJogador7.getText().toString();
                edtJogador7.setEnabled(false);
                edtJogador7.setTextColor(Integer.valueOf(R.color.cor_edt_desabilitado));
                break;

            case R.id.btnAddJogador8:
                j8 = edtJogador8.getText().toString();
                edtJogador8.setEnabled(false);
                edtJogador8.setTextColor(Integer.valueOf(R.color.cor_edt_desabilitado));
                break;

            case R.id.btnExcJogador1:
                edtJogador1.setEnabled(true);
                edtJogador1.setTextColor(Integer.valueOf(R.color.vermelho));
                edtJogador1.setText("");
                break;

            case R.id.btnExcJogador2:
                edtJogador2.setEnabled(true);
                edtJogador2.setTextColor(Integer.valueOf(R.color.vermelho));
                edtJogador2.setText("");
                break;

            case R.id.btnExcJogador3:
                edtJogador3.setEnabled(true);
                edtJogador3.setTextColor(Integer.valueOf(R.color.vermelho));
                edtJogador3.setText("");
                break;

            case R.id.btnExcJogador4:
                edtJogador4.setEnabled(true);
                edtJogador4.setTextColor(Integer.valueOf(R.color.vermelho));
                edtJogador4.setText("");
                break;

            case R.id.btnExcJogador5:
                edtJogador5.setEnabled(true);
                edtJogador5.setTextColor(Integer.valueOf(R.color.vermelho));
                edtJogador5.setText("");
                break;

            case R.id.btnExcJogador6:
                edtJogador6.setEnabled(true);
                edtJogador6.setTextColor(Integer.valueOf(R.color.vermelho));
                edtJogador6.setText("");
                break;

            case R.id.btnExcJogador7:
                edtJogador7.setEnabled(true);
                edtJogador7.setTextColor(Integer.valueOf(R.color.vermelho));
                edtJogador7.setText("");
                break;

            case R.id.btnExcJogador8:
                edtJogador8.setEnabled(true);
                edtJogador8.setTextColor(Integer.valueOf(R.color.vermelho));
                edtJogador8.setText("");
                break;

            case R.id.btnIniciarPartida:

                //String controle1 = "Tela Jogadores";

                j1 = edtJogador1.getText().toString();
                j2 = edtJogador2.getText().toString();

                if(j1.isEmpty() || j2.isEmpty()){
                    Toast.makeText(this, "Preenha com o nome dos jogadores.", Toast.LENGTH_SHORT).show();
                }else{

                    /*Jogo jogo = new Jogo(0, 0, 0);
                    JogoDAO jogoDAO = new JogoDAO(JogadoresActivity.this);
                    jogoDAO.salvarJogo(jogo);*/

                    if(!edtJogador1.getText().toString().isEmpty()){
                        Jogador jogador = new Jogador(edtJogador1.getText().toString(), 0, 0);
                        JogadoresDAO jogadoresDAO = new JogadoresDAO(JogadoresActivity.this);
                        jogadoresDAO.salvarJogador(jogador);
                    }

                    if(!edtJogador2.getText().toString().isEmpty()){
                        Jogador jogador = new Jogador(edtJogador2.getText().toString(), 0, 0);
                        JogadoresDAO jogadoresDAO = new JogadoresDAO(JogadoresActivity.this);
                        jogadoresDAO.salvarJogador(jogador);
                    }

                    if(!edtJogador3.getText().toString().isEmpty()){
                        Jogador jogador = new Jogador(edtJogador3.getText().toString(), 0, 0);
                        JogadoresDAO jogadoresDAO = new JogadoresDAO(JogadoresActivity.this);
                        jogadoresDAO.salvarJogador(jogador);
                    }

                    if(!edtJogador4.getText().toString().isEmpty()){
                        Jogador jogador = new Jogador(edtJogador4.getText().toString(), 0, 0);
                        JogadoresDAO jogadoresDAO = new JogadoresDAO(JogadoresActivity.this);
                        jogadoresDAO.salvarJogador(jogador);
                    }

                    if(!edtJogador5.getText().toString().isEmpty()){
                        Jogador jogador = new Jogador(edtJogador5.getText().toString(), 0, 0);
                        JogadoresDAO jogadoresDAO = new JogadoresDAO(JogadoresActivity.this);
                        jogadoresDAO.salvarJogador(jogador);
                    }

                    if(!edtJogador6.getText().toString().isEmpty()){
                        Jogador jogador = new Jogador(edtJogador6.getText().toString(), 0, 0);
                        JogadoresDAO jogadoresDAO = new JogadoresDAO(JogadoresActivity.this);
                        jogadoresDAO.salvarJogador(jogador);
                    }

                    if(!edtJogador7.getText().toString().isEmpty()){
                        Jogador jogador = new Jogador(edtJogador7.getText().toString(), 0, 0);
                        JogadoresDAO jogadoresDAO = new JogadoresDAO(JogadoresActivity.this);
                        jogadoresDAO.salvarJogador(jogador);
                    }

                    if(!edtJogador8.getText().toString().isEmpty()){
                        Jogador jogador = new Jogador(edtJogador8.getText().toString(), 0, 0);
                        JogadoresDAO jogadoresDAO = new JogadoresDAO(JogadoresActivity.this);
                        jogadoresDAO.salvarJogador(jogador);
                    }

                    Intent itPlacar = new Intent(JogadoresActivity.this, PlacarActivity.class);
                    startActivity(itPlacar);

                    finish();
                }

                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.opcoes, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemClicado = item.getItemId();

        switch (itemClicado) {
            case R.id.mNovoJogo:

                finish();

            break;

            case R.id.mAddJogador:

                if(qtdJogadores < 8){
                    qtdJogadores++;
                    carregaSelecaoJogadores();
                }else{
                    Toast.makeText(JogadoresActivity.this, "A App suporta no máximo 8 jogadores.", Toast.LENGTH_SHORT).show();
                }
            break;

            case R.id.mExcJogador:

                if(qtdJogadores > 2){
                    qtdJogadores--;
                    carregaSelecaoJogadores();
                }else{
                    Toast.makeText(JogadoresActivity.this, "É necessário no mínimo 2 jogadores.", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.mLimpar:
                resetarTodosOsJogadores();
            break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void resetarTodosOsJogadores(){
        edtJogador1.setText("");
        edtJogador2.setText("");
        edtJogador3.setText("");
        edtJogador4.setText("");
        edtJogador5.setText("");
        edtJogador6.setText("");
        edtJogador7.setText("");
        edtJogador8.setText("");
    }

    @Override
    public void onBackPressed() {
        return;
    }
}
