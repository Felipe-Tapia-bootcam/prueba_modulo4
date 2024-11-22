package cl.felipetapia.servicios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cl.felipetapia.modelos.Alumno;
import cl.felipetapia.modelos.Materia;

public class AlumnoServicio {
	
	private final Map<String, Alumno> alumnos = new HashMap<>();
	
	// Crear un nuevo alumno
    public void crearAlumno(Alumno alumno) {
        if (alumnos.containsKey(alumno.getRut())) {
            throw new IllegalArgumentException("El alumno con este RUT ya existe.");
        }
        alumnos.put(alumno.getRut(), alumno);
    }
    
 // Listar todos los alumnos
    public Map<String, Alumno> listarAlumnos() {
        return alumnos;
    }
    
    public void agregarMateria(String rut, Materia materia) {
        Alumno alumno = alumnos.get(rut);
        if (alumno == null) {
            throw new IllegalArgumentException("No se encontró al alumno con el RUT especificado.");
        }
        alumno.getMaterias().add(materia);
    }
    
 // Obtener las materias de un alumno
    public List<Materia> materiasPorAlumno(String rut) {
        Alumno alumno = alumnos.get(rut);
        if (alumno == null) {
            throw new IllegalArgumentException("No se encontró al alumno con el RUT especificado.");
        }
        return alumno.getMaterias();
    }

}
