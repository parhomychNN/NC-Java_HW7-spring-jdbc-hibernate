package ru.parhomych.springjdbchibernate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private int id;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    //@Column(name = "seller")
    @JoinColumn(name = "seller")
    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

    //@Column(name = "customer")
    @JoinColumn(name = "customer")
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    //@Column(name = "book")

    @JoinColumn(name = "book")
    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    @Column(name = "quantity")
    private int quantity;

    //TODO: сделать автогенерацию значений при сеттере (quantity * book.getPrice())
    @Column(name = "purchase_sum")
    private double purchaseSum;

    public Purchase(Date purchaseDate, Shop shop, Customer customer, Book book, int quantity) {
        this.purchaseDate = purchaseDate;
        this.shop = shop;
        this.customer = customer;
        this.book = book;
        this.quantity = quantity;
        this.purchaseSum = quantity * book.getPrice();
    }

    @Override
    public String toString() {
        return "**************Purchase**************\n" +
                "* id=" + id + "\n" +
                "* purchaseDate=" + purchaseDate +
                "\n* " + shop +
                "\n* " + customer +
                "\n* " + book +
                "\n* quanity=" + quantity +
                "\n* purchaseSum=" + purchaseSum +
                "\n" +
                "**********************************\n";
    }
}
