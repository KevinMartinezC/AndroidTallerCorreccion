package com.example.androidtaller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MostrarInfo extends AppCompatActivity {

    String TxtNombre1, TxtHoras1,TxtSalario, TxtDeduccionISSS1, TxtDeduccionAFP1, TxtDeduccionRenta, TxtSueldoDeducciones1, Mensaje,Mensaje2,Mensaje3,MensajePorcentaje,MensajePorcentaje2,MensajePorcentaje3, TxtSueldoFinal1;
    String TxtNombre2, TxtHoras2,TxtSalario2, TxtDeduccionISSS2, TxtDeduccionAFP2, TxtDeduccionRenta2, TxtSueldoDeducciones2, MensajeBono2, TxtSueldoFinal2;
    String TxtNombre3, TxtHoras3,TxtSalario3, TxtDeduccionISSS3, TxtDeduccionAFP3, TxtDeduccionRenta3, TxtSueldoDeducciones3, MensajeBono3, TxtSueldoFinal3;
    String TxtSalarioMax,TxtSalarioMin,TxtGananMas300;
    String NombreMax , NombreMin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_info);
        Button btn1 = findViewById(R.id.btnsalir);
        TextView Nombre1 = findViewById(R.id.Tv_NombreEmpleado);
        TextView Horas1 = findViewById(R.id.Tv_HorasTrabajadas);
        TextView Sueldo = findViewById(R.id.Tv_salario);
        TextView DeduccionISSS = findViewById(R.id.Tv_DeduccionISSS);
        TextView DeduccionAFP = findViewById(R.id.Tv_DeduccionAFP);
        TextView DeduccionRenta = findViewById(R.id.Tv_DeduccionRENTA);
        TextView SueldoDeduccion = findViewById(R.id.Tv_SueldoConDeducciones);
        TextView BonoMensaje = findViewById(R.id.Tv_MensajeBono);
        TextView SueldoFinal = findViewById(R.id.Tv_SueldoFinal);

        TextView Nombre2 = findViewById(R.id.Tv_NombreEmpleado2);
        TextView Horas2 = findViewById(R.id.Tv_HorasTrabajadas2);
        TextView Sueldo2 = findViewById(R.id.Tv_salario2);
        TextView DeduccionISSS2 = findViewById(R.id.Tv_DeduccionISSS2);
        TextView DeduccionAFP2 = findViewById(R.id.Tv_DeduccionAFP2);
        TextView DeduccionRenta2 = findViewById(R.id.Tv_DeduccionRENTA2);
        TextView BonoMensaje2 = findViewById(R.id.Tv_MensajeBono2);
        TextView SueldoDeduccion2 = findViewById(R.id.Tv_SueldoConDeducciones2);
        TextView SueldoFina2 = findViewById(R.id.Tv_SueldoFinal2);

        TextView Nombre3 = findViewById(R.id.Tv_NombreEmpleado3);
        TextView Horas3 = findViewById(R.id.Tv_HorasTrabajadas3);
        TextView Sueldo3 = findViewById(R.id.Tv_salario3);
        TextView DeduccionISSS3 = findViewById(R.id.Tv_DeduccionISSS3);
        TextView DeduccionAFP3 = findViewById(R.id.Tv_DeduccionAFP3);
        TextView DeduccionRenta3 = findViewById(R.id.Tv_DeduccionRENTA3);
        TextView BonoMensaje3 = findViewById(R.id.Tv_MensajeBono3);
        TextView SueldoDeduccion3 = findViewById(R.id.Tv_SueldoConDeducciones3);

        TextView SueldoFina3 = findViewById(R.id.Tv_SueldoFinal3);

        TextView SalarioMax = findViewById(R.id.Tv_SalarioMAX);
        TextView SalarioMin = findViewById(R.id.Tv_SalarioMIN);
        TextView GananMas300 = findViewById(R.id.Tv_Ganancias300);
        Bundle bundle = this.getIntent().getExtras();
        if (bundle.getString("Cargo").equals("Gerente") && bundle.getString("Cargo2").equals("Asistente") && bundle.getString("Cargo3").equals("Secretaria")) {
            Mensaje = "NO HAY BONO";
            MensajePorcentaje = "";
            Mensaje2 = "NO HAY BONO";
            MensajePorcentaje2 = "";
            Mensaje3 = "NO HAY BONO";
            MensajePorcentaje3 = "";
        } else {
            Mensaje = "Has obtenido un bono del ";
            Mensaje2 = "Has obtenido un bono del ";
            Mensaje3 = "Has obtenido un bono del ";
            if(bundle.getString("Cargo").equals("Gerente")){
                MensajePorcentaje = "10%";
            }
            if(bundle.getString("Cargo").equals("Asistente")){
                MensajePorcentaje = "5%";
            }
            if(bundle.getString("Cargo").equals("Secretaria")){
                MensajePorcentaje = "3%";
            }
            if(bundle.getString("Cargo").equals("Mantenimiento")){
                MensajePorcentaje = "2%";
            }
            if(bundle.getString("Cargo2").equals("Gerente")){
                MensajePorcentaje2 = "10%";
            }
            if(bundle.getString("Cargo2").equals("Asistente")){
                MensajePorcentaje2 = "5%";
            }
            if(bundle.getString("Cargo2").equals("Secretaria")){
                MensajePorcentaje2 = "3%";
            }
            if(bundle.getString("Cargo2").equals("Mantenimiento")){
                MensajePorcentaje2 = "2%";
            }
            if(bundle.getString("Cargo3").equals("Gerente")){
                MensajePorcentaje3 = "10%";
            }
            if(bundle.getString("Cargo3").equals("Asistente")){
                MensajePorcentaje3 = "5%";
            }
            if(bundle.getString("Cargo3").equals("Secretaria")){
                MensajePorcentaje3 = "3%";
            }
            if(bundle.getString("Cargo3").equals("Mantenimiento")){
                MensajePorcentaje3 = "2%";
            }
        }

        TxtNombre1 = bundle.getString("NombreEmpleado1");
        Nombre1.setText("Nombre Completo Empleado: " + TxtNombre1);
        TxtHoras1 = bundle.getString("HorasTrabajadas1");
        Horas1.setText("Horas Trabajadas: " + TxtHoras1);
        TxtSalario = bundle.getString("Sueldo");
        Sueldo.setText("Sueldo: " + TxtSalario);
        TxtDeduccionISSS1 = bundle.getString("DeduccionISSS");
        DeduccionISSS.setText("Deducción ISSS: " + "$" + TxtDeduccionISSS1);
        TxtDeduccionAFP1 = bundle.getString("DeduccionAFP");
        DeduccionAFP.setText("Deducción AFP: " + "$" + TxtDeduccionAFP1);
        TxtDeduccionRenta = bundle.getString("DeduccionRenta");
        DeduccionRenta.setText("Deducción Renta: " + "$" + TxtDeduccionRenta);
        TxtSueldoDeducciones1 = bundle.getString("SueldoDeducciones");
        SueldoDeduccion.setText("Sueldo con deducciones: " + "$" + TxtSueldoDeducciones1);

        BonoMensaje.setText(Mensaje + MensajePorcentaje);
        TxtSueldoFinal1 = bundle.getString("SueldoFinal");
        SueldoFinal.setText("Sueldo líquido: " + "$" + TxtSueldoFinal1);

        TxtNombre2 = bundle.getString("NombreEmpleado2");
        Nombre2.setText("Nombre Completo Empleado: " + TxtNombre2);
        TxtHoras2 = bundle.getString("HorasTrabajadas2");
        Horas2.setText("Horas Trabajadas: " + TxtHoras2);
        TxtSalario2 = bundle.getString("Sueldo2");
        Sueldo2.setText("Sueldo: " + TxtSalario2);
        TxtDeduccionISSS2 = bundle.getString("DeduccionISSS2");
        DeduccionISSS2.setText("Deducción ISSS: " + "$" + TxtDeduccionISSS2);
        TxtDeduccionAFP2 = bundle.getString("DeduccionAFP2");
        DeduccionAFP2.setText("Deducción AFP: " + "$" + TxtDeduccionAFP2);
        TxtDeduccionRenta2 = bundle.getString("DeduccionRenta2");
        DeduccionRenta2.setText("Deducción Renta: " + "$" + TxtDeduccionRenta2);
        TxtSueldoDeducciones2 = bundle.getString("SueldoDeducciones2");
        SueldoDeduccion2.setText("Sueldo con deducciones: " + "$" + TxtSueldoDeducciones2);
        MensajeBono2 = bundle.getString("BonoMensaje2");
        BonoMensaje2.setText(Mensaje2 + MensajePorcentaje2);
        TxtSueldoFinal2 = bundle.getString("SueldoFinal2");
        SueldoFina2.setText("Sueldo líquido: " + "$" + TxtSueldoFinal2);
        TxtNombre3 = bundle.getString("NombreEmpleado3");
        Nombre3.setText("Nombre Completo Empleado: " + TxtNombre3);
        TxtHoras3 = bundle.getString("HorasTrabajadas3");
        Horas3.setText("Horas Trabajadas: " + TxtHoras3);
        TxtSalario3 = bundle.getString("Sueldo3");
        Sueldo3.setText("Sueldo: " + TxtSalario3);
        TxtDeduccionISSS3 = bundle.getString("DeduccionISSS3");
        DeduccionISSS3.setText("Deducción ISSS: " + "$" + TxtDeduccionISSS3);
        TxtDeduccionAFP3 = bundle.getString("DeduccionAFP3");
        DeduccionAFP3.setText("Deducción AFP: " + "$" + TxtDeduccionAFP3);
        TxtDeduccionRenta3 = bundle.getString("DeduccionRenta3");
        DeduccionRenta3.setText("Deducción Renta: " + "$" + TxtDeduccionRenta3);
        TxtSueldoDeducciones3 = bundle.getString("SueldoDeducciones3");
        SueldoDeduccion3.setText("Sueldo con deducciones: " + "$" + TxtSueldoDeducciones3);

        BonoMensaje3.setText(Mensaje3 + MensajePorcentaje3);
        TxtSueldoFinal3 = bundle.getString("SueldoFinal3");
        SueldoFina3.setText("Sueldo líquido: " + "$" + TxtSueldoFinal3);

        NombreMax = bundle.getString("NombreMax");
        NombreMin = bundle.getString("NombreMin");

        TxtSalarioMax = bundle.getString("SalarioMax");
        SalarioMax.setText("El salario máximo  pertenece a "+ NombreMax + " con el total de: " +"$"+ TxtSalarioMax);

        TxtSalarioMin = bundle.getString("SalarioMin");
        SalarioMin.setText("El salario minimo  pertenece a "+ NombreMin + " con el total de: " +"$"+ TxtSalarioMin);

        TxtGananMas300 = bundle.getString("Cganacias300");
        GananMas300.setText("El numero de empleados que ganan mas de $300 es: "+TxtGananMas300);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),InicioActivity.class);
                startActivity(intent);
            }
        });
    }
}