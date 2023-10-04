/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;


public class Prestador {
    
    
    private int idPrestador;
    private String nombre, apellido;
    private int dni;
    private boolean activo;
    private Especialidad especialidad;
    private int matricula;
    
    public Prestador(){
        
    }

    public Prestador(String nombre, String apellido, int dni, boolean activo, Especialidad especialidad, int matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.activo = activo;
        this.especialidad = especialidad;
        this.matricula = matricula;
    }

    public Prestador(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public int getIdPrestador() {
        return idPrestador;
    }

    public void setIdPrestador(int idPrestador) {
        this.idPrestador = idPrestador;
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

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Prestador{" + "idPrestador=" + idPrestador + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", activo=" + activo + ", especialidad=" + especialidad + ", matricula=" + matricula + '}';
    }

    
    
    
    
}
