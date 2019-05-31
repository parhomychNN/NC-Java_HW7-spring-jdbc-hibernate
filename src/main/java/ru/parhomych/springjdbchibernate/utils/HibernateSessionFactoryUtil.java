package ru.parhomych.springjdbchibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import ru.parhomych.springjdbchibernate.model.Book;
import ru.parhomych.springjdbchibernate.model.Customer;
import ru.parhomych.springjdbchibernate.model.Purchase;
import ru.parhomych.springjdbchibernate.model.Shop;

public class HibernateSessionFactoryUtil {


    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    @Bean
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Book.class);
                configuration.addAnnotatedClass(Customer.class);
                configuration.addAnnotatedClass(Shop.class);
                configuration.addAnnotatedClass(Purchase.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
