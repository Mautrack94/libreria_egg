
package libreria.servicios;

import java.util.List;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;


public class AutorServicio {
    private final AutorDAO daoAutor;
    private final LibroServicio servicioLibro;

    public AutorServicio(AutorDAO daoAutor, LibroServicio servicioLibro) {
        this.daoAutor = daoAutor;
        this.servicioLibro = servicioLibro;
    }
    
    public Autor crearAutor(String nombre, Boolean alta) throws Exception{
        Autor nuevoAutor = new Autor();
        try {
            if(nombre == null || nombre.trim().isEmpty()){
            throw new Exception("Debe indicar el nombre del autor");
        }
            nuevoAutor.setNombre(nombre);
            nuevoAutor.setAlta(alta);
            daoAutor.guardarAutor(nuevoAutor);
            return nuevoAutor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void eliminarAutor(String nombre) throws Exception{
        try {
            if(nombre == null || nombre.trim().isEmpty()){
                throw new Exception("Debe indicar el nombre del autor");
            }
            daoAutor.eliminarAutor(nombre);
            System.out.println("Autor eliminado con éxito");
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Autor buscarAutorPorNombre(String nombre) throws Exception{
        try {
            if(nombre == null || nombre.trim().isEmpty()){
                throw new Exception("Debe indicar el nombre del autor a buscar");
            }
            Autor autor = daoAutor.buscarAutor(nombre);
            return autor;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarAutor(Autor autor) throws Exception{
        try {
            if(autor == null){
                throw new Exception("Debe indicar el autor a modificar");
            }
            daoAutor.modificarAutor(autor);
            System.out.println("Autor modificado con éxito");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<Autor> listarAutores() throws Exception{
        try {
            List<Autor> autores = daoAutor.listarAutores();
            return autores;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void imprimirAutores() throws Exception{
        try {
            List<Autor> autores = listarAutores();
            if(autores.isEmpty()){
                throw new Exception("No existen autores para mostrar");
            }else{
                for (Autor a : autores) {
                    System.out.println("*******************");
                    System.out.println("Nombre del autor:" + a.getNombre());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
