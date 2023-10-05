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
    private int copago;
    private String detalle;

    public Practica(int codigo, int copago, String detalle) {
        this.codigo = codigo;
        this.copago = copago;
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

    public int getCopago() {
        return copago;
    }

    public void setCopago(int copago) {
        this.copago = copago;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Practica{" + "codigo=" + codigo + ", copago=" + copago + ", detalle=" + detalle + '}';
    }

    
    
}
