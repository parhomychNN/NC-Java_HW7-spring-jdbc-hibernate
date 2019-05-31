package ru.parhomych.springjdbchibernate.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import ru.parhomych.springjdbchibernate.utils.HibernateSessionFactoryUtil;

import java.util.Date;
import java.util.List;

public class Task02QueryService {

    public Task02QueryService() {

    }

    public static void getDifferNamesAndPriceOfbooks(){
        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.beginTransaction();
        NativeQuery query = session.createSQLQuery("select distinct name, price from book");
        List<Object[]> rows = query.list();

        System.out.println("***********************");
        System.out.println("Задание 2а) создать запрос для вывода всех различных названий и стоимостей книг");
        for(Object[] row : rows){
            System.out.println("Name: " + row[0].toString() + ", price: " + row[1]);
        }

        transaction.commit();
    }

    public static void getDifferDistrictsOfCustomers(){

        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.beginTransaction();
        NativeQuery query = session.createSQLQuery("select distinct district from customer");
        List<String> rows = query.list();

        System.out.println("***********************");
        System.out.println("Задание 2b) (всех различных районов, в которых проживают покупатели)");
        for(String row : rows){
            System.out.println("Есть такой район: " + row);
        }

        transaction.commit();
    }


    public static void getDifferMonthesofPurchases(){

        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.beginTransaction();
        NativeQuery query = session.createSQLQuery("select distinct to_char(purchase_date, 'Month') from purchase");
        List<String> rows = query.list();

        System.out.println("***********************");
        System.out.println("Задание 2c) (всех различных месяцев, когда производились покупки)");
        for(String row : rows){
            System.out.println("Покупки совершались в месяц: " + row);
        }

        transaction.commit();
    }

}
