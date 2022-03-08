package com.example.androidtaller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {
    EditText usuarioNombre,contra,confContra;
    Button btnRegistrarse;
    TextView iniciasSeccion;
    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        usuarioNombre= (EditText)findViewById(R.id.nombreUsuario);
        contra=(EditText)findViewById(R.id.contrasena);
        confContra=(EditText)findViewById(R.id.confirmar_contrasena);

        iniciasSeccion=(TextView) findViewById(R.id.inicioseccion);
        btnRegistrarse=(Button) findViewById(R.id.btn_registrarse);

        myDB = new DBHelper(this);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = usuarioNombre.getText().toString();
                String contrasena = contra.getText().toString();
                String confContrasena = confContra.getText().toString();

                if(usuario.equals("") || contrasena.equals("")|| confContrasena.equals("")){
                    Toast.makeText(RegistroActivity.this, "Debe completar todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    if(contrasena.equals(confContrasena))
                    {
                        Boolean usuariocheckResultado= myDB.checkNombreUsuario(usuario);

                        if(usuariocheckResultado== false)
                        {
                            Boolean regResultado = myDB.insertarDatos(usuario,contrasena);

                            if(regResultado == true){
                                Toast.makeText(RegistroActivity.this, "Registro Exitoso!!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(RegistroActivity.this, "El Registro Falló", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(RegistroActivity.this, "Esta cuenta ya existe/\n Por favor, iniciar sesión", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(RegistroActivity.this, "No coinciden las contraseña", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        iniciasSeccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}