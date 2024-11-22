package cl.felipetapia.modelos;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
	
	private String rut;
    private String nombre;
    private String apellido;
    private String direccion;
    private List<Materia> materias = new ArrayList<>();
    
    public Alumno(String rut, String nombre, String apellido, String direccion) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }
    
    // Getters
    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    // Setters
    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    // toString para impresión
    @Override
    public String toString() {
        return "Alumno {" +
                "RUT='" + rut + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Apellido='" + apellido + '\'' +
                ", Dirección='" + direccion + '\'' +
                ", Materias=" + materias +
                '}';
    }

}
