package ru.parhomych.springjdbchibernate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "district")
    private String district;

    @Column(name = "discount")
    private int discount;

    /*@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Purchase> purchases;*/

    public Customer(String lastname, String district, int discount) {
        this.lastname = lastname;
        this.district = district;
        this.discount = discount;
        /*this.purchases = new ArrayList<>();*/
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", district='" + district + '\'' +
                ", discount=" + discount +
                '}';
    }
}
