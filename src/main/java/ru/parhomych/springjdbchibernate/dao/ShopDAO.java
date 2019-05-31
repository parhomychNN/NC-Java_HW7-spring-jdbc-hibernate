package ru.parhomych.springjdbchibernate.dao;

import ru.parhomych.springjdbchibernate.model.Book;
import ru.parhomych.springjdbchibernate.model.Shop;

import java.util.List;

public interface ShopDAO {

    void saveShop(Shop shop);
    void updateShop(Shop shop);
    void deleteShop(Shop shop);
    List<Shop> findAllShops();
    Shop findShopById(int id);
    void deleteShopById(int id);
    int howManyShops();

}
