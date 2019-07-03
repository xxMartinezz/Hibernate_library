import javax.persistence.EntityManager;

public class AuthorDao extends AbstractDao<Author>
{
    public AuthorDao(EntityManager em)
    {
        super(em, Author.class);
    }
}
