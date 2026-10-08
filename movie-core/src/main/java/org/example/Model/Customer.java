package org.example.Model;


public class Customer extends BaseEntity {

    private String name;
    private String email;
    private float amount;

    public  Customer() {

    }

    public Customer(
            int id,
            String name,
            String email,
            float amount
    ) {
        super(id);

        this.name = name;
        this.email = email;
        this.amount= amount;
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

    public void setAmount(float amount){this.amount=amount;}

    public  float getAmount(){return amount;}

    @Override
    public String toString() {

        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
