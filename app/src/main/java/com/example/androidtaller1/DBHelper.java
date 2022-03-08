package com.example.androidtaller1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) { super(context,"Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table usuarios(usuarionombre Text primary key, contra Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
        myDB.execSQL("drop Table if exists usuarios");

    }
    public Boolean insertarDatos(String usuarionombre,String contra){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("usuarionombre", usuarionombre);
        contentValues.put("contra", contra);
        long result = myDB.insert("usuarios", null,contentValues);

        if(result == -1){
            return  false;
        }else {
            return true;
        }
    }
    public Boolean checkNombreUsuario(String usuarionombre){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from usuarios where usuarionombre = ?",new String[] {usuarionombre});

        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }

    }
    public Boolean checkNombreusuarioContra(String usuarionombre,String contra){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from usuarios where usuarionombre = ? and contra =?",new String[]{usuarionombre,contra});

        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }

}