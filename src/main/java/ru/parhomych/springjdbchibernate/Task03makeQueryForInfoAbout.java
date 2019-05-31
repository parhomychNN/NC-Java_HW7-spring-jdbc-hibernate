package ru.parhomych.springjdbchibernate;

import org.springframework.context.annotation.ComponentScan;
import ru.parhomych.springjdbchibernate.services.*;

@ComponentScan("ru.parhomych.services")
public class Task03makeQueryForInfoAbout {

    public static void main(String[] args) {

        System.out.println("3. Создать запросы для получения информации о:");
        // Задание 3а) фамилиях и размере скидки всех покупателей, проживающих в Нижегородском районе
        Task03QueryService.getLastNamesAndDiscountsOfNizhegDistrict();

        // Задание 3b) названиях магазинов Сормовского и Советского районов
        Task03QueryService.getNamesOfShopsInSormAndSovDistricts();

        // Задание 3c) Названиях  и стоимости книг, в которых встречается слово Windows, или стоящих более 20000 руб. Вывод результатов организовать по названию и убыванию цены книг.
        Task03QueryService.getWindowsNamedOrCostMoreThan20000Books();
    }
}
