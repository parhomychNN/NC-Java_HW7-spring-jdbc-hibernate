package ru.parhomych.springjdbchibernate;

import org.springframework.context.annotation.ComponentScan;
import ru.parhomych.springjdbchibernate.model.Purchase;
import ru.parhomych.springjdbchibernate.services.PurchaseService;
import ru.parhomych.springjdbchibernate.services.Task03QueryService;

import java.util.List;

public class Task04purchaseInfo {

    public static void main(String[] args) {

        PurchaseService purchaseService = new PurchaseService();

        System.out.println("Для каждой покупки вывести следующие данные:");
        System.out.println("*********************************");
        System.out.println("Задание 4a) фамилию покупателя и название магазина, где производилась покупка;");

        List<Purchase> purchases = purchaseService.findAllPurchases();

        for (Purchase purchase :
                purchases) {
            System.out.println("ID покупки: " + purchase.getId() +
                    ", фамилия покупателя: " + purchase.getCustomer().getLastname() +
                    ", название магазина: " + purchase.getShop().getName()
                    );
        }

        System.out.println("*********************************");
        System.out.println("Задание 4b) дату, фамилию покупателя, скидку, название и количество купленных книг:");

        for (Purchase purchase :
                purchases) {
            System.out.println("ID покупки: " + purchase.getId() +
                    ", дата: " + purchase.getPurchaseDate().toString() +
                    ", фамилия покупателя: " + purchase.getCustomer().getLastname() +
                    ", его скидка: " + purchase.getCustomer().getDiscount() +
                    ", название книги: " + purchase.getBook().getName() +
                    ", количество купленных книг: " + purchase.getQuantity()
            );
        }

    }
}
