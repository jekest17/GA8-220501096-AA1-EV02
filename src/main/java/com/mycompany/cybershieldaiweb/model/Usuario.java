/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb.model;

import java.sql.Timestamp;


public class Usuario {
    private int idUsuario;
    private String Nombre;
    private String CorreoElectronico;
    private String Contraseña;
    private String Rol;
    private Timestamp fechaCreacion;  
    private Timestamp fechaModificacion;  
    private String estado; 


    // Constructor vacío
    public Usuario() {}

    // Constructor con parámetros
    public Usuario(int idUsuario, String Nombre, String CorreoElectronico, String Contraseña, String Rol) {
        this.idUsuario = idUsuario;
        this.Nombre = Nombre;
        this.CorreoElectronico = CorreoElectronico;
        this.Contraseña = Contraseña;
        this.Rol = Rol;
    }

    // Getters y Setters
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getNombre() { return Nombre; }
    public void setNombre(String Nombre) { this.Nombre = Nombre; }

    public String getCorreoElectronico() { return CorreoElectronico; }
    public void setCorreoElectronico(String CorreoElectronico) { this.CorreoElectronico = CorreoElectronico; }

    public String getContraseña() { return Contraseña; }
    public void setContraseña(String Contraseña) { this.Contraseña = Contraseña; }

    public String getRol() { return Rol; }
    public void setRol(String Rol) { this.Rol = Rol; }
    
    public Timestamp getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(Timestamp fechaCreacion) {this.fechaCreacion = fechaCreacion; }

    public Timestamp getFechaModificacion() { return fechaModificacion; }
    public void setFechaModificacion(Timestamp fechaModificacion) { this.fechaModificacion = fechaModificacion;}

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
