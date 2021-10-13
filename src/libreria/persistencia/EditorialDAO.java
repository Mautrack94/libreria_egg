
package libreria.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidades.Editorial;


public class EditorialDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private final EntityManager em = emf.createEntityManager();
    
    public void guardarEditorial(Editorial editorial) throws Exception{
        em.getTransaction().begin();
        em.persist(editorial);
        em.getTransaction().commit();
    }
    
    public void eliminarEditorial(String nombre) throws Exception{
        Editorial editorial = buscarEditorial(nombre);
        em.getTransaction().begin();
        em.remove(editorial);
        em.getTransaction().commit();
    }
    
    public Editorial buscarEditorial(String nombre) throws Exception{
        Editorial editorial = em.find(Editorial.class, nombre);
        return editorial;
    }
    
    public void modificarEditorial(Editorial editorial) throws Exception{
        em.getTransaction().begin();
        em.merge(editorial);
        em.getTransaction().commit();
    }
}
