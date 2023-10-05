package Entidades;

import java.sql.Date;

public class Orden {
    
    private int idOrden;
    private int codigo;
    private Date fechaEmision;
    private Date fechaVencimiento;
    private String formaPago;
    private Afiliado afiliado;
    private Prestador prestador;

    public Orden() {
    }

    public Orden(int codigo, Date fechaEmision, Date fechaVencimiento, String formaPago, Afiliado afiliado, Prestador prestador) {
        this.codigo = codigo;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.formaPago = formaPago;
        this.afiliado = afiliado;
        this.prestador = prestador;
    }

    public Orden(int idOrden, int codigo, Date fechaEmision, Date fechaVencimiento, String formaPago, Afiliado afiliado, Prestador prestador) {
        this.idOrden = idOrden;
        this.codigo = codigo;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.formaPago = formaPago;
        this.afiliado = afiliado;
        this.prestador = prestador;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
        return "Orden{" + "idOrden=" + idOrden + ", codigo=" + codigo + ", fechaEmision=" + fechaEmision + ", fechaVencimiento=" + fechaVencimiento + ", formaPago=" + formaPago + ", afiliado=" + afiliado + ", prestador=" + prestador + '}';
    }
    
    
}
