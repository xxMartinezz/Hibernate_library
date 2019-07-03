import javax.persistence.EntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

public class Main
{
    public static void main(String[] args) throws ParseException {
        EntityManager em = HibernateUtil.getEntityManager();

        //tworzenie obiektow dao
        LibraryDao libraryDao = new LibraryDao(em);
        BookDao bookDao = new BookDao(em);
        AuthorDao authorDao = new AuthorDao(em);

        //tworzenie obiektow na bazie klasy Library
        Library library1 = new Library();
        Library library2 = new Library();

        //tworzenie obiektow na bazie klasy Book
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = new Book();
        Book book5 = new Book();

        //tworzenie obiektow na bazie klasy Author
        Author author1 = new Author();
        Author author2 = new Author();

        //tworzenie obiektow na bazie klasy Address
        Address address1 = new Address("Wrocław", "Reja", "123");
        Address address2 = new Address("Wrocław", "Legnicka", "31");

        //tworzenie dat
        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse("12-03-2018");
        Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse("13-03-2018");

        //ustawianie pol obiektow Library
        library1.setName("Biblioteka rodzinna");
        library1.setAddress(Collections.singletonList(address1));
        library1.getBooks().add(book1);
        library1.getBooks().add(book2);
        libraryDao.save(library1);

        library2.setName("Biblioteka techniczna");
        library2.setAddress(Collections.singletonList(address2));
        library2.getBooks().add(book3);
        library2.getBooks().add(book4);
        library2.getBooks().add(book5);
        libraryDao.save(library2);

        //ustawianie pol obiektow Book
        book1.setTitle("Chłopcy z placu broni");
        book1.setIsbn("1331124-32");
        book1.setDescription("O chłopcach z placu broni");
        book1.getAuthors().add(author1);
        book1.setDate(date1);
        bookDao.save(book1);

        book2.setTitle("Seria niefortunnych zdarzeń");
        book2.setIsbn("133143424-32");
        book2.setDescription("Trójka rodzeństwa napotyka na złego Hrabiego Olafa");
        book2.getAuthors().add(author1);
        book2.setDate(date2);
        bookDao.save(book2);

        book3.setTitle("Elon Musk biography");
        book3.setIsbn("1331124-32");
        book3.setDescription("Biografia Elona Muska");
        book3.getAuthors().add(author2);
        book3.setDate(new Date());
        bookDao.save(book3);

        book4.setTitle("Java w 24 godziny");
        book4.setIsbn("1-32");
        book4.setDescription("Podstawy języka Java");
        book4.getAuthors().add(author2);
        book4.setDate(new Date());
        bookDao.save(book4);

        book5.setTitle("Mikrokontrolery AVR");
        book5.setIsbn("134-32");
        book5.setDescription("Książka na temat mikrokontrolerów z rodziny AVR");
        book5.getAuthors().add(author2);
        book5.getAuthors().add(author1);
        bookDao.save(book5);

        //ustawianie pol obiektow Author
        author1.setCountry(Country.POLAND);
        author1.setFirstName("Janusz");
        author1.setLastName("Pisarz");
        author1.getBooks().add(book1);
        author1.getBooks().add(book2);
        authorDao.save(author1);

        author2.setCountry(Country.GERMANY);
        author2.setFirstName("Albert");
        author2.setLastName("Muller");
        author2.getBooks().add(book3);
        author2.getBooks().add(book4);
        author2.getBooks().add(book5);
        authorDao.save(author2);

        //dodawanie do bazy danych
        em.getTransaction().begin();

        em.getTransaction().commit();

        //System.out.println(libraryDao.findAll());

        //System.out.println(book1.toString());

        //System.out.println(bookDao.findById((long) 3));

        //System.out.println(authorDao.findAll());

        System.out.println(library1.getBooks());

        //System.out.println(author1.getBooks());

        //System.out.println(book5.getAuthors());

        //System.out.println(library1.getBooks());

        em.close();
    }
}