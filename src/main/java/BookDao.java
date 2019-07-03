import javax.persistence.EntityManager;

public class BookDao extends AbstractDao<Book>
{
    public BookDao(EntityManager em)
    {
        super(em, Book.class);
    }
}
