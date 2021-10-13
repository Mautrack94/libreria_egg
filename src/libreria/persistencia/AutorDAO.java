
package libreria.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidades.Autor;


public class AutorDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private final EntityManager em = emf.createEntityManager();
    
    public void guardarAutor(Autor autor) throws Exception{
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
    }
    
    public void eliminarAutor(String nombre)throws Exception{
        Autor autor = buscarAutor(nombre);
        em.getTransaction().begin();
        em.remove(autor);
        em.getTransaction().commit();
    }
    
    public Autor buscarAutor(String nombre) throws Exception{
        Autor autor = em.find(Autor.class, nombre);
        return autor;
    }
    
    public void modificarAutor(Autor autor) throws Exception{
        em.getTransaction().begin();
        em.merge(autor);
        em.getTransaction().commit();
    }
    
    public List<Autor> listarAutores() throws Exception{
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a")
                .getResultList();
        return autores;
    }
}
