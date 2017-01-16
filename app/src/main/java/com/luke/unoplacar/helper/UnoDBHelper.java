package com.luke.unoplacar.helper;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Mrluke on 12/01/2017.
 */

public class UnoDBHelper extends SQLiteOpenHelper {

    private final static String NOME_BANCO = "unodb";
    private final static int VERSAO_BANCO = 1;
    private final static String TABELA_JOGADORES = "jogadores";
    private final static String TABELA_JOGO = "jogo";

    public UnoDBHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            String sql_create_table_jogadores = "CREATE TABLE " + TABELA_JOGADORES + " (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nome TEXT, " +
                    "pontuacao INTEGER, " +
                    "is_novo INTEGER)";

            db.execSQL(sql_create_table_jogadores);

            String sql_create_table_jogo = "CREATE TABLE " + TABELA_JOGO + " (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "numero_partidas INTEGER, " +
                    "qtd_jogadores INTEGER, " +
                    "media_pontos INTEGER)";

            db.execSQL(sql_create_table_jogo);

            Log.i(UnoDBHelper.class.getName(), "Tabelas criadas com sucesso!");

        }catch (SQLException e){
            Log.e(UnoDBHelper.class.getName(), "Erro ao criar as tabelas", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versaoAtual, int versaoNova) {

        try {
            String sql_drop_table_jogadores = "DROP TABLE IF EXISTS jogadores";
            db.execSQL(sql_drop_table_jogadores);

            String sql_drop_table_jogo = "DROP TABLE IF EXISTS jogadores";
            db.execSQL(sql_drop_table_jogo);

            this.onCreate(db);

            Log.i(UnoDBHelper.class.getName(), "Tabelas atualizadas com sucesso!");
        }catch (SQLException e){
            Log.e(UnoDBHelper.class.getName(), "Erro ao deletar as tabelas", e);
            throw new RuntimeException(e);
        }
    }

    public void deletarTabelas(){

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABELA_JOGADORES, null, null);
        db.delete(TABELA_JOGO, null, null);
        db.close();
    }
}
