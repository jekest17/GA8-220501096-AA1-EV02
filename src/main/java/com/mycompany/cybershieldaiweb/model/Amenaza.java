/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb.model;

public class Amenaza {
    private int idAmenaza;
    private String Descripcion;
    private String NivelRiesgo;
    private int Analisis_idAnalisis;
    private String tipoAmenaza;
    private Analisis analisis; 

    // Constructor vacío
    public Amenaza() {}

    // Constructor con parámetros
    public Amenaza(int idAmenaza, String Descripcion, String NivelRiesgo, int Analisis_idAnalisis, String tipoAmenaza) {
        this.idAmenaza = idAmenaza;
        this.Descripcion = Descripcion;
        this.NivelRiesgo = NivelRiesgo;
        this.Analisis_idAnalisis = Analisis_idAnalisis;
        this.tipoAmenaza = tipoAmenaza;
    }

    // Getters y Setters
    public int getidAmenaza() { return idAmenaza; }
    public void setidAmenaza(int idAmenaza) { this.idAmenaza = idAmenaza; }

    public String getDescripcion() { return Descripcion; }
    public void setDescripcion(String Descripcion) { this.Descripcion = Descripcion; }

    public String getNivelRiesgo() { return NivelRiesgo; }
    public void setNivelRiesgo(String NivelRiesgo) { this.NivelRiesgo = NivelRiesgo; }

    public int getAnalisis_idAnalisis() { return Analisis_idAnalisis; }
    public void setAnalisis_idAnalisis(int Analisis_idAnalisis) { this.Analisis_idAnalisis = Analisis_idAnalisis; }

    public String getTipoAmenaza() { return tipoAmenaza; }
    public void setTipoAmenaza(String tipoAmenaza) { this.tipoAmenaza = tipoAmenaza; }
    
    public Analisis getAnalisis() { return analisis; }
    public void setAnalisis(Analisis analisis) { this.analisis = analisis; }
}
