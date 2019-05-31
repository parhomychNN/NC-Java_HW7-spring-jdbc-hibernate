package ru.parhomych.springjdbchibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.parhomych.springjdbchibernate.model.Book;
import ru.parhomych.springjdbchibernate.services.*;

@ComponentScan("ru.parhomych.services")
public class Task02makeQueryForInfo {

    public static void main(String[] args) {

        System.out.println("2. Создать запросы для вывода");
        // Задание 2a) (всех различных названий и стоимостей книг)
        Task02QueryService.getDifferNamesAndPriceOfbooks();

        // Задание 2b) (всех различных районов, в которых проживают покупатели)
        Task02QueryService.getDifferDistrictsOfCustomers();

        //Задание 2c) (всех различных месяцев, когда производились покупки)
        Task02QueryService.getDifferMonthesofPurchases();
    }
}
