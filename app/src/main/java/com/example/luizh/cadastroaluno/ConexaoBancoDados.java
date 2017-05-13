package com.example.luizh.cadastroaluno;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by luizh on 07/04/2017.
 */

public class ConexaoBancoDados extends SQLiteOpenHelper {

    private static final String DATABASE = "Happy";
    private static final String TABLE = "student";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PHONE = "phone";
    private static final int VERSION = 1;

    private ConexaoBancoDados banco;

    private static SQLiteDatabase conn;

    public static SQLiteDatabase getInstance(){
        return conn;
    }

    public ConexaoBancoDados(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        conn = getWritableDatabase();
    }

    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE "+TABLE+"("
                + ID + " integer primary key autoincrement,"
                + NAME + " varchar(200),"
                + PHONE + " varchar(30)"
                +")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+ TABLE);
        onCreate(db);
    }
}