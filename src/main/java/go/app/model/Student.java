package go.app.model;

import javax.persistence.*;

@Entity
@Table( name = "Student")
public class Student {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToOne( cascade = CascadeType.ALL)
    private Address address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
