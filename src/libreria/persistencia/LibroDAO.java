
package libreria.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;


public class LibroDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private final EntityManager em = emf.createEntityManager();
    
    public void guardarLibro(Libro libro) throws Exception{
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
    }
    
    public void modificarLibro(Libro libro) throws Exception{
        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();
    }
    
    public void eliminarLibroId(Integer id) throws Exception{
        Libro libro = buscarLibroId(id);
        em.getTransaction().begin();
        em.remove(libro);
        em.getTransaction().commit();
    }
    
    public Libro buscarLibroId(Integer id) throws Exception{
        Libro libro = em.find(Libro.class, id);
        return libro;
    } 
    
    public void eliminarLibroTitulo(String titulo) throws Exception{
        Libro libro = buscarLibroTitulo(titulo);
        em.getTransaction().begin();
        em.remove(libro);
        em.getTransaction().commit();
    }
    
    public Libro buscarLibroTitulo(String titulo) throws Exception{
        Libro libro = (Libro) em.createQuery("SELECT d"
        + "FROM Libro d"
        + "WHERE d.titulo LIKE :titulo").
                setParameter("titulo", titulo).
                getSingleResult();
        return libro;
    }
    
    public List<Libro> listarLibros() throws Exception{
        List<Libro> libros = em.createQuery("SELECT d FROM Libro d")
                .getResultList();
        return libros;
    }
    
    public Libro buscarLibroIsbn(Long isbn) throws Exception{
        Libro libro = (Libro) em.createQuery("SELECT d FROM Libro"
        + "WHERE d.isbn LIKE :isbn")
                .setParameter("isbn", isbn)
                .getSingleResult();
        return libro;
    }
    
    public Libro buscarLibroAutor(Autor autor) throws Exception{
       Libro libro = (Libro) em.createQuery("SELECT d FROM Libro"
               + "WHERE d.autor LIKE :autor")
               .setParameter("autor", autor)
               .getSingleResult();
        return libro;
    }
    
    public Libro buscarLibroEditorial(Editorial editorial) throws Exception{
        Libro libro = (Libro) em.createQuery("SELECT d FROM Libro"
        + "WHERE d.editorial LIKE :editorial")
                .setParameter("editorial", editorial)
                .getSingleResult();
        return libro;
    }
}
