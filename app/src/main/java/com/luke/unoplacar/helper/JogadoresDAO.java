package com.luke.unoplacar.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.luke.unoplacar.entidade.Jogador;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mrluke on 12/01/2017.
 */

public class JogadoresDAO {

    UnoDBHelper unoHelper;

    public JogadoresDAO(Context context) {
        this.unoHelper = new UnoDBHelper(context);
    }

    public void salvarJogador(Jogador jogador){

        SQLiteDatabase db = unoHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("nome", jogador.getNome());
        values.put("pontuacao", jogador.getPontuacao());
        values.put("is_novo", jogador.getIsNovo());

        db.insert("jogadores", null, values);
        db.close();
    }

    public void alterarJogador(Jogador jogador){

        SQLiteDatabase db = unoHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("nome", jogador.getNome());
        values.put("pontuacao", jogador.getPontuacao());
        values.put("is_novo", jogador.getIsNovo());

        String[] args = new String[]{jogador.getId().toString()};
        db.update("jogadores", values, "id = ?", args);
        db.close();
    }

    public void excluirJogador(Jogador jogador){

        SQLiteDatabase db = unoHelper.getWritableDatabase();
        String[] args = new String[]{jogador.getId().toString()};

        db.delete("jogadores", "id = ?", args);
        db.close();
    }

    public void resetarPlacar(){

        SQLiteDatabase db = unoHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("pontuacao", 0);

        String[] args = null;
        db.update("jogadores", values, null, args);
        db.close();
    }

    public List<Jogador> getListaJogadores(){

        SQLiteDatabase db = unoHelper.getReadableDatabase();
        String sql_select = "SELECT * FROM jogadores ORDER BY pontuacao DESC";
        String[] args = null;
        Cursor cursor = db.rawQuery(sql_select, args);

        ArrayList<Jogador> listaJogadores = new ArrayList<>();

        while(cursor.moveToNext()){

            Jogador jogador = new Jogador();

            jogador.setId(cursor.getLong(0));
            jogador.setNome(cursor.getString(1));
            jogador.setPontuacao(cursor.getInt(2));
            jogador.setIsNovo(cursor.getInt(3));

            listaJogadores.add(jogador);
        }
        db.close();

        return listaJogadores;
    }
}
