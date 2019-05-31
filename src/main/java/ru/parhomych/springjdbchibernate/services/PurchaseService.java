package ru.parhomych.springjdbchibernate.services;

import lombok.NoArgsConstructor;
import ru.parhomych.springjdbchibernate.dao.BookDAOImpl;
import ru.parhomych.springjdbchibernate.dao.PurchaseDAOImpl;
import ru.parhomych.springjdbchibernate.model.Book;
import ru.parhomych.springjdbchibernate.model.Customer;
import ru.parhomych.springjdbchibernate.model.Purchase;

import java.util.List;

@NoArgsConstructor
public class PurchaseService {

    private PurchaseDAOImpl purchaseDAOImpl = new PurchaseDAOImpl();

    public Purchase findPurchase(int id){
        return purchaseDAOImpl.findPurchaseById(id);
    }

    public void addPurchase(Purchase purchase){
        purchaseDAOImpl.savePurchase(purchase);
    }

    public void deletePurchase(Purchase purchase){
        purchaseDAOImpl.deletePurchase(purchase);
    }

    public void deletePurchaseByID(int id){
        purchaseDAOImpl.deletePurchaseById(id);
    }

    public void updatePurchase(Purchase purchase){
        purchaseDAOImpl.updatePurchase(purchase);
    }

    public List<Purchase> findAllPurchases(){
        return purchaseDAOImpl.findAllPurchases();
    }

    public int howManyPurchases(){
        return purchaseDAOImpl.howManyPurchases();
    }
}
