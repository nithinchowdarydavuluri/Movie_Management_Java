package org.example.Model;


public class Customer extends BaseEntity {

    private String name;
    private String email;

    public  Customer() {

    }

    public Customer(
            int id,
            String name,
            String email
    ) {
        super(id);

        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {

        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
