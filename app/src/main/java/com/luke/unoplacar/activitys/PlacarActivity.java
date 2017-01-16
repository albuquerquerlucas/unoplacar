package com.luke.unoplacar.activitys;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.luke.unoplacar.R;
import com.luke.unoplacar.adapter.JogadoresAdapter;
import com.luke.unoplacar.entidade.Jogador;
import com.luke.unoplacar.helper.GerenciadorDeSessao;
import com.luke.unoplacar.helper.JogadoresDAO;
import com.luke.unoplacar.helper.UnoDBHelper;

import java.util.List;

public class PlacarActivity extends AppCompatActivity {

    //private GerenciadorDeSessao gSessao;

    private ListView lista;
    public Jogador jogadorParaPosicao;
    public Jogador jogadorMaiorPontuacao;
    public Jogador jogadorSegundoMaiorPontuacao;
    private TextView txtPerdedor;
    private ImageView imgGracinha;

    int maior = 0;
    String loser;
    int metadePontuacaoParaPerdedor;
    String perdedorzim;
    int valorTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placar);

        //gSessao = new GerenciadorDeSessao(getApplicationContext());

        /*if (!gSessao.isLoggedIn()) {
            vaiProQueInteressa();
        }*/

    }

    @Override
    protected void onResume() {
        super.onResume();

        txtPerdedor = (TextView) findViewById(R.id.txtPerdedor);
        imgGracinha = (ImageView) findViewById(R.id.imgGracinha);

        carregaListaJogadores();
    }

    public void carregaListaJogadores(){

        JogadoresDAO jogadoresDAO = new JogadoresDAO(this);
        List<Jogador> listaJogadores = jogadoresDAO.getListaJogadores();

        for (Jogador jogador : listaJogadores) {
            if(jogador.getPontuacao() >= maior){
                maior = jogador.getPontuacao();
                perdedorzim = jogador.getNome();
            }
        }

        if(maior == 0){
            txtPerdedor.setText("");
            imgGracinha.setImageDrawable(null);
        }else{
            metadePontuacaoParaPerdedor = pontuacaoDoPerdedor(maior);
            loser = "Perdedorzim: " + perdedorzim;
            txtPerdedor.setText(loser);
            imgGracinha.setImageDrawable(getDrawable(R.drawable.emoj));
        }

        //System.out.println("Maior: " + maior);
        //System.out.println("PERDEDOR: " + perdedorzim);

        /*valorTotal = 0;
        for(int i=0; i < listaJogadores.size(); i++){
            Jogador jogador = listaJogadores.get(i);
            valorTotal = valorTotal + jogador.getPontuacao();

        }*/

        //System.out.println("VT SOMATÓRIO Do FOR: " + valorTotal);

        //int mediaPlacar = media(valorTotal);
        //txtPerdedor.setText(String.valueOf(mediaPlacar));



        JogadoresAdapter adapter = new JogadoresAdapter(listaJogadores, this);

        lista = (ListView) findViewById(R.id.listaPlacar);
        lista.setAdapter(adapter);

        clicksNaLista();
    }

    public void clicksNaLista() {

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int posicaoNaLista, long idDaLista) {

                jogadorParaPosicao = (Jogador) adapter.getItemAtPosition(posicaoNaLista);
                jogadorMaiorPontuacao = (Jogador) adapter.getItemAtPosition(0);
                jogadorSegundoMaiorPontuacao = (Jogador) adapter.getItemAtPosition(1);

                /*if(jogadorMaiorPontuacao.getPontuacao() > jogadorSegundoMaiorPontuacao.getPontuacao()){
                    perdedor = jogadorMaiorPontuacao.getNome();

                }else{
                    perdedor = jogadorSegundoMaiorPontuacao.getNome();
                }*/
                //Toast.makeText(PlacarActivity.this, "Selecionou " + adapter.getItemAtPosition(posicaoNaLista), Toast.LENGTH_SHORT).show();

                Intent itPontuar = new Intent(PlacarActivity.this, PontuarActivity.class);

                itPontuar.putExtra("jogador", jogadorParaPosicao);
                startActivity(itPontuar);
                //finish();
                /* OBSERVAÇÂO

                    - retornando FALSE, é chamado tanto o click curto quanto o longo...
                        - retornando o TRUE, é chamado apenas o click longo...
                */

                // retornando o FALSE, eu possibilito a chamada do menú de contexto.
                return false;
            }
        });
    }

    public int pontuacaoDoPerdedor(int maior){

        //System.out.println("VALOR TOTAL IN: " + maior);

        int numMedia = 0;

        if((maior % 2) == 0){
            numMedia = maior / 2;
        }else{
            numMedia = (maior + 1) / 2;
        }
        //System.out.println("MEDIA: " + numMedia);

        return numMedia;
    }

    /*public int media(int valorTotal){

        System.out.println("VALOR TOTAL IN: " + valorTotal);

        int numMedia = 0;

        if((valorTotal % 2) == 0){
            numMedia = valorTotal / 2;
        }else{
            numMedia = (valorTotal + 1) / 2;
        }
        System.out.println("MEDIA: " + numMedia);
        return numMedia;
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.opcoesdeplacar, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemClicado = item.getItemId();
        UnoDBHelper unoDBHelper;

        switch (itemClicado) {

            case R.id.mNovoJogo:

                unoDBHelper = new UnoDBHelper(PlacarActivity.this);
                unoDBHelper.deletarTabelas();

                Intent itInicio = new Intent(PlacarActivity.this, InicioActivity.class);
                startActivity(itInicio);
                finish();
            break;

            case R.id.mAddJogador:
                Intent itNovoJogador = new Intent(PlacarActivity.this, NovoJogadorActivity.class);
                Bundle parametros = new Bundle();
                parametros.putInt("mediaPontuacaoPerdedor", metadePontuacaoParaPerdedor);
                itNovoJogador.putExtras(parametros);
                startActivity(itNovoJogador);
            break;

            case R.id.mZerarPlacar:

                JogadoresDAO jogadoresDAO = jogadoresDAO = new JogadoresDAO(PlacarActivity.this);
                jogadoresDAO.resetarPlacar();

                maior = 0;
                loser = "";
                txtPerdedor.setText("");

                carregaListaJogadores();
            break;

            case R.id.mDeletarBanco:
                unoDBHelper = new UnoDBHelper(PlacarActivity.this);
                unoDBHelper.deletarTabelas();

                finish();
            break;

            case R.id.mSobreApp:
                Intent itSobre = new Intent(PlacarActivity.this, SobreActivity.class);
                startActivity(itSobre);
            break;
        }

        return super.onOptionsItemSelected(item);
    }

    /*private void vaiProQueInteressa() {
        gSessao.setLogin(false);

        Intent intent = new Intent(PlacarActivity.this, InicioActivity.class);
        startActivity(intent);
        finish();
    }*/

    @Override
    public void onBackPressed() {
        return;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        /*UnoDBHelper noDBHelper = new UnoDBHelper(PlacarActivity.this);
        noDBHelper.deletarTabelas();*/
        finish();
    }
}
