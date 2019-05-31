package ru.parhomych.springjdbchibernate.services;

import lombok.NoArgsConstructor;
import ru.parhomych.springjdbchibernate.dao.BookDAOImpl;
import ru.parhomych.springjdbchibernate.dao.ShopDAOImpl;
import ru.parhomych.springjdbchibernate.model.Book;
import ru.parhomych.springjdbchibernate.model.Customer;
import ru.parhomych.springjdbchibernate.model.Purchase;
import ru.parhomych.springjdbchibernate.model.Shop;

import java.util.List;

@NoArgsConstructor
public class ShopService {

    private ShopDAOImpl shopDAOImpl = new ShopDAOImpl();

    public Shop findShop(int id){
        return shopDAOImpl.findShopById(id);
    }

    public void addShop(Shop shop){
        shopDAOImpl.saveShop(shop);
    }

    public void deleteShop(Shop shop){
        shopDAOImpl.deleteShop(shop);
    }

    public void deleteShopByID(int id){
        shopDAOImpl.deleteShopById(id);
    }

    public void updateShop(Shop shop){
        shopDAOImpl.updateShop(shop);
    }

    public List<Shop> findAllShops(){
        return shopDAOImpl.findAllShops();
    }

    public int howManyShops(){
        return shopDAOImpl.howManyShops();
    }

}
