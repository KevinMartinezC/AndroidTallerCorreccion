package com.example.androidtaller1;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Ejercicio1 extends AppCompatActivity {

    EditText et1, et2, et3;
    Double a,b,c;
    Button BtnCalcular;
    TextView TvResultado;
    ImageView img1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        et1 = findViewById(R.id.Et_CoefiCuadratico);
        et2 = findViewById(R.id.Et_CoefiLineal);
        et3 = findViewById(R.id.Et_Constante);
        TvResultado = findViewById(R.id.Tv_Resultado);
        BtnCalcular = findViewById(R.id.Btn_Calcular);
        img1 = findViewById(R.id.imageView2);


        BtnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.setError(null);
                et2.setError(null);
                et3.setError(null);

                final String regex = "^-?([1-9]{1}[0-9]+|[1-9])";
                if ("".equals(et1.getText().toString())) {
                    et1.setError("error. no deje campos vacios");
                    et1.requestFocus();
                    return;
                }else if("".equals(et2.getText().toString())){
                    et2.setError("error. no deje campos vacios");
                    et2.requestFocus();
                    return;
                }else if("".equals(et3.getText().toString())) {
                    et3.setError("error. no deje campos vacios");
                    et3.requestFocus();
                    return;
                }else if(et1.getText().toString().matches(regex)==false){
                    et1.setError("error no se acepta 0. solo numeros enteros positivos y negativos son aceptados");
                    et1.requestFocus();
                    return;
                }else if(et2.getText().toString().matches(regex)==false) {
                    et2.setError("error no se acepta 0. solo numeros enteros positivos y negativos son aceptados");
                    et2.requestFocus();
                    return;
                }
                else if(et3.getText().toString().matches(regex)==false) {
                    et3.setError("error no se acepta 0. solo numeros enteros positivos y negativos son aceptados");
                    et3.requestFocus();
                    return;
                }else{




                    a = Double.parseDouble(String.valueOf(et1.getText()));
                    b = Double.parseDouble(String.valueOf(et2.getText()));
                    c = Double.parseDouble(String.valueOf(et3.getText()));


                    Double prueba = a * c;

                    Double coeficiente = (Math.pow(b, 2) - (4 * prueba));
                    System.out.println("coeficiente:" + coeficiente);
                    Double x1, x2;
                    Double Raiz = Math.sqrt(coeficiente);
                    System.out.println(Raiz);
                    if (a != 0) {
                        if (coeficiente < 0) {
                            Toast.makeText(getApplicationContext(), R.string.raices_imaginarias, Toast.LENGTH_SHORT).show();
                        } else {
                            x1 = ((-b) + Raiz) / (2 * a);

                            x2 = ((-b) - Raiz) / (2 * a);

                            TvResultado.setText("X1 = " + String.format("%.3f", x1) + "\n" + "X2 =" + String.format("%.3f", x2));
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), R.string.validar_coeficiente, Toast.LENGTH_SHORT).show();
                    }

                }

            }

        });

        img1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Ejercicio1.this,InicioActivity.class);
                startActivity(intent);
            }
        });

    }



}