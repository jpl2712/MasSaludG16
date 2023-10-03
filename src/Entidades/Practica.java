/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Usuario
 */
public class Practica {
    private int codigo;
    private int practica;
    private String detalle;

    public Practica(int codigo, int practica, String detalle) {
        this.codigo = codigo;
        this.practica = practica;
        this.detalle = detalle;
    }

    public Practica() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPractica() {
        return practica;
    }

    public void setPractica(int practica) {
        this.practica = practica;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Practica{" + "codigo=" + codigo + ", practica=" + practica + ", detalle=" + detalle + '}';
    }
    
    
}
