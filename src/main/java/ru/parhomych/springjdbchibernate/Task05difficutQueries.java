package ru.parhomych.springjdbchibernate;

import ru.parhomych.springjdbchibernate.services.Task05QueryService;

public class Task05difficutQueries {

    public static void main(String[] args) {
        // 5a) номер заказа, фамилию покупателя и дату для покупок, в которых было продано книг на сумму не меньшую чем 60000 руб.
        Task05QueryService.getOrdersDateWithIncomeMoreThan60000();

        // 5b) покупки, сделанные покупателем в своем районе не ранее марта месяца. Вывести фамилию покупателя, район, дату. Произвести сортировку;
        Task05QueryService.getPurchasesInOwnDistrictEarlierThanMarch();

        // 5c) магазины, расположенные в любом районе, кроме Автозаводского, где покупали книги те, у кого скидка от 10 до 15 %;
        Task05QueryService.getShopsExceptAutozWithCustomersDiscountFrom10to15();

        // 5d) данные по покупке книг (название, район складирования, количество), приобретенных в районе складирования и содержащихся в запасе более 10 штук. Включить данные о стоимости и отсортировать по возрастанию.
        Task05QueryService.getBooksPurchasedInDistrictOfStock();
    }


}
