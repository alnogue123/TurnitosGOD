/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.FormularioRegistro;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author alnog
 */
public class Cliente {
    private String TipoIdendificacion;
    private double NumeroIdentificacion;
    private String Turno,modulo;
    
    private String fechaTurno = null;
    
    private String Atendido = "No";
    

    public Cliente(String TipoIdendificacion, double NumeroIdentificacion, String Turno, String modulo) {
        this.TipoIdendificacion = TipoIdendificacion;
        this.NumeroIdentificacion = NumeroIdentificacion;
        this.Turno = Turno;
        this.modulo = modulo;
    }
    
    public String getTipoIdendificacion() {
        return TipoIdendificacion;
    }

    public double getNumeroIdentificacion() {
        return NumeroIdentificacion;
    }

    public String getTurno() {
        return Turno;
    }

    public String getModulo() {
        return modulo;
    }

    public String getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(String fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public String getAtendido() {
        return Atendido;
    }

    public void setAtendido(String Atendido) {
        this.Atendido = Atendido;
    }   
}
