/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb.model;

public class Evento {
    private int idEvento;
    private String Descripcion; // Campo de la tabla 'evento'
    private String FechaEvento;  // Campo de la tabla 'evento'
    private String Tipo;         // Campo de la tabla 'evento'

    // Constructor vacío
    public Evento() {}

    // Constructor con parámetros
    public Evento(int idEvento, String Descripcion, String FechaEvento, String Tipo) {
        this.idEvento = idEvento;
        this.Descripcion = Descripcion;
        this.FechaEvento = FechaEvento;
        this.Tipo = Tipo;
    }

    // Getters y Setters
    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getFechaEvento() {
        return FechaEvento;
    }

    public void setFechaEvento(String FechaEvento) {
        this.FechaEvento = FechaEvento;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
}
