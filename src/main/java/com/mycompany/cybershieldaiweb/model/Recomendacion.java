/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb.model;

import java.sql.Date;

public class Recomendacion {
    private int idRecomendacion;
    private String Descripcion;
    private String NivelUrgencia;
    private int Amenaza_idAmenaza;
    private String estadoImplementacion;
    private Date fechaCompletado;       

    // Constructor vacío
    public Recomendacion() {}

    // Constructor con todos los campos
    public Recomendacion(int idRecomendacion, String Descripcion, String NivelUrgencia, int Amenaza_idAmenaza, String estadoImplementacion, Date fechaCompletado) {
        this.idRecomendacion = idRecomendacion;
        this.Descripcion = Descripcion;
        this.NivelUrgencia = NivelUrgencia;
        this.Amenaza_idAmenaza = Amenaza_idAmenaza;
        this.estadoImplementacion = estadoImplementacion;
        this.fechaCompletado = fechaCompletado;
    }

    // Getters y Setters
    public int getidRecomendacion() {
        return idRecomendacion;
    }

    public void setidRecomendacion(int idRecomendacion) {
        this.idRecomendacion = idRecomendacion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getNivelUrgencia() {
        return NivelUrgencia;
    }

    public void setNivelUrgencia(String NivelUrgencia) {
        this.NivelUrgencia = NivelUrgencia;
    }

    public int getAmenaza_idAmenaza() {
        return Amenaza_idAmenaza;
    }

    public void setAmenaza_idAmenaza(int Amenaza_idAmenaza) {
        this.Amenaza_idAmenaza = Amenaza_idAmenaza;
    }

    public String getestadoImplementacion() {
        return estadoImplementacion;
    }

    public void setestadoImplementacion(String estadoImplementacion) {
        this.estadoImplementacion = estadoImplementacion;
    }

    public Date getfechaCompletado() {
        return fechaCompletado;
    }

    public void setfechaCompletado (Date fechaCompletado) {
        this.fechaCompletado = fechaCompletado;
    }
}
