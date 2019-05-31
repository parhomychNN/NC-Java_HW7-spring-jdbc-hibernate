package ru.parhomych.springjdbchibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.parhomych.springjdbchibernate.model.Customer;
import ru.parhomych.springjdbchibernate.utils.HibernateSessionFactoryUtil;

import java.util.List;

@Repository("customerDAO")
@Transactional
public class CustomerDAOImpl extends BaseDAO implements CustomerDAO {
    @Override
    public void saveCustomer(Customer customer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(customer);
        tx1.commit();
        session.close();
    }

    @Override
    public void updateCustomer(Customer customer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(customer);
        tx1.commit();
        session.close();
    }

    @Override
    public void deleteCustomer(Customer customer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(customer);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Customer> findAllCustomers() {
        return (List<Customer>) HibernateSessionFactoryUtil.getSessionFactory().openSession().
                createQuery("From Customer").list();
    }

    @Override
    public Customer findCustomerById(int id) {
        return sessionFactory.openSession().get(Customer.class, id);
    }

    @Override
    public void deleteCustomerById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(findCustomerById(id));
        tx1.commit();
        session.close();
    }

    @Override
    public int howManyCustomers() {
        long amount = ( (long) HibernateSessionFactoryUtil.getSessionFactory().
                openSession().createQuery("select count(*) from Customer").iterate().next() );

        return Math.toIntExact(amount);
    }
}
