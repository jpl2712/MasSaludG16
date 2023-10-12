package Entidades;

public class Afiliado {

    private int idAfiliado;
    private String nombre;
    private String apellido;
    private int dni;
    private boolean activo;

    public Afiliado() {
    }

    public Afiliado(int idAfiliado) {
        this.idAfiliado = idAfiliado;
    }

    public Afiliado(int idAfiliado, String nombre, String apellido, int dni, boolean activo) {
        this.idAfiliado = idAfiliado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.activo = activo;
    }
    
    public Afiliado(int idAfiliado, String nombre, String apellido, int dni) {
        this.idAfiliado = idAfiliado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public Afiliado(String nombre, String apellido, int dni, boolean activo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.activo = activo;
    }

    public Afiliado(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public int getIdAfiliado() {
        return idAfiliado;
    }

    public void setIdAfiliado(int idAfiliado) {
        this.idAfiliado = idAfiliado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Afiliado{" + "idAfiliado=" + idAfiliado + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", activo=" + activo + '}';
    }

}