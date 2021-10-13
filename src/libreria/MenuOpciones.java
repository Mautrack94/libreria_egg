package libreria;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.servicios.AutorServicio;
import libreria.servicios.LibroServicio;

public class MenuOpciones {

    private final Scanner leer;
    private final LibroServicio servicioLibro;
    private final AutorServicio servicioAutor;

    public MenuOpciones(Scanner leer, LibroServicio servicioLibro, AutorServicio servicioAutor) {
        this.leer = new Scanner(System.in).useDelimiter("\n");
        this.servicioLibro = servicioLibro;
        this.servicioAutor = servicioAutor;
    }

    public void menu() throws Exception {
        String respuesta;
        do {
            System.out.println("Seleccione la opción que desea realizar");
            System.out.println("********************");
            System.out.println("1) Crear libro"
                    + "\n2) Mostrar libros"
                    + "\n3) Eliminar libro"
                    + "\n4) Modificar libro"
                    + "\n5) Buscar libro por título"
                    + "\n6) Buscar libro por ISBN"
                    + "\n7) Buscar libros por autor"
                    + "\n8) Buscar libros por editorial"
                    + "\n9) Crear autor"
                    + "\n10) Eliminar autor"
                    + "\n11) Modificar autor"
                    + "\n12) Buscar autor por nombre"
                    + "\n13) Mostrar autores"
                    + "\n 14) Salir");
            int opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    servicioLibro.crearLibro(cargarIsbn(), cargarTitulo(), cargarAnio(), cargarEjemplares(), cargarPrestados(), cargarRestantes(), cargarAlta(), cargarAutor(), cargarEditorial());
                    break;
                case 2:
                    servicioLibro.imprimirLibros();
                    break;
                case 3:
                    servicioLibro.eliminarLibro(respuesta);
                    break;
                case 4:
                    servicioLibro.modificarLibro(libro);
                    break;
                case 5:
                    servicioLibro.buscarLibroPorTitulo(respuesta);
                    break;
                case 6:
                    servicioLibro.buscarLibroPorIsbn(Long.MIN_VALUE);
                    break;
                case 7:
                    servicioLibro.buscarLibroPorAutor(autor);
                    break;
                case 8:
                    servicioLibro.buscarLibroPorEditorial(editorial);
                    break;
                case 9:
                    servicioAutor.crearAutor(respuesta, Boolean.FALSE);
                    break;
                case 10:
                    servicioAutor.eliminarAutor(respuesta);
                    break;
                case 11:
                    servicioAutor.modificarAutor(autor);
                    break;
                case 12:
                    servicioAutor.buscarAutorPorNombre(respuesta);
                    break;
                case 13:
                    servicioAutor.imprimirAutores();
                    break;
                case 14:
                    System.exit(0);
                    break;

            }
            System.out.println("¿Desea ralizar una nueva consulta? SI/NO");
            respuesta = leer.next();
            respuesta = respuesta.toUpperCase();
            limpiarPantalla();

        } while ("SI".equals(respuesta));

    }
    public void limpiarPantalla() throws AWTException{
        //Dejo esre metodo para ir borrando la consola.. y que no sea un desorden.
        Robot pressbot = new Robot();
        pressbot.setAutoDelay(30); // Tiempo de espera antes de borrar
        pressbot.keyPress(17); // Orden para apretar CTRL key
        pressbot.keyPress(76);// Orden para apretar L key
        pressbot.keyRelease(17); // Orden para soltar CTRL key
        pressbot.keyRelease(76); // Orden para soltar L key
    }
    
    public Long cargarIsbn() throws Exception{
        Long isbn;
        System.out.println("Ingrese el isbn del libro");
        isbn = leer.nextLong();
        return isbn;
    }
    
    public String cargarTitulo(){
        String titulo;
        System.out.println("Ingrese el título del libro");
        titulo = leer.next();
        return titulo;
    }
    
    public Integer cargarAnio(){
        Integer anio;
        System.out.println("Ingrese el año de publicación del libro");
        anio = leer.nextInt();
        return anio;
    }
    
    public Integer cargarEjemplares(){
        Integer ejemplares;
        System.out.println("Ingrese la cantidad de ejemplares totales");
        ejemplares = leer.nextInt();
        return ejemplares;
    }
    
    public Integer cargarPrestados(){
        Integer prestados;
        System.out.println("Ingrese la cantidad de ejemplares prestados");
        prestados = leer.nextInt();
        return prestados;
    }
    
    public Integer cargarRestantes(){
        Integer restantes;
        System.out.println("Ingrese la cantidad de libros disponibles");
        restantes = leer.nextInt();
        return restantes;
    }
    
    public Boolean cargarAlta(){
        Boolean alta = true;
        return alta;
    }
    
    public Autor cargarAutor(){
       Autor autor;
       System.out.println("Ingrese el autor del libro");
        
    }

}
