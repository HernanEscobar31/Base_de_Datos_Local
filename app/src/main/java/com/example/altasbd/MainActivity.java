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

public class MainActivity extends AppCompatActivity {
    private EditText ed1, ed2, ed3, ed4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        ed4 = findViewById(R.id.ed4);
    }



    public void btnaltas(View view) {
        Intent v1 = new Intent(MainActivity.this,Menu.class);
        startActivity(v1);
    }
    public void btnbajas(View view) {
        Intent v2 = new Intent(MainActivity.this,Bajas.class);
        startActivity(v2);
    }
    public void btncambios(View view) {
        Intent v3 = new Intent(MainActivity.this,Modificar.class);
        startActivity(v3);
    }
}

