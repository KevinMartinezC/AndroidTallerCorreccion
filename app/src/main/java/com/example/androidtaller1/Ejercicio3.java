package com.example.androidtaller1;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.DoubleStream;

public class Ejercicio3 extends AppCompatActivity {


    RadioButton op1, op2, op3, op4;
    EditText et1, et2, et3;
    String NombreMin, NombreMax, cargo, ObtenerCargo, ObtenerCargo2, ObtenerCargo3, Mensaje, MensajePorcentaje, Mensaje2, MensajePorcentaje2, ObtenerNombre, ObtenerNombre2, ObtenerNombre3;
    Button calcular, mostrar;
    Datos datos[] = new Datos[3];

    TextView tv1, tv2, tv3;
    Double ISSS = 0.0525;
    Double AFP = 0.068;
    Double RENTA = 0.1;
    Double Sueldo, Sueldo2, Sueldo3, BonoPorcentaje1 = 0.1, BonoPorcentaje2 = 0.05, BonoPorcentaje3 = 0.03, BonoPorcentajeEspecial = 0.02, SueldoFinal3, SueldoFinal2, SueldoFinal;
    Double ResulHoras, ResulHoras2, ResulHoras3, HorasEmpleado1, HorasEmpleado2, HorasEmpleado3, SueldoSinBono, SueldoSinBono2, SueldoSinBono3;
    Double minComparacion, min, maxComparacion, max, ResulBono1, ResulBono2, ResulBono3, DeduccionISS1, DeduccionAFP1, DeduccionRenta1, SueldoLiquido1, DeduccionISS2, DeduccionAFP2, DeduccionRenta2, SueldoLiquido2, DeduccionISS3, DeduccionAFP3, DeduccionRenta3, SueldoLiquido3;
    ImageView img4;
    int RestaHoras = 160, ContadorGanancia = 0;
    int i = -1, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);

        op1 = findViewById(R.id.Radio1);
        op2 = findViewById(R.id.Radio2);
        op3 = findViewById(R.id.Radio3);
        op4 = findViewById(R.id.Radio4);
        et1 = findViewById(R.id.Et_Nombre);
        et2 = findViewById(R.id.Et_Apellido);
        et3 = findViewById(R.id.Et_Horas);
        calcular = findViewById(R.id.Btn_Salary);
        mostrar = findViewById(R.id.Btn_Datos);
        img4 = findViewById(R.id.imageView4);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.setError(null);
                et2.setError(null);
                et3.setError(null);
                final String regex = "^[1-9]\\d*(.\\d+)?$";
                final String regex2 = "^[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1])[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$";
                if ("".equals(et1.getText().toString())) {
                    et1.setError("error. no deje campos vacios");
                    et1.requestFocus();
                    return;
                } else if ("".equals(et2.getText().toString())) {
                    et2.setError("error. no deje campos vacios");
                    et2.requestFocus();
                    return;
                } else if ("".equals(et3.getText().toString())) {
                    et3.setError("error ingrese el numero de horas trabajadas");
                    et3.requestFocus();
                    return;
                } else if (et1.getText().toString().matches(regex2) == false) {
                    et1.setError("error. ingrese un nombre nombre y sin espacios");
                    et1.requestFocus();
                    return;
                } else if (et2.getText().toString().matches(regex2) == false) {
                    et2.setError("error. ingrese un nombre apellido y sin espacios");
                    et2.requestFocus();
                    return;
                } else if (et3.getText().toString().matches(regex) == false) {
                    Toast.makeText(Ejercicio3.this, "error no se aceptan horas negativas ni 0,solo se aceptan números enteros y decimales", Toast.LENGTH_LONG).show();
                    et3.requestFocus();
                    return;
                } else {
                    guardarDatos();
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                }


            }

        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Ejercicio3.this,InicioActivity.class);
                startActivity(intent);
            }
        });


    }


    public void guardarDatos() {
        Datos p;
        i++;

        String nombre = et1.getText().toString();
        String apellido = et2.getText().toString();
        Double horas = Double.parseDouble(et3.getText().toString());

        if (horas <= 0) {
            Toast.makeText(getApplicationContext(), "No debe ingresar valores negativos o cero", Toast.LENGTH_SHORT).show();
        } else {
            if (op1.isChecked() == true) {
                cargo = "Gerente";
            } else if (op2.isChecked() == true) {
                cargo = "Asistente";
            } else if (op3.isChecked() == true) {
                cargo = "Secretaria";
            } else if (op4.isChecked() == true) {
                cargo = "Mantenimiento";
            }
            p = new Datos(nombre, apellido, cargo, horas);

            datos[i] = p;

            if (i == 2) {
                calcular.setEnabled(false);
                mostrar.setEnabled(true);



                //Obteniendo el valor de las horas trabajadas
                HorasEmpleado1 = datos[0].getHoras();
                HorasEmpleado2 = datos[1].getHoras();
                HorasEmpleado3 = datos[2].getHoras();

                //Obteniendo los cargos ingresados
                ObtenerCargo = datos[0].getCargo();
                ObtenerCargo2 = datos[1].getCargo();
                ObtenerCargo3 = datos[2].getCargo();


                System.out.println(ObtenerCargo);
                System.out.println(ObtenerCargo2);
                System.out.println(ObtenerCargo3);
                if (HorasEmpleado1 <= 160) {
                    if (ObtenerCargo == "Gerente" && ObtenerCargo2 == "Asistente" && ObtenerCargo3 == "Secretaria") {
                        BonoPorcentaje1 = 0.0;
                        BonoPorcentaje2 = 0.0;
                        BonoPorcentaje3 = 0.0;
                        Mensaje = "No Hay Bono del ";
                        MensajePorcentaje = "";
                    } else {
                        Mensaje = "Has obtenido un bono de ";
                    }


                    if (ObtenerCargo == "Gerente") {
                        Sueldo = HorasEmpleado1 * 9.75;
                        //deducciones
                        DeduccionISS1 = Sueldo * ISSS;
                        DeduccionAFP1 = Sueldo * AFP;
                        DeduccionRenta1 = Sueldo * RENTA;
                        SueldoSinBono = Sueldo;
                        MensajePorcentaje = "10%";
                        SueldoLiquido1 = SueldoSinBono - DeduccionISS1 - DeduccionAFP1 - DeduccionRenta1;
                        ResulBono1 = SueldoLiquido1 * BonoPorcentaje1;
                    }
                    if (ObtenerCargo == "Asistente") {
                        Sueldo = HorasEmpleado1 * 9.75;
                        //deducciones
                        DeduccionISS1 = Sueldo * ISSS;
                        DeduccionAFP1 = Sueldo * AFP;
                        DeduccionRenta1 = Sueldo * RENTA;
                        SueldoSinBono = Sueldo;
                        MensajePorcentaje = "5%";
                        SueldoLiquido1 = SueldoSinBono - DeduccionISS1 - DeduccionAFP1 - DeduccionRenta1;
                        ResulBono1 = SueldoLiquido1 * BonoPorcentaje2;
                    }
                    if (ObtenerCargo == "Secretaria") {
                        Sueldo = HorasEmpleado1 * 9.75;
                        //deducciones
                        DeduccionISS1 = Sueldo * ISSS;
                        DeduccionAFP1 = Sueldo * AFP;
                        DeduccionRenta1 = Sueldo * RENTA;
                        SueldoSinBono = Sueldo;
                        MensajePorcentaje = "3%";
                        SueldoLiquido1 = SueldoSinBono - DeduccionISS1 - DeduccionAFP1 - DeduccionRenta1;
                        ResulBono1 = SueldoLiquido1 * BonoPorcentaje3;
                    }
                    if (ObtenerCargo == "Mantenimiento") {
                        Sueldo = HorasEmpleado1 * 9.75;
                        //deducciones
                        DeduccionISS1 = Sueldo * ISSS;
                        DeduccionAFP1 = Sueldo * AFP;
                        DeduccionRenta1 = Sueldo * RENTA;
                        SueldoSinBono = Sueldo;
                        MensajePorcentaje = "2%";
                        SueldoLiquido1 = SueldoSinBono - DeduccionISS1 - DeduccionAFP1 - DeduccionRenta1;
                        ResulBono1 = SueldoLiquido1 * BonoPorcentajeEspecial;
                    }
                    System.out.println("Horas empleado < 160");
                    System.out.println("Deduccion ISSS " + (DeduccionISS1));
                    System.out.println("Deduccion AFP " + (DeduccionAFP1));
                    System.out.println("Deduccion RENTA " + (DeduccionRenta1));
                    System.out.println("Sueldo con deducciones: " + (SueldoLiquido1));
                    SueldoFinal = SueldoLiquido1 + ResulBono1;
                    System.out.println(Mensaje + MensajePorcentaje);
                    System.out.println("Sueldo Final:" + (SueldoLiquido1 + ResulBono1));

                }
                if (HorasEmpleado1 > 160) {
                    if (ObtenerCargo == "Gerente" && ObtenerCargo2 == "Asistente" && ObtenerCargo3 == "Secretaria") {
                        BonoPorcentaje1 = 0.0;
                        BonoPorcentaje2 = 0.0;
                        BonoPorcentaje3 = 0.0;
                        Mensaje = "No Hay Bono del ";
                        MensajePorcentaje = "";
                    } else {
                        Mensaje = "Has obtenido un bono de ";
                    }
                    if (ObtenerCargo == "Gerente") {
                        ResulHoras = HorasEmpleado1 - RestaHoras;
                        Double PrimeraHPagadas = RestaHoras * 9.75;
                        Double RestantesHPagadas = ResulHoras * 11.50;
                        Sueldo = PrimeraHPagadas + RestantesHPagadas;

                        //deducciones
                        DeduccionISS1 = Sueldo * ISSS;
                        DeduccionAFP1 = Sueldo * AFP;
                        DeduccionRenta1 = Sueldo * RENTA;
                        SueldoSinBono = Sueldo;
                        MensajePorcentaje = "10%";
                        SueldoLiquido1 = SueldoSinBono - DeduccionISS1 - DeduccionAFP1 - DeduccionRenta1;
                        ResulBono1 = SueldoLiquido1 * BonoPorcentaje1;


                    }
                    if (ObtenerCargo == "Asistente") {
                        ResulHoras = HorasEmpleado1 - RestaHoras;
                        Double PrimeraHPagadas = RestaHoras * 9.75;
                        Double RestantesHPagadas = ResulHoras * 11.50;
                        Sueldo = PrimeraHPagadas + RestantesHPagadas;

                        //deducciones
                        DeduccionISS1 = Sueldo * ISSS;
                        DeduccionAFP1 = Sueldo * AFP;
                        DeduccionRenta1 = Sueldo * RENTA;
                        SueldoSinBono = Sueldo;
                        MensajePorcentaje = "5%";
                        SueldoLiquido1 = SueldoSinBono - DeduccionISS1 - DeduccionAFP1 - DeduccionRenta1;
                        ResulBono1 = SueldoLiquido1 * BonoPorcentaje2;
                    }
                    if (ObtenerCargo == "Secretaria") {
                        ResulHoras = HorasEmpleado1 - RestaHoras;
                        Double PrimeraHPagadas = RestaHoras * 9.75;
                        Double RestantesHPagadas = ResulHoras * 11.50;
                        Sueldo = PrimeraHPagadas + RestantesHPagadas;

                        //deducciones
                        DeduccionISS1 = Sueldo * ISSS;
                        DeduccionAFP1 = Sueldo * AFP;
                        DeduccionRenta1 = Sueldo * RENTA;
                        SueldoSinBono = Sueldo;
                        MensajePorcentaje = "3%";
                        SueldoLiquido1 = SueldoSinBono - DeduccionISS1 - DeduccionAFP1 - DeduccionRenta1;
                        ResulBono1 = SueldoLiquido1 * BonoPorcentaje3;
                    }
                    if (ObtenerCargo == "Mantenimiento") {
                        ResulHoras = HorasEmpleado1 - RestaHoras;
                        Double PrimeraHPagadas = RestaHoras * 9.75;
                        Double RestantesHPagadas = ResulHoras * 11.50;
                        Sueldo = PrimeraHPagadas + RestantesHPagadas;

                        //deducciones
                        DeduccionISS1 = Sueldo * ISSS;
                        DeduccionAFP1 = Sueldo * AFP;
                        DeduccionRenta1 = Sueldo * RENTA;
                        SueldoSinBono = Sueldo;
                        MensajePorcentaje = "2%";
                        SueldoLiquido1 = SueldoSinBono - DeduccionISS1 - DeduccionAFP1 - DeduccionRenta1;
                        ResulBono1 = SueldoLiquido1 * BonoPorcentajeEspecial;
                    }
                    System.out.println("Horas empleado1 > 160");
                    System.out.println("Deduccion ISSS " + (DeduccionISS1));
                    System.out.println("Deduccion AFP " + (DeduccionAFP1));
                    System.out.println("Deduccion RENTA " + (DeduccionRenta1));
                    System.out.println("Sueldo con deducciones: " + (SueldoLiquido1));
                    SueldoFinal = SueldoLiquido1 + ResulBono1;
                    System.out.println(Mensaje + MensajePorcentaje);
                    System.out.println("Sueldo Final:" + (SueldoLiquido1 + ResulBono1));

                }

                if (HorasEmpleado2 <= 160) {
                    if (ObtenerCargo == "Gerente" && ObtenerCargo2 == "Asistente" && ObtenerCargo3 == "Secretaria") {
                        BonoPorcentaje1 = 0.0;
                        BonoPorcentaje2 = 0.0;
                        BonoPorcentaje3 = 0.0;
                        Mensaje2 = "No Hay Bono del ";
                        MensajePorcentaje = "";
                    } else {
                        Mensaje2 = "Has obtenido un bono de ";
                    }
                    if (ObtenerCargo2 == "Gerente") {
                        Sueldo2 = HorasEmpleado2 * 9.75;
                        //deducciones
                        DeduccionISS2 = Sueldo2 * ISSS;
                        DeduccionAFP2 = Sueldo2 * AFP;
                        DeduccionRenta2 = Sueldo2 * RENTA;
                        SueldoSinBono2 = Sueldo2;
                        MensajePorcentaje = "10%";
                        SueldoLiquido2 = SueldoSinBono2 - DeduccionISS2 - DeduccionAFP2 - DeduccionRenta2;
                        ResulBono2 = SueldoLiquido2 * BonoPorcentaje1;
                    }
                    if (ObtenerCargo2 == "Asistente") {
                        Sueldo2 = HorasEmpleado2 * 9.75;
                        //deducciones
                        DeduccionISS2 = Sueldo2 * ISSS;
                        DeduccionAFP2 = Sueldo2 * AFP;
                        DeduccionRenta2 = Sueldo2 * RENTA;
                        SueldoSinBono2 = Sueldo2;
                        MensajePorcentaje = "5%";
                        SueldoLiquido2 = SueldoSinBono2 - DeduccionISS2 - DeduccionAFP2 - DeduccionRenta2;
                        ResulBono2 = SueldoLiquido2 * BonoPorcentaje2;
                    }
                    if (ObtenerCargo2 == "Secretaria") {
                        Sueldo2 = HorasEmpleado2 * 9.75;
                        //deducciones
                        DeduccionISS2 = Sueldo2 * ISSS;
                        DeduccionAFP2 = Sueldo2 * AFP;
                        DeduccionRenta2 = Sueldo2 * RENTA;
                        SueldoSinBono2 = Sueldo2;
                        MensajePorcentaje = "3%";
                        SueldoLiquido2 = SueldoSinBono2 - DeduccionISS2 - DeduccionAFP2 - DeduccionRenta2;
                        ResulBono2 = SueldoLiquido2 * BonoPorcentaje3;
                    }
                    if (ObtenerCargo2 == "Mantenimiento") {
                        Sueldo2 = HorasEmpleado2 * 9.75;
                        //deducciones
                        DeduccionISS2 = Sueldo2 * ISSS;
                        DeduccionAFP2 = Sueldo2 * AFP;
                        DeduccionRenta2 = Sueldo2 * RENTA;
                        SueldoSinBono2 = Sueldo2;
                        MensajePorcentaje = "2%";
                        SueldoLiquido2 = SueldoSinBono - DeduccionISS2 - DeduccionAFP2 - DeduccionRenta2;
                        ResulBono2 = SueldoLiquido2 * BonoPorcentajeEspecial;
                    }

                    System.out.println("Horas empleado2 < 160");
                    System.out.println("Deduccion ISSS " + (DeduccionISS2));
                    System.out.println("Deduccion AFP " + (DeduccionAFP2));
                    System.out.println("Deduccion RENTA " + (DeduccionRenta2));
                    System.out.println("Sueldo con deducciones: " + (SueldoLiquido2));
                    SueldoFinal2 = SueldoLiquido2 + ResulBono2;
                    System.out.println(Mensaje + MensajePorcentaje);
                    System.out.println("Sueldo Final:" + (SueldoLiquido2 + ResulBono2));

                }
                if (HorasEmpleado2 > 160) {
                    if (ObtenerCargo == "Gerente" && ObtenerCargo2 == "Asistente" && ObtenerCargo3 == "Secretaria") {
                        BonoPorcentaje1 = 0.0;
                        BonoPorcentaje2 = 0.0;
                        BonoPorcentaje3 = 0.0;
                        Mensaje = "No Hay Bono del ";
                        MensajePorcentaje = "";
                    } else {
                        Mensaje = "Has obtenido un bono de ";
                    }
                    if (ObtenerCargo2 == "Gerente") {
                        ResulHoras2 = HorasEmpleado2 - RestaHoras;
                        Double PrimeraHPagadas = RestaHoras * 9.75;
                        Double RestantesHPagadas = ResulHoras2 * 11.50;
                        Sueldo2 = PrimeraHPagadas + RestantesHPagadas;
                        //deducciones
                        DeduccionISS2 = Sueldo2 * ISSS;
                        DeduccionAFP2 = Sueldo2 * AFP;
                        DeduccionRenta2 = Sueldo2 * RENTA;
                        SueldoSinBono2 = Sueldo2;
                        MensajePorcentaje = "10%";
                        SueldoLiquido2 = SueldoSinBono2 - DeduccionISS2 - DeduccionAFP2 - DeduccionRenta2;
                        ResulBono2 = SueldoLiquido2 * BonoPorcentaje1;
                    }
                    if (ObtenerCargo2 == "Asistente") {
                        ResulHoras2 = HorasEmpleado2 - RestaHoras;
                        Double PrimeraHPagadas = RestaHoras * 9.75;
                        Double RestantesHPagadas = ResulHoras2 * 11.50;
                        Sueldo2 = PrimeraHPagadas + RestantesHPagadas;
                        //deducciones
                        DeduccionISS2 = Sueldo2 * ISSS;
                        DeduccionAFP2 = Sueldo2 * AFP;
                        DeduccionRenta2 = Sueldo2 * RENTA;
                        SueldoSinBono2 = Sueldo2;
                        MensajePorcentaje = "5%";
                        SueldoLiquido2 = SueldoSinBono2 - DeduccionISS2 - DeduccionAFP2 - DeduccionRenta2;
                        ResulBono2 = SueldoLiquido2 * BonoPorcentaje2;
                    }
                    if (ObtenerCargo2 == "Secretaria") {
                        ResulHoras2 = HorasEmpleado2 - RestaHoras;
                        Double PrimeraHPagadas = RestaHoras * 9.75;
                        Double RestantesHPagadas = ResulHoras2 * 11.50;
                        Sueldo2 = PrimeraHPagadas + RestantesHPagadas;
                        //deducciones
                        DeduccionISS2 = Sueldo2 * ISSS;
                        DeduccionAFP2 = Sueldo2 * AFP;
                        DeduccionRenta2 = Sueldo2 * RENTA;
                        SueldoSinBono2 = Sueldo2;
                        MensajePorcentaje = "3%";
                        SueldoLiquido2 = SueldoSinBono2 - DeduccionISS2 - DeduccionAFP2 - DeduccionRenta2;
                        ResulBono2 = SueldoLiquido2 * BonoPorcentaje3;
                    }
                    if (ObtenerCargo2 == "Mantenimiento") {
                        ResulHoras2 = HorasEmpleado2 - RestaHoras;
                        Double PrimeraHPagadas = RestaHoras * 9.75;
                        Double RestantesHPagadas = ResulHoras2 * 11.50;
                        Sueldo2 = PrimeraHPagadas + RestantesHPagadas;
                        //deducciones
                        DeduccionISS2 = Sueldo2 * ISSS;
                        DeduccionAFP2 = Sueldo2 * AFP;
                        DeduccionRenta2 = Sueldo2 * RENTA;
                        SueldoSinBono2 = Sueldo2;
                        MensajePorcentaje = "2%";
                        SueldoLiquido2 = SueldoSinBono2 - DeduccionISS2 - DeduccionAFP2 - DeduccionRenta2;
                        ResulBono2 = SueldoLiquido2 * BonoPorcentajeEspecial;
                    }
                    System.out.println("Horas empleado2 > 160");
                    System.out.println("Deduccion ISSS " + (DeduccionISS2));
                    System.out.println("Deduccion AFP " + (DeduccionAFP2));
                    System.out.println("Deduccion RENTA " + (DeduccionRenta2));
                    System.out.println("Sueldo con deducciones: " + (SueldoLiquido2));
                    SueldoFinal2 = SueldoLiquido2 + ResulBono2;
                    System.out.println(Mensaje + MensajePorcentaje);
                    System.out.println("Sueldo Final:" + (SueldoLiquido2 + ResulBono2));


                }
                if (HorasEmpleado3 <= 160) {
                    if (ObtenerCargo == "Gerente" && ObtenerCargo2 == "Asistente" && ObtenerCargo3 == "Secretaria") {
                        BonoPorcentaje1 = 0.0;
                        BonoPorcentaje2 = 0.0;
                        BonoPorcentaje3 = 0.0;
                        Mensaje = "No Hay Bono del ";
                        MensajePorcentaje = "";
                    } else {
                        Mensaje = "Has obtenido un bono de ";
                    }
                    if (ObtenerCargo3 == "Gerente") {
                        Sueldo3 = HorasEmpleado3 * 9.75;
                        //deducciones
                        DeduccionISS3 = Sueldo3 * ISSS;
                        DeduccionAFP3 = Sueldo3 * AFP;
                        DeduccionRenta3 = Sueldo3 * RENTA;
                        SueldoSinBono3 = Sueldo3;
                        MensajePorcentaje = "10%";
                        SueldoLiquido3 = SueldoSinBono3 - DeduccionISS3 - DeduccionAFP3 - DeduccionRenta3;
                        ResulBono3 = SueldoLiquido3 * BonoPorcentaje1;
                    }
                    if (ObtenerCargo3 == "Asistente") {
                        Sueldo3 = HorasEmpleado3 * 9.75;
                        //deducciones
                        DeduccionISS3 = Sueldo3 * ISSS;
                        DeduccionAFP3 = Sueldo3 * AFP;
                        DeduccionRenta3 = Sueldo3 * RENTA;
                        SueldoSinBono3 = Sueldo3;
                        MensajePorcentaje = "5%";
                        SueldoLiquido3 = SueldoSinBono3 - DeduccionISS3 - DeduccionAFP3 - DeduccionRenta3;
                        ResulBono3 = SueldoLiquido3 * BonoPorcentaje2;
                    }
                    if (ObtenerCargo3 == "Secretaria") {
                        Sueldo3 = HorasEmpleado3 * 9.75;
                        //deducciones
                        DeduccionISS3 = Sueldo3 * ISSS;
                        DeduccionAFP3 = Sueldo3 * AFP;
                        DeduccionRenta3 = Sueldo3 * RENTA;
                        SueldoSinBono3 = Sueldo3;
                        MensajePorcentaje = "3%";
                        SueldoLiquido3 = SueldoSinBono3 - DeduccionISS3 - DeduccionAFP3 - DeduccionRenta3;
                        ResulBono3 = SueldoLiquido3 * BonoPorcentaje3;
                    }
                    if (ObtenerCargo3 == "Mantenimiento") {
                        Sueldo3 = HorasEmpleado3 * 9.75;
                        //deducciones
                        DeduccionISS3 = Sueldo3 * ISSS;
                        DeduccionAFP3 = Sueldo3 * AFP;
                        DeduccionRenta3 = Sueldo3 * RENTA;
                        SueldoSinBono3 = Sueldo3;
                        MensajePorcentaje = "2%";
                        SueldoLiquido3 = SueldoSinBono3 - DeduccionISS3 - DeduccionAFP3 - DeduccionRenta3;
                        ResulBono3 = SueldoLiquido3 * BonoPorcentajeEspecial;
                    }

                    System.out.println("Horas empleado3 < 160");
                    System.out.println("Deduccion ISSS " + (DeduccionISS3));
                    System.out.println("Deduccion AFP " + (DeduccionAFP3));
                    System.out.println("Deduccion RENTA " + (DeduccionRenta3));
                    System.out.println("Sueldo con deducciones: " + (SueldoLiquido3));
                    System.out.println(Mensaje + MensajePorcentaje);
                    SueldoFinal3 = SueldoLiquido3 + ResulBono3;
                    System.out.println("Sueldo Final:" + (SueldoLiquido3 + ResulBono3));

                }
                if (HorasEmpleado3 > 160) {
                    if (ObtenerCargo == "Gerente" && ObtenerCargo2 == "Asistente" && ObtenerCargo3 == "Secretaria") {
                        BonoPorcentaje1 = 0.0;
                        BonoPorcentaje2 = 0.0;
                        BonoPorcentaje3 = 0.0;
                        Mensaje = "No Hay Bono del ";
                        MensajePorcentaje = "";
                    } else {
                        Mensaje = "Has obtenido un bono de ";
                    }
                    if (ObtenerCargo3 == "Gerente") {
                        ResulHoras3 = HorasEmpleado3 - RestaHoras;
                        Double PrimeraHPagadas = RestaHoras * 9.75;
                        Double RestantesHPagadas = ResulHoras3 * 11.50;
                        Sueldo3 = PrimeraHPagadas + RestantesHPagadas;
                        //deducciones
                        DeduccionISS3 = Sueldo3 * ISSS;
                        DeduccionAFP3 = Sueldo3 * AFP;
                        DeduccionRenta3 = Sueldo3 * RENTA;
                        SueldoSinBono3 = Sueldo3;
                        MensajePorcentaje = "10%";
                        SueldoLiquido3 = SueldoSinBono3 - DeduccionISS3 - DeduccionAFP3 - DeduccionRenta3;
                        ResulBono3 = SueldoLiquido3 * BonoPorcentaje1;
                    }
                    if (ObtenerCargo3 == "Asistente") {
                        ResulHoras3 = HorasEmpleado2 - RestaHoras;
                        Double PrimeraHPagadas = RestaHoras * 9.75;
                        Double RestantesHPagadas = ResulHoras3 * 11.50;
                        Sueldo3 = PrimeraHPagadas + RestantesHPagadas;
                        //deducciones
                        DeduccionISS3 = Sueldo3 * ISSS;
                        DeduccionAFP3 = Sueldo3 * AFP;
                        DeduccionRenta3 = Sueldo3 * RENTA;
                        SueldoSinBono3 = Sueldo3;
                        MensajePorcentaje = "5%";
                        SueldoLiquido3 = SueldoSinBono3 - DeduccionISS3 - DeduccionAFP3 - DeduccionRenta3;
                        ResulBono3 = SueldoLiquido3 * BonoPorcentaje2;
                    }
                    if (ObtenerCargo3 == "Secretaria") {
                        ResulHoras3 = HorasEmpleado3 - RestaHoras;
                        Double PrimeraHPagadas = RestaHoras * 9.75;
                        Double RestantesHPagadas = ResulHoras3 * 11.50;
                        Sueldo3 = PrimeraHPagadas + RestantesHPagadas;
                        //deducciones
                        DeduccionISS3 = Sueldo3 * ISSS;
                        DeduccionAFP3 = Sueldo3 * AFP;
                        DeduccionRenta3 = Sueldo3 * RENTA;
                        SueldoSinBono3 = Sueldo3;
                        MensajePorcentaje = "3%";
                        SueldoLiquido3 = SueldoSinBono3 - DeduccionISS3 - DeduccionAFP3 - DeduccionRenta3;
                        ResulBono3 = SueldoLiquido3 * BonoPorcentaje3;
                    }
                    if (ObtenerCargo3 == "Mantenimiento") {
                        ResulHoras3 = HorasEmpleado3 - RestaHoras;
                        Double PrimeraHPagadas = RestaHoras * 9.75;
                        Double RestantesHPagadas = ResulHoras3 * 11.50;
                        Sueldo3 = PrimeraHPagadas + RestantesHPagadas;
                        //deducciones
                        DeduccionISS3 = Sueldo3 * ISSS;
                        DeduccionAFP3 = Sueldo3 * AFP;
                        DeduccionRenta3 = Sueldo3 * RENTA;
                        SueldoSinBono3 = Sueldo3;
                        MensajePorcentaje = "2%";
                        SueldoLiquido3 = SueldoSinBono3 - DeduccionISS3 - DeduccionAFP3 - DeduccionRenta3;
                        ResulBono3 = SueldoLiquido3 * BonoPorcentajeEspecial;
                    }
                    System.out.println("Horas empleado3 > 160");
                    System.out.println("Deduccion ISSS " + (DeduccionISS3));
                    System.out.println("Deduccion AFP " + (DeduccionAFP3));
                    System.out.println("Deduccion RENTA " + (DeduccionRenta3));
                    System.out.println("Sueldo con deducciones: " + (SueldoLiquido3));
                    System.out.println(Mensaje + MensajePorcentaje);
                    SueldoFinal3 = SueldoLiquido3 + ResulBono3;
                    System.out.println("Sueldo Final:" + (SueldoLiquido3 + ResulBono3));

                }

                maxComparacion = Math.max(SueldoFinal, SueldoFinal2);
                max = Math.max(maxComparacion, SueldoFinal3);

                minComparacion = Math.min(SueldoFinal, SueldoFinal2);
                min = Math.min(minComparacion, SueldoFinal3);

                if (SueldoFinal > 300) {
                    ContadorGanancia++;
                }

                if (SueldoFinal2 > 300) {
                    ContadorGanancia++;
                }

                if (SueldoFinal3 > 300) {
                    ContadorGanancia++;
                }
                System.out.println("El numero de empleados que ganan mas de $300 es: " + ContadorGanancia);
                if (Double.compare(max, SueldoFinal) == 0) {
                    NombreMax = datos[0].toString();
                } else if (Double.compare(max, SueldoFinal2) == 0) {
                    NombreMax = datos[1].toString();
                } else if (Double.compare(max, SueldoFinal3) == 0) {
                    NombreMax = datos[2].toString();
                }

                if (Double.compare(min, SueldoFinal) == 0) {
                    NombreMin = datos[0].toString();
                } else if (Double.compare(min, SueldoFinal2) == 0) {
                    NombreMin = datos[1].toString();
                } else if (Double.compare(min, SueldoFinal3) == 0) {
                    NombreMin = datos[2].toString();
                }

                System.out.println("El salario maximo  pertenece a " + NombreMax + " con el total de: " + "$" + max);
                System.out.println("El salario minimo  pertenece a " + NombreMin + " con el total de: " + "$" + min);


            }

        }
        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ejercicio3.this, MostrarInfo.class);
                Bundle b = new Bundle();
                System.out.println(Mensaje + MensajePorcentaje);
                b.putString("NombreEmpleado1", datos[0].toString());
                b.putString("HorasTrabajadas1", HorasEmpleado1.toString());
                b.putString("Sueldo", Sueldo.toString());
                b.putString("Cargo", ObtenerCargo);
                b.putString("DeduccionISSS", String.format("%.2f", DeduccionISS1));
                b.putString("DeduccionAFP", String.format("%.2f", DeduccionAFP1));
                b.putString("DeduccionRenta", String.format("%.2f", DeduccionRenta1));
                b.putString("SueldoDeducciones", String.format("%.2f", SueldoLiquido1));
                b.putString("SueldoFinal", String.format("%.2f", SueldoFinal));


                b.putString("NombreEmpleado2", datos[1].toString());
                b.putString("HorasTrabajadas2", HorasEmpleado2.toString());
                b.putString("Sueldo2", Sueldo2.toString());
                b.putString("Cargo2", ObtenerCargo2);
                b.putString("DeduccionISSS2", String.format("%.2f", DeduccionISS2));
                b.putString("DeduccionAFP2", String.format("%.2f", DeduccionAFP2));
                b.putString("DeduccionRenta2", String.format("%.2f", DeduccionRenta2));
                b.putString("SueldoDeducciones2", String.format("%.2f", SueldoLiquido2));
                b.putString("SueldoFinal2", String.format("%.2f", SueldoFinal2));


                b.putString("NombreEmpleado3", datos[2].toString());
                b.putString("HorasTrabajadas3", HorasEmpleado3.toString());
                b.putString("Sueldo3", Sueldo3.toString());
                b.putString("Cargo3", ObtenerCargo3);
                b.putString("DeduccionISSS3", String.format("%.2f", DeduccionISS3));
                b.putString("DeduccionAFP3", String.format("%.2f", DeduccionAFP3));
                b.putString("DeduccionRenta3", String.format("%.2f", DeduccionRenta3));
                b.putString("SueldoDeducciones3", String.format("%.2f", SueldoLiquido3));
                b.putString("SueldoFinal3", String.format("%.2f", SueldoFinal3));

                b.putString("NombreMax", NombreMax);
                b.putString("NombreMin", NombreMin);

                b.putString("SalarioMax", String.format("%.2f", max));
                b.putString("SalarioMin", String.format("%.2f", min));
                b.putString("Cganacias300", String.valueOf(ContadorGanancia));
                intent.putExtras(b);
                startActivity(intent);
            }

        });

    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
