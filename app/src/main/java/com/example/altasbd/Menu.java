package com.example.altasbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Menu extends AppCompatActivity {
    private EditText ed1, ed2, ed3, ed4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        ed4 = findViewById(R.id.ed4);
    }

    public void altas(View view) {
        //Construccion
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);//Crear la clase
        SQLiteDatabase bd = admin.getWritableDatabase();
        //Hacer alta
        String nc = ed1.getText().toString();
        String nom = ed2.getText().toString();
        String sem = ed3.getText().toString();
        String ca = ed4.getText().toString();

        ContentValues registro = new ContentValues();//Hacer una pila
        registro.put("numcontrol", nc);//Como en la base de datos el de comillas
        registro.put("nombre", nom);
        registro.put("semestre", sem);
        registro.put("carrera", ca);

        //Insertar los valores en la BD
        bd.insert("alumno", null, registro);
        bd.close();//Se cierra para poder seguir registrando

        Toast.makeText(this, "Datos registrados con exito", Toast.LENGTH_SHORT).show();//Para mandar mensajes emergentes
        this.limpiar();//Metodo de limpiar


    }

    public void mlimpiar(View view) {

        limpiar();
    }

    public void limpiar() {
        ed1.setText("");
        ed2.setText("");
        ed3.setText("");
        ed4.setText("");
    }

    public void busqueda(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);//Crear la clase
        SQLiteDatabase bd = admin.getWritableDatabase();
        String nc = ed1.getText().toString();
        Cursor fila = bd.rawQuery("select nombre, semestre, carrera from alumno where numcontrol =" + nc, null);
        if (fila.moveToFirst()) {
            ed2.setText(fila.getString(0));
            ed3.setText(fila.getString(1));
            ed4.setText(fila.getString(2));
        } else {
            Toast.makeText(this, "No existe ningun alumno con ese numero de control", Toast.LENGTH_SHORT).show();
            bd.close();
        }
    }
}