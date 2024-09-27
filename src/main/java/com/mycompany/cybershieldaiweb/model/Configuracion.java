/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb.model;

public class Configuracion {
    private int id;
    private String alertas;
    private String frecuencia;
    private String idioma;
    private int Usuario_idUsuario; // Este es el ID del Usuario asociado

    // Constructor vacío
    public Configuracion() {
    }

    // Constructor con todos los campos
    public Configuracion(int id, String alertas, String frecuencia, String idioma, int Usuario_idUsuario) {
        this.id = id;
        this.alertas = alertas;
        this.frecuencia = frecuencia;
        this.idioma = idioma;
        this.Usuario_idUsuario = Usuario_idUsuario;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlertas() {
        return alertas;
    }

    public void setAlertas(String alertas) {
        this.alertas = alertas;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getUsuario_idUsuario() {
        return Usuario_idUsuario;
    }

    public void setUsuario_idUsuario(int Usuario_idUsuario) {
        this.Usuario_idUsuario = Usuario_idUsuario;
    }
}
