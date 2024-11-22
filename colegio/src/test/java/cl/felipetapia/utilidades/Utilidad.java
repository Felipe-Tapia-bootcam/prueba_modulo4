package cl.felipetapia.utilidades;

public class Utilidad {
	
	 // Validar RUT (si es necesario implementar lógica adicional)
    public static boolean validarRut(String rut) {
        return rut.matches("\\d{1,2}\\.\\d{3}\\.\\d{3}-(\\d|k|K)");
    }
    
}
