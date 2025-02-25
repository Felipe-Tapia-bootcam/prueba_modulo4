package cl.felipetapia.vistas;

import cl.felipetapia.modelos.Alumno;
import cl.felipetapia.modelos.Materia;
import cl.felipetapia.modelos.MateriaEnum;
import cl.felipetapia.servicios.AlumnoServicio;
import cl.felipetapia.servicios.ArchivoServicio;

public class Menu extends MenuTemplate {
	
	 private final AlumnoServicio alumnoServicio = new AlumnoServicio();
	 private final ArchivoServicio archivoServicio = new ArchivoServicio();
	    
	 @Override
	 public void exportarDatos() {
	     
	     String ruta = "promedios.txt";
	     archivoServicio.exportarDatos(alumnoServicio.listarAlumnos(), ruta);
	    }
	 
	 @Override
	    public void crearAlumno() {
	        System.out.println("--- Crear Alumno ---");
	        System.out.print("Ingresa RUT: ");
	        String rut = scanner.nextLine();
	        System.out.print("Ingresa nombre: ");
	        String nombre = scanner.nextLine();
	        System.out.print("Ingresa apellido: ");
	        String apellido = scanner.nextLine();
	        System.out.print("Ingresa dirección: ");
	        String direccion = scanner.nextLine();
	        Alumno alumno = new Alumno(rut, nombre, apellido, direccion);
	        alumnoServicio.crearAlumno(alumno);
	        System.out.println("--- ¡Alumno agregado! ---");
	    }
	 
	 @Override
	    public void agregarMateria() {
	        System.out.println("--- Agregar Materia ---");
	        System.out.print("Ingresa RUT del Alumno: ");
	        String rut = scanner.nextLine();
	        System.out.println("1. MATEMATICAS\n2. LENGUAJE\n3. CIENCIA\n4. HISTORIA");
	        System.out.print("Selecciona una Materia: ");
	        int opcion = scanner.nextInt();
	        scanner.nextLine(); // Consumir nueva línea
	        MateriaEnum materiaEnum = MateriaEnum.values()[opcion - 1];
	        Materia materia = new Materia(materiaEnum);
	        alumnoServicio.agregarMateria(rut, materia);
	        System.out.println("--- ¡Materia agregada! ---");
	    }
	 
	 @Override
	    public void agregarNotaPasoUno() {
	        System.out.println("--- Agregar Nota ---");
	        System.out.print("Ingresa RUT del Alumno: ");
	        String rut = scanner.nextLine();
	        System.out.println("Selecciona una materia:");
	        var materias = alumnoServicio.materiasPorAlumno(rut);
	        for (int i = 0; i < materias.size(); i++) {
	            System.out.printf("%d. %s%n", i + 1, materias.get(i).getNombre());
	        }
	        int materiaSeleccionada = scanner.nextInt();
	        System.out.print("Ingresar nota: ");
	        double nota = scanner.nextDouble();
	        scanner.nextLine(); // Consumir nueva línea
	        materias.get(materiaSeleccionada - 1).getNotas().add(nota);
	        System.out.printf("--- ¡Nota agregada a %s! ---%n", materias.get(materiaSeleccionada - 1).getNombre());
	    }

	 	@Override
	    public void listarAlumnos() {
	        System.out.println("--- Listar Alumnos ---");
	        alumnoServicio.listarAlumnos().values().forEach(System.out::println);
	    }

	    @Override
	    public void terminarPrograma() {
	        System.out.println("Finalizando programa. ¡Gracias por ingresar a Edutecno-Software!");
	    }

}
