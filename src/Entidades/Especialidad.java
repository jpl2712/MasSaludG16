/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;



public class Especialidad {
    private int idEspecialidad;
    private String especialidad;

    @Override
    public String toString() {
        return idEspecialidad + " - " + especialidad ;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Especialidad() {
    }

    public Especialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public Especialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public Especialidad(int idEspecialidad, String especialidad) {
        this.idEspecialidad = idEspecialidad;
        this.especialidad = especialidad;
    }
}
