package cl.felipetapia.servicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import cl.felipetapia.modelos.Alumno;

public class ArchivoServicio {
	
	public void exportarDatos(Map<String, Alumno> alumnos, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Alumno alumno : alumnos.values()) {
                writer.write(alumno.toString());
                writer.newLine();
            }
            System.out.println("Datos exportados correctamente a " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error al exportar los datos: " + e.getMessage());
        }
    }

}
