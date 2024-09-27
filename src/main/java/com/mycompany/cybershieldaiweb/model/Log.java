/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cybershieldaiweb.model;

public class Log {
    private int idLog;
    private String Accion;      // Campo de la tabla 'logs'
    private String FechaAccion; // Campo de la tabla 'logs'
    private int Usuario_idUsuario;      // Campo de la tabla 'logs'

    // Constructor vacío
    public Log() {}

    // Constructor con parámetros
    public Log(int idLog, String Accion, String FechaAccion, int Usuario_idUsuario) {
        this.idLog = idLog;
        this.Accion = Accion;
        this.FechaAccion = FechaAccion;
        this.Usuario_idUsuario = Usuario_idUsuario;
    }

    // Getters y Setters
    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public String getAccion() {
        return Accion;
    }

    public void setAccion(String Accion) {
        this.Accion = Accion;
    }

    public String getFechaAccion() {
        return FechaAccion;
    }

    public void setFechaAccion(String fechaAccion) {
        this.FechaAccion = FechaAccion;
    }

    public int getUsuario_idUsuario() {
        return Usuario_idUsuario;
    }

    public void setUsuario_idUsuario(int Usuario_idUsuario) {
        this.Usuario_idUsuario = Usuario_idUsuario;
    }
}
