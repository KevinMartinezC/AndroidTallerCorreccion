package com.example.androidtaller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Ejercicio2 extends AppCompatActivity {

    EditText Secuencia;
    Button Calcular;
    TextView Resultados;
    int Contador1=0,Contador2=0,Contador3=0,Contador4=0,ContadorTotalVotos=0,ContadorVotoNulos=0;
    Double PorcentajeC1,PorcentajeC2,PorcentajeC3,PorcentajeC4,PorcentajeVotosNulos;
    ImageView img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);
        Secuencia = findViewById(R.id.Secuencia);
        Calcular = findViewById(R.id.Btn_Calcular);
        Resultados = findViewById(R.id.Tv_Resultados);
        img2 = findViewById(R.id.imageView3);
        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contador1=0;
                Contador2=0;
                Contador3=0;
                Contador4=0;
                ContadorVotoNulos=0;
                ContadorTotalVotos=0;
                Secuencia.setError(null);

                final String regex = "^[0-9]+([,][0-9]+)+$";
                if(Secuencia.getText().toString().matches(regex)==false){
                    Secuencia.setError("Error ingrese un formato valido,sin espacios. FORMATO VALIDO(1,2,3,3...)");
                    Secuencia.requestFocus();
                    return;
                }else{



                    String[] datos = Secuencia.getText().toString().split(",");

                    for (int i = 0; i < datos.length; i++) {

                        if(datos[i].equals("1")){
                            Contador1++;
                        }else if(datos[i].equals("2")){
                            Contador2++;
                        }else if(datos[i].equals("3")){
                            Contador3++;
                        }else if(datos[i].equals("4")){
                            Contador4++;
                        }else{
                            ContadorVotoNulos++;
                        }

                    }

                    ContadorTotalVotos = Contador1 + Contador2 + Contador3 + Contador4 + ContadorVotoNulos ;
                    PorcentajeC1 = (Contador1 / Double.parseDouble(String.valueOf(ContadorTotalVotos))) * 100;
                    PorcentajeC2 = (Contador2 / Double.parseDouble(String.valueOf(ContadorTotalVotos))) * 100;
                    PorcentajeC3 = (Contador3 / Double.parseDouble(String.valueOf(ContadorTotalVotos))) * 100;
                    PorcentajeC4 = (Contador4 / Double.parseDouble(String.valueOf(ContadorTotalVotos))) * 100;
                    PorcentajeVotosNulos = (ContadorVotoNulos / Double.parseDouble(String.valueOf(ContadorTotalVotos))) * 100;
                    System.out.println("Total votos: "+ContadorTotalVotos);
                    System.out.println("Porcentaje Candidato 1:"+String.format("%.2f",PorcentajeC1) +"%");
                    System.out.println("Porcentaje Candidato 2:"+String.format("%.2f",PorcentajeC2) +"%");
                    System.out.println("Porcentaje Candidato 3:"+String.format("%.2f",PorcentajeC3) +"%");
                    System.out.println("Porcentaje Candidato 4:"+String.format("%.2f",PorcentajeC4) +"%");

                    Resultados.setText("Candidato 1 - Votos: " + Contador1 + " con un porcentaje del " + String.format("%.2f", PorcentajeC1) + "%" + "\n"+"\n"
                            + "Candidato 2 - Votos: " + Contador2 + " con un porcentaje del " + String.format("%.2f", PorcentajeC2) + "%" + "\n"+ "\n"
                            + "Candidato 3 - Votos: " + Contador3 + " con un porcentaje del " + String.format("%.2f", PorcentajeC3) + "%" + "\n" + "\n" +
                            "Candidato 4 - Votos: " + Contador4 + " con un porcentaje del " + String.format("%.2f", PorcentajeC4) + "%" + "\n" + "\n" +
                            "Hubo un total de " + ContadorVotoNulos + " Votos Nulos: " +  " con un porcentaje del " + String.format("%.2f", PorcentajeVotosNulos) + "%"
                    );

                }
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Ejercicio2.this,InicioActivity.class);
                startActivity(intent);
            }
        });


    }
}