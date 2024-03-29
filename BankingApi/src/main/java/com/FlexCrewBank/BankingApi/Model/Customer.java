package com.FlexCrewBank.BankingApi.Model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "CUSTOMER_FIRST_NAME")
    private String first_name;
    @Column(name = "CUSTOMER_LAST_NAME")
    private String last_name;

    @JoinColumn(name = "CUSTOMER_ADDRESSES")
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Address> address;

    public Customer() {
    }

    public Customer(Long id, String first_name, String last_name, Set<Address> address) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }
}
