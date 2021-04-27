/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import listado.Exepciones.califiacionErronea;
import listado.Exepciones.campoVacio;

import java.io.Serializable;

/**
 * @author Admin
 */
public class Alumno implements Serializable {


    private String noCOntrol;
    private String nombre;
    private String paterno;
    private String materno;
    private Double calificacion;
    private String carrera;

    public Alumno(String noCOntrol, String nombre, String paterno, String materno, Double calificacion, String carrera) throws CalificacionErroneaExeption, CampoVacio {
        this.noCOntrol = noCOntrol;
        this.setNombre(nombre);
        this.setPaterno(paterno);
        this.setMaterno(materno);
        this.setCalificacion(calificacion);
        this.setCarrera(carrera);
    }

    public String getNoCOntrol() {
        return noCOntrol;
    }

    public void setNoCOntrol(String noCOntrol) throws CampoVacio {
        if (!noCOntrol.isEmpty()){
            this.noCOntrol = noCOntrol;
        }else {
            throw new CampoVacio("Ingresa un ID ");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws CampoVacio {

        if (!nombre.isEmpty()) {
            this.nombre = nombre;
        } else {
            throw new CampoVacio("Ingresa un nombre valido");
        }
    }

    public void setCalificacion(Double calificacion) throws CalificacionErroneaExeption {
        if ((calificacion <= 10) && (calificacion > 0)) {
            this.calificacion = calificacion;
        } else {
            throw new CalificacionErroneaExeption("La calificaciond debe de estar en un rango de 0 - 10");
        }
    }

    public void setPaterno(String paterno) throws CampoVacio {
        if (!paterno.isEmpty()) {
            this.paterno = paterno;
        } else {
            throw new CampoVacio("Ingresa un apellido valido");
        }
    }

    public void setMaterno(String materno) throws CampoVacio {
        if (!materno.isEmpty()) {
            this.materno = materno;

        } else {
            throw new CampoVacio("Ingresa un apellido valido");
        }
    }

    public void setCarrera(String carrera) throws CampoVacio {

        if (!carrera.isEmpty()){
            this.carrera = carrera;
        }else{
            throw new CampoVacio("Ingresa un apellido valido");
        }
    }

    public String getPaterno() {
        return paterno;
    }


    public String getMaterno() {
        return materno;
    }


    public Double getCalificacion() {
        return calificacion;
    }


    public String getCarrera() {

        return carrera;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Alumno) {
            Alumno alumno = (Alumno) obj;
            if (this.noCOntrol.compareTo(alumno.getNoCOntrol()) == 0) {
                return true;
            }
        }
        return false;
    }
}