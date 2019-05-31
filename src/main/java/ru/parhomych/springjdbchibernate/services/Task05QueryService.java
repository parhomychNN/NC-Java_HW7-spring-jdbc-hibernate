package ru.parhomych.springjdbchibernate.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import ru.parhomych.springjdbchibernate.utils.HibernateSessionFactoryUtil;

import java.util.Date;
import java.util.List;

public class Task05QueryService {

    public Task05QueryService() {

    }

    public static void getOrdersDateWithIncomeMoreThan60000(){

        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery(
                "select p.purchase_id, c.lastname, p.purchase_date " +
                        "from purchase as p, customer as c " +
                        "where p.purchase_sum >= 60000 AND p.customer = c.customer_id"
        );
        List<Object[]> rows = query.list();

        System.out.println("***********************");
        System.out.println("Задание 5a) номер заказа, фамилию покупателя и дату для покупок, в которых было продано книг на сумму не меньшую чем 60000 руб.");
        for(Object[] row : rows){
            System.out.println("Номер заказа с покупками более 60000 рублей: " + row[0].toString() + ", фамилия покупателя: " + row[1].toString() + ", дата покупки: " + row[2].toString());
        }

        transaction.commit();
    }

    public static void getPurchasesInOwnDistrictEarlierThanMarch(){

        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery(
                "select c.lastname, c.district, p.purchase_date " +
                        "from customer as c, purchase as p, shop as s " +
                        "where p.seller = s.shop_id and p.customer = c.customer_id and s.district = c.district and extract (MONTH from p.purchase_date) >= 4 " +
                        "order by p.purchase_date asc"
        );
        List<Object[]> rows = query.list();

        System.out.println("***********************");
        System.out.println("Задание 5b) покупки, сделанные покупателем в своем районе не ранее марта месяца. Вывести фамилию покупателя, район, дату. Произвести сортировку (произвёл по дате);");
        for(Object[] row : rows){
            System.out.println("Фамилия покупателя: " + row[0].toString() + ", район покупки: " + row[1].toString() + ", дата покупки: " + row[2].toString());
        }

        transaction.commit();
    }

    public static void getShopsExceptAutozWithCustomersDiscountFrom10to15(){

        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery(
                "select distinct s.shop_id, s.district, s.commission, s.name " +
                        "from shop as s, customer as c, purchase as p " +
                        "where p.seller = s.shop_id and c.customer_id = p.customer and s.district not like 'Автозаводский' and c.discount between 10 and 15"
        );
        List<Object[]> rows = query.list();

        System.out.println("***********************");
        System.out.println("Задание 5c) магазины, расположенные в любом районе, кроме Автозаводского, где покупали книги те, у кого скидка от 10 до 15 %;");
        for(Object[] row : rows){
            System.out.println("Id магазина: " + row[0].toString() + ", район магазина: " + row[1].toString() + ", комиссионные: " + row[2].toString() + ", название магазина: " + row[3].toString());
        }

        transaction.commit();
    }

    public static void getBooksPurchasedInDistrictOfStock(){

        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery(
                "select b.name, b.stock, b.quantity, b.price " +
                        "from book as b, purchase as p, shop as s " +
                        "where p.book = b.book_id and p.seller = s.shop_id and s.district = b.stock and b.quantity > 10" +
                        "order by b.price"
        );
        List<Object[]> rows = query.list();

        System.out.println("***********************");
        System.out.println("Задание 5d) данные по покупке книг (название, район складирования, количество), приобретенных в районе складирования и содержащихся в запасе более 10 штук. Включить данные о стоимости и отсортировать по возрастанию. ");
        for(Object[] row : rows){
            System.out.println("Название книги: " + row[0].toString() + ", район склада: " + row[1].toString() + ", количество: " + row[2].toString() + ", цена книги: " + row[3].toString());
        }

        transaction.commit();
    }

}
