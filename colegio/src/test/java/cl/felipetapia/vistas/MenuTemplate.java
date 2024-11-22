package cl.felipetapia.vistas;

import java.util.Scanner;

public abstract class MenuTemplate {
    protected Scanner scanner = new Scanner(System.in);

    // Métodos abstractos
    public abstract void exportarDatos();
    public abstract void crearAlumno();
    public abstract void agregarMateria();
    public abstract void agregarNotaPasoUno();
    public abstract void listarAlumnos();
    public abstract void terminarPrograma();

    // Método final para no sobrescribir
    public final void iniciarMenu() {
        while (true) {
            System.out.println("--- Menú Principal ---");
            System.out.println("1. Crear Alumnos");
            System.out.println("2. Listar Alumnos");
            System.out.println("3. Agregar Materias");
            System.out.println("4. Agregar Notas");
            System.out.println("5. Salir");
            System.out.println("6. Exportar Datos");
            System.out.print("Selección: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1 -> crearAlumno();
                case 2 -> listarAlumnos();
                case 3 -> agregarMateria();
                case 4 -> agregarNotaPasoUno();
                case 5 -> {
                    terminarPrograma();
                    return;
                }
                case 6 -> exportarDatos();
                default -> System.out.println("Opción no válida.");
            }
        }
    }
}
    
    


