package com.luke.unoplacar.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.luke.unoplacar.R;
import com.luke.unoplacar.activitys.PlacarActivity;
import com.luke.unoplacar.entidade.Jogador;

import java.util.List;

/**
 * Created by Mrluke on 13/01/2017.
 */

public class JogadoresAdapter extends BaseAdapter {

    private List<Jogador> listaJogadores;
    private Activity activity;

    public JogadoresAdapter(List<Jogador> listaJogadores, PlacarActivity placarActivity) {
        this.listaJogadores = listaJogadores;
        this.activity = placarActivity;
    }

    @Override
    public int getCount() {
        return listaJogadores.size();
    }

    @Override
    public Object getItem(int position) {
        return listaJogadores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaJogadores.get(position).getId();
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {

        Jogador jogador = listaJogadores.get(posicao);

        LayoutInflater inflater = activity.getLayoutInflater();
        View linha = inflater.inflate(R.layout.item_jogador_placar, null);

        TextView txtNomeJogador = (TextView) linha.findViewById(R.id.txtNomeJogador);
        txtNomeJogador.setText(jogador.getNome());

        TextView txtPontuacao = (TextView) linha.findViewById(R.id.txtPontuacao);
        txtPontuacao.setText("" + jogador.getPontuacao() + " pts.");

        return linha;
    }
}
