package ru.parhomych.springjdbchibernate.dao;

import ru.parhomych.springjdbchibernate.model.Purchase;
import ru.parhomych.springjdbchibernate.model.Shop;

import java.util.List;

public interface PurchaseDAO {

    void savePurchase(Purchase purchase);
    void updatePurchase(Purchase purchase);
    void deletePurchase(Purchase purchase);
    List<Purchase> findAllPurchases();
    Purchase findPurchaseById(int id);
    void deletePurchaseById(int id);
    int howManyPurchases();

}
