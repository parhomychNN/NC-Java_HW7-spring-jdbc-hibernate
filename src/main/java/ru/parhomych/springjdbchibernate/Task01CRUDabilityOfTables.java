package ru.parhomych.springjdbchibernate;

import org.springframework.beans.factory.annotation.Autowired;
import ru.parhomych.springjdbchibernate.model.Book;
import ru.parhomych.springjdbchibernate.model.Customer;
import ru.parhomych.springjdbchibernate.model.Purchase;
import ru.parhomych.springjdbchibernate.model.Shop;
import ru.parhomych.springjdbchibernate.services.BookService;
import ru.parhomych.springjdbchibernate.services.CustomerService;
import ru.parhomych.springjdbchibernate.services.PurchaseService;
import ru.parhomych.springjdbchibernate.services.ShopService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class Task01CRUDabilityOfTables {

    public static void main(String[] args) {

        BookService bookService = new BookService();
        CustomerService customerService = new CustomerService();
        PurchaseService purchaseService = new PurchaseService();
        ShopService shopService = new ShopService();

        // добавление элемента
        System.out.println("How many purchases before adding? ==>>> " + purchaseService.howManyPurchases());
        Book book1 = bookService.findBook(4);
        Customer customer1 = customerService.findCustomer(3);
        Shop shop1 = shopService.findShop(1);
        Purchase purchase1 = new Purchase(new Date(119,12,11), shop1, customer1, book1, 2);
        purchaseService.addPurchase(purchase1);
        System.out.println("How many purchases after adding? ==>>> " + purchaseService.howManyPurchases());


        // удаление элемента
        purchaseService.deletePurchase(purchase1);
        System.out.println("How many purchases after deleting? ==>>> " + purchaseService.howManyPurchases());

        // вывод всех значений таблиц
        System.out.println("**************** BOOKS ********************");
        ArrayList<Book> allBooks = (ArrayList<Book>) bookService.findAllBooks();
        for (Book book : allBooks){
            System.out.println(book);
        }

        System.out.println("**************** SHOPS ********************");
        ArrayList<Shop> allShops = (ArrayList<Shop>) shopService.findAllShops();
        for (Shop shop : allShops){
            System.out.println(shop);
        }

        System.out.println("**************** CUSTOMERS ********************");
        ArrayList<Customer> allCustomers = (ArrayList<Customer>) customerService.findAllCustomers();
        for (Customer customer : allCustomers){
            System.out.println(customer);
        }

        System.out.println("**************** PURCHASES ********************");
        ArrayList<Purchase> allPurchases = (ArrayList<Purchase>) purchaseService.findAllPurchases();
        for (Purchase purchase : allPurchases){
            System.out.println(purchase);
        }

        // обновление элемента
        Book book2 = bookService.findBook(4);
        System.out.println("Book before updating");
        System.out.println(book2);
        System.out.println("Book after updating");
        book2.setName("Измененное название");
        book2.setPrice(0);
        bookService.updateBook(book2);
        book2 = bookService.findBook(4);
        System.out.println(book2);

        Purchase purchase2 = purchaseService.findPurchase(3);
        System.out.println("Purchase before updating");
        System.out.println(purchase2);
        System.out.println("Purchase after updating");
        purchase2.setQuantity(222);
        purchase2.setBook(bookService.findBook(4));
        purchaseService.updatePurchase(purchase2);
        purchase2 = purchaseService.findPurchase(3);
        System.out.println(purchase2);

        //Количество строк в таблице
        System.out.println("How many books? ==>>> " + bookService.howManyBooks());
        System.out.println("How many shops? ==>>> " + shopService.howManyShops());
        System.out.println("How many customers? ==>>> " + customerService.howManyCustomers());
        System.out.println("How many purchases? ==>>> " + purchaseService.howManyPurchases());



    }

}
