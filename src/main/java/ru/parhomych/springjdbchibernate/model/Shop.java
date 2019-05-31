package ru.parhomych.springjdbchibernate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shop")
@NoArgsConstructor
@Getter
@Setter
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "district")
    private String district;

    @Column(name = "commission")
    private int commission;

    /*@OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Purchase> purchases;*/

    public Shop(String name, String district, int commission) {
        this.name = name;
        this.district = district;
        this.commission = commission;
        /*this.purchases = new ArrayList<>();*/
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", district='" + district + '\'' +
                ", commission=" + commission +
                '}';
    }
}
