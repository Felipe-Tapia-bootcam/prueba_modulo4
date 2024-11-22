package cl.felipetapia.servicios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cl.felipetapia.modelos.Alumno;
import cl.felipetapia.modelos.Materia;
import cl.felipetapia.modelos.MateriaEnum;

public class AlumnoServicioTest {
	
	private AlumnoServicio alumnoServicio;
    private Materia matematicas;
    private Alumno alumno;
    
    @BeforeEach
    public void setup() {
        // Instancia real para pruebas funcionales
        alumnoServicio = new AlumnoServicio();

        // Mock de AlumnoServicio para pruebas simuladas
        Object alumnoServicioMock = mock(AlumnoServicio.class);

        // Crear materias para pruebas
        matematicas = new Materia(MateriaEnum.MATEMATICAS);
        Materia lenguaje = new Materia(MateriaEnum.LENGUAJE);

        // Crear un alumno
        alumno = new Alumno("1.111.111-1", "Milton", "P.", "Casita 1");
    }
    
    private Object mock(Class<AlumnoServicio> class1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
    public void crearAlumnoTest() {
        alumnoServicio.crearAlumno(alumno);
        Map<String, Alumno> alumnos = alumnoServicio.listarAlumnos();

        assertNotNull(alumnos);
        assertTrue(alumnos.containsKey("1.111.111-1"));
        assertEquals(alumno, alumnos.get("1.111.111-1"));
    }
    
    @Test
    public void agregarMateriaTest() {
        alumnoServicio.crearAlumno(alumno);
        alumnoServicio.agregarMateria("1.111.111-1", matematicas);

        List<Materia> materias = alumnoServicio.materiasPorAlumno("1.111.111-1");

        assertNotNull(materias);
        assertEquals(1, materias.size());
        assertEquals(MateriaEnum.MATEMATICAS, materias.get(0).getNombre());
    }
    
    
    
    

}
