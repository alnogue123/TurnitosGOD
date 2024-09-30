/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.FormularioRegistro;

import java.util.ArrayList;

/**
 *
 * @author alnog
 */
public class Cliente {
    private String TipoIdendificacion;
    private double NumeroIdentificacion;
    private String Turno,modulo;
    private ArrayList<Cliente> ListaClientes = new ArrayList<>();

    public Cliente(String TipoIdendificacion, double NumeroIdentificacion, String Turno, String modulo) {
        this.TipoIdendificacion = TipoIdendificacion;
        this.NumeroIdentificacion = NumeroIdentificacion;
        this.Turno = Turno;
        this.modulo = modulo;
    }

    public ArrayList<Cliente> getListaClientes() {
        return ListaClientes;
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
    
    
}
