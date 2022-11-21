package com.example.altasbd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//Esqueleto de Base de datos
import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {//Creo los metodos super o constructor
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }//Extiendo el SQLite
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {//Creo los metotdos y el ONCREATE crea la tabla
        sqLiteDatabase.execSQL("create table alumno(numcontrol intenger primary key, nombre text, semestre integer, carrera text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {//Aqui se refresca la BD
        sqLiteDatabase.execSQL("drop table if exists alumno");
        sqLiteDatabase.execSQL("create table alumno(numcontrol integer primary key, nombre text, semestre integer, carrera text)");

    }
}
