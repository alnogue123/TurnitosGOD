/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.FormularioRegistro;
/**
 *
 * @author alnog
 */
public class Cliente {
    private final String TipoIdendificacion;
    private final double NumeroIdentificacion;
    private final String Turno;
    private final String modulo;
    
    private String fechaTurno = null;
    
    private String Atendido = null;
    

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
