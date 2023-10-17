package Entidades;

import java.util.Date;

public class Orden {
    
    private int idOrden;
    private Practica codigo;
    private Date fechaEmision;
    private Date fechaVencimiento;
    private String formaPago;
    private Afiliado afiliado;
    private Prestador prestador;
    private int cantidadPracticas;
    private double liquidacion;

    public Orden() {
    }

    public Orden(Practica codigo, Date fechaEmision, Date fechaVencimiento, String formaPago, Afiliado afiliado, Prestador prestador) {
        this.codigo = codigo;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.formaPago = formaPago;
        this.afiliado = afiliado;
        this.prestador = prestador;
    }
    
    public Orden(int idOrden, Practica codigo, Date fechaEmision, Date fechaVencimiento, String formaPago, Afiliado afiliado, Prestador prestador) {
        this.idOrden = idOrden;
        this.codigo = codigo;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.formaPago = formaPago;
        this.afiliado = afiliado;
        this.prestador = prestador;
    }

    public Orden(int idOrden, Practica codigo, Date fechaEmision, Date fechaVencimiento, String formaPago, Afiliado afiliado, Prestador prestador, int cantidadPracticas) {
        this.idOrden = idOrden;
        this.codigo = codigo;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.formaPago = formaPago;
        this.afiliado = afiliado;
        this.prestador = prestador;
        this.cantidadPracticas = cantidadPracticas;
    }

    public Orden(Practica codigo, Date fechaEmision, Date fechaVencimiento, Afiliado afiliado, Prestador prestador) {
        this.codigo = codigo;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.afiliado = afiliado;
        this.prestador = prestador;
    }

    public Orden(Practica codigo, Afiliado afiliado, Prestador prestador, int cantidadPracticas) {
        this.codigo = codigo;
        this.afiliado = afiliado;
        this.prestador = prestador;
        this.cantidadPracticas = cantidadPracticas;
    }

    public double getLiquidacion() {
        return liquidacion;
    }

    public void setLiquidacion(double liquidacion) {
        this.liquidacion = liquidacion;
    }

    

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public Practica getCodigo() {
        return codigo;
    }

    public void setCodigo(Practica codigo) {
        this.codigo = codigo;
    }

    public int getCantidadPracticas() {
        return cantidadPracticas;
    }

    public void setCantidadPracticas(int cantidadPracticas) {
        this.cantidadPracticas = cantidadPracticas;
    }

    

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    @Override
    public String toString() {
        return "Orden{" + "idOrden=" + idOrden + ", codigo=" + codigo + ", fechaEmision=" + fechaEmision + ", fechaVencimiento=" + fechaVencimiento + ", formaPago=" + formaPago + ", afiliado=" + afiliado + ", prestador=" + prestador + ", cantidadPracticas=" + cantidadPracticas + '}';
    }

    
    

    
    
    
}
