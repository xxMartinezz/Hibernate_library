import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil
{
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit-h2");

    private static EntityManager em;

    public static EntityManager getEntityManager()
    {
        if(em == null)
        {
            em = emf.createEntityManager();
        }
            return em;
    }
}
