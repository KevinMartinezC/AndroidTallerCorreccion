package com.example.androidtaller1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InicioActivity extends AppCompatActivity {

    CardView c1, c2, c3;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        c1 = findViewById(R.id.card);
        c2 = findViewById(R.id.card2);
        c3 = findViewById(R.id.card3);
        b1 = findViewById(R.id.cerrar);
        c1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Intent intent= new Intent(InicioActivity.this,Ejercicio1.class);
                startActivity(intent);
            }
        });
        c2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Intent intent= new Intent(InicioActivity.this,Ejercicio2.class);
                startActivity(intent);
            }
        });
        c3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Intent intent= new Intent(InicioActivity.this,Ejercicio3.class);
                startActivity(intent);
            }
        });

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Intent intent= new Intent(InicioActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }


}