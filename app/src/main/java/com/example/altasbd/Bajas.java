package com.example.altasbd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Bajas extends AppCompatActivity {
    private EditText ed1, ed2, ed3, ed4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bajas);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        ed4 = findViewById(R.id.ed4);
    }
    public void bajas (View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);//Crear la clase
        SQLiteDatabase bd = admin.getWritableDatabase();
        String nc = ed1.getText().toString();
        int cant = bd.delete("alumno","numcontrol="+nc, null);//Para saber la cantidad que retorna y si da 1 se elimina
        if(cant ==1){
            Toast.makeText(this, "Alumno eliminado", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Alumno no encontrado", Toast.LENGTH_SHORT).show();
        }
        bd.close();

    }
    public void mlimpiar(View view){

        limpiar();
    }

    public void limpiar() {
        ed1.setText("");
        ed2.setText("");
        ed3.setText("");
        ed4.setText("");
    }
    public void busqueda (View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);//Crear la clase
        SQLiteDatabase bd = admin.getWritableDatabase();
        String nc = ed1.getText().toString();
        Cursor fila = bd.rawQuery("select nombre, semestre, carrera from alumno where numcontrol ="+nc, null);
        if (fila.moveToFirst()){
            ed2.setText(fila.getString(0));
            ed3.setText(fila.getString(1));
            ed4.setText(fila.getString(2));
        }
        else{
            Toast.makeText(this, "No existe ningun alumno con ese numero de control", Toast.LENGTH_SHORT).show();
            bd.close();
        }

    }
}