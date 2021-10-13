
package libreria.servicios;

import java.util.Collection;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.AutorDAO;
import libreria.persistencia.EditorialDAO;
import libreria.persistencia.LibroDAO;


public class LibroServicio {
    public final LibroDAO daoLibro;
    public final AutorDAO daoAutor;
    public final EditorialDAO daoEditorial;

    public LibroServicio(LibroDAO daoLibro, AutorDAO daoAutor, EditorialDAO daoEditorial) {
        this.daoLibro = daoLibro;
        this.daoAutor = daoAutor;
        this.daoEditorial = daoEditorial;
    }
    
    public Libro crearLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestantes, Boolean alta, Autor autor, Editorial editorial){
        Libro libroNuevo = new Libro();
        try {
            if(isbn == null){
                throw new Exception("Debe indicar el isbn");
            }
            if(titulo == null || titulo.trim().isEmpty()){
                throw new Exception("Debe indicar el título del libro");
            }
            if(anio == null){
                throw new Exception("Debe indicar el año de publicación");
            }
            if(ejemplares == null){
                throw new Exception("Debe indicar la cantidad de ejemplares totales");
            }
            if(ejemplaresPrestados == null){
                throw new Exception("Debe indicar la cantidad de ejemplares prestados");
            }
            if(ejemplaresRestantes == null){
                throw new Exception("Debe indicar la cantidad de ejemplares restantes");
            }
            if(autor == null){
                throw new Exception("Debe indicar el autor");
            }
            if(editorial == null){
                throw new Exception("Debe indicar la editorial");
            }
            if(ejemplaresPrestados > ejemplares || ejemplaresRestantes > ejemplares){
                throw new Exception("Verifique la cantidad de ejemplares");
            }
            libroNuevo.setIsbn(isbn);
            libroNuevo.setTitulo(titulo);
            libroNuevo.setAnio(anio);
            libroNuevo.setEjemplares(ejemplares);
            libroNuevo.setEjemplaresPrestados(ejemplaresPrestados);
            libroNuevo.setEjemplaresRestantes(ejemplaresRestantes);
            libroNuevo.setAlta(alta);
            libroNuevo.setAutor(autor);
            libroNuevo.setEditorial(editorial);
            daoLibro.guardarLibro(libroNuevo);
            return libroNuevo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Libro buscarLibroPorTitulo(String titulo) throws Exception{
        try {
            if(titulo == null){
                throw new Exception("Debe indicar el título del libro a buscar");
            }
            Libro libro = daoLibro.buscarLibroTitulo(titulo);
            if(libro == null){
                throw new Exception("No se encontró ese libro");
            }
            return libro;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    
    public Libro buscarLibroPorIsbn(Long isbn) throws Exception{
        try {
            if(isbn == null){
                throw new Exception("Debe ingresar el isbn del libro a buscar");
            }
            Libro libro = daoLibro.buscarLibroIsbn(isbn);
            if(libro == null){
                throw new Exception("No se encontró el libro");
            }
            return libro;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Libro buscarLibroPorAutor(Autor autor) throws Exception{
        try {
            if(autor == null){
                throw new Exception("Debe indicar el autor");
            }
            Libro libro = daoLibro.buscarLibroAutor(autor);
            if(libro == null){
                throw new Exception("No se encontró un libro de ese autor");
            }
            return libro;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Libro buscarLibroPorEditorial(Editorial editorial) throws Exception{
        try {
            if(editorial == null){
                throw new Exception("Debe indicar la editorial del libro");
            }
            Libro libro = daoLibro.buscarLibroEditorial(editorial);
            if(libro == null){
                throw new Exception("No se encontró el libro");
            }
            return libro;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void eliminarLibro(String titulo) throws Exception{
        try {
            if(titulo == null || titulo.trim().isEmpty()){
                throw new Exception("Debe indicar el título del libro a eliminar");
            }
            daoLibro.eliminarLibroTitulo(titulo);
            System.out.println("El libro fue eliminado con éxito");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void modificarLibro(Libro libro) throws Exception{
        try {
            if(libro == null){
                throw new Exception("Debe indicar el libro a modificar");
            }
            daoLibro.modificarLibro(libro);
            System.out.println("Libro modificado con éxito");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Collection<Libro> listarLibros() throws Exception{
        try {
            Collection<Libro> libros = daoLibro.listarLibros();
            return libros;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void imprimirLibros() throws Exception{
        try {
            Collection<Libro> libros = listarLibros();
            if(libros.isEmpty()){
                throw new Exception("No existen libros para imprimir");
            }else{
                for (Libro l : libros) {
                    System.out.println("***********************");
                    System.out.println("ISBN libro: " + l.getIsbn()
                    + "\nTítulo libro: " + l.getTitulo()
                    + "\nAño de publicación: " + l.getAnio()
                    + "\nAutor: " + l.getAutor()
                    + "\nEditorial: " + l.getEditorial()
                    + "\nCantidad de ejemplares totales: " + l.getEjemplares()
                    + "\nCantidad de ejemplares prestados: " + l.getEjemplaresPrestados()
                    + "\nCantidad de ejemplares restantes: " + l.getEjemplaresRestantes()); 
                }
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
