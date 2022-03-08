package com.example.androidtaller1;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usuarioNombre, contra;
    Button btnInicioSeccion;
    TextView registrarse;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioNombre = (EditText)  findViewById(R.id.nombreUsuarioInicio);
        contra= (EditText)  findViewById(R.id.contrasenaInicio);
        btnInicioSeccion = (Button)  findViewById(R.id.btn_inicioSeccion);
        registrarse = (TextView) findViewById(R.id.registrarse);

        myDB = new DBHelper(this);

        btnInicioSeccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario= usuarioNombre.getText().toString();
                String contrasena = contra.getText().toString();

                if(usuario.equals("") || contrasena.equals("")){
                    Toast.makeText(MainActivity.this, "Complete todos los datos, para iniciar sesión", Toast.LENGTH_SHORT).show();
                }else
                {
                    Boolean result= myDB.checkNombreusuarioContra(usuario,contrasena);

                    if(result == true){
                        Intent intent = new Intent(getApplicationContext(), InicioActivity.class);
                        startActivity(intent);
                    }else
                    {
                        Toast.makeText(MainActivity.this, "Datos invalidos.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RegistroActivity.class);
                startActivity(intent);
            }
        });
    }
}