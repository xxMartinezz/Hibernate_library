import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "LIBRARY")
public class Library
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ElementCollection
    @CollectionTable(name="LIBRARY_ADDRESS", joinColumns = @JoinColumn(name="LIBRARY_ID"))
    private List<Address> Address = new ArrayList<Address>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "LIBRARY_ID")
    private List<Book> books = new ArrayList<>();

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Address=" + Address +
                //", books=" + books +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddress() {
        return Address;
    }

    public void setAddress(List<Address> address) {
        Address = address;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
