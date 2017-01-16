package com.luke.unoplacar.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.luke.unoplacar.entidade.Jogador;
import com.luke.unoplacar.entidade.Jogo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mrluke on 12/01/2017.
 */

public class JogoDAO {

    UnoDBHelper unoHelper;

    public JogoDAO(Context context) {
        this.unoHelper = new UnoDBHelper(context);
    }

    public void salvarJogo(Jogo jogo){

        SQLiteDatabase db = unoHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("numero_partidas", jogo.getNumeroPartidas());
        values.put("qtd_jogadores", jogo.getQtdJogadores());
        values.put("media_pontos", jogo.getMediaPontos());
        db.close();
    }

    public void excluirJogo(Jogo jogo){

        SQLiteDatabase db = unoHelper.getWritableDatabase();
        String[] args = new String[]{jogo.getId().toString()};

        db.delete("jogo", "id = ?", args);
        db.close();
    }

    public List<Jogo> getListaJogos(){

        SQLiteDatabase db = unoHelper.getReadableDatabase();
        String sql_select = "SELECT * FROM jogo";
        String[] args = null;
        Cursor cursor = db.rawQuery(sql_select, args);

        ArrayList<Jogo> listaJogo = new ArrayList<>();

        while(cursor.moveToNext()){

            Jogo jogo = new Jogo();

            jogo.setId(cursor.getLong(0));
            jogo.setNumeroPartidas(cursor.getInt(1));
            jogo.setQtdJogadores(cursor.getInt(2));
            jogo.setMediaPontos(cursor.getInt(3));

            listaJogo.add(jogo);
        }
        db.close();

        return listaJogo;
    }
}
