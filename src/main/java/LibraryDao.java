import javax.persistence.EntityManager;

public class LibraryDao extends AbstractDao<Library>
{
    public LibraryDao(EntityManager em)
    {
        super(em, Library.class);
    }
}
