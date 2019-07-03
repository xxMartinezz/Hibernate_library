import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address
{
    @Column(name = "ADDRESS_CITY")
    private String city;

    @Column(name = "ADDRESS_STREET")
    private String street;

    @Column(name = "ADDRESS_NUMBER")
    private String number;

    public Address() { }

    public Address(String city, String street, String number)
    {
        this.city = city;
        this.street = street;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Address{" +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
