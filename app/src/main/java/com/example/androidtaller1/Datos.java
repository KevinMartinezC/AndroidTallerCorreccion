package com.example.androidtaller1;

import androidx.annotation.NonNull;

public class Datos {
    private String nombre;
    private String apellido;
    private String cargo;
    private Double horas;



    public Datos(String nombre, String apellido, String cargo, Double horas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.horas = horas;
    }

    public Datos() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getHoras() {
        return horas;
    }

    public void setHoras(Double horas) {
        this.horas = horas;
    }

    @NonNull
    @Override
    public String toString() {
        return  nombre +" "+ apellido;
    }
}
