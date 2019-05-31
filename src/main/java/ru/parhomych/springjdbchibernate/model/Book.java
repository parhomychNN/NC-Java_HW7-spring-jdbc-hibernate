package ru.parhomych.springjdbchibernate.model;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "stock")
    private String stock;

    @Column(name = "quantity")
    private int quantity;

    /*@OneToMany(mappedBy = "book")
    List<Purchase> purchases;*/

    public Book(String name, double price, String stock, int quantity) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.quantity = quantity;
        //this.purchases = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock='" + stock + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
