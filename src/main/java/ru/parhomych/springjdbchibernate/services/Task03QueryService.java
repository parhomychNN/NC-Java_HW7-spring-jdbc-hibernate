package ru.parhomych.springjdbchibernate.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import ru.parhomych.springjdbchibernate.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class Task03QueryService {

    public Task03QueryService() {

    }

    public static void getLastNamesAndDiscountsOfNizhegDistrict(){
        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.beginTransaction();
        NativeQuery query = session.createSQLQuery("select lastname, discount from customer where district = 'Нижегородский'");
        List<Object[]> rows = query.list();

        System.out.println("***********************");
        System.out.println("Задание 3а) фамилиях и размере скидки всех покупателей, проживающих в Нижегородском районе");
        for(Object[] row : rows){
            System.out.println("Фамилия клиента: " + row[0].toString() + ", его скидка: " + row[1].toString() + "%");
        }

        transaction.commit();
    }
    public static void getNamesOfShopsInSormAndSovDistricts(){

        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.beginTransaction();
        NativeQuery query = session.createSQLQuery("select name from shop where district='Сормовский' OR district='Советский'");
        List<String> rows = query.list();

        System.out.println("***********************");
        System.out.println("Задание 3b) (названиях магазинов Сормовского и Советского районов)");
        for(String row : rows){
            System.out.println("Есть такой магазин: " + row);
        }

        transaction.commit();
    }


    public static void getWindowsNamedOrCostMoreThan20000Books(){

        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.beginTransaction();
        NativeQuery query = session.createSQLQuery(
                "select name, price from book where lower(name) like '%windows%' or price > 20000 order by name asc, price desc"
        );
        List<Object[]> rows = query.list();

        System.out.println("***********************");
        System.out.println("Задание 3c) Названиях  и стоимости книг, в которых встречается слово Windows, или стоящих более 20000 руб. Вывод результатов организовать по названию и убыванию цены книг.");
        for(Object[] row : rows){
            System.out.println("Название книги: " + row[0] + ", ее цена: " + row[1]);
        }

        transaction.commit();
    }

}
