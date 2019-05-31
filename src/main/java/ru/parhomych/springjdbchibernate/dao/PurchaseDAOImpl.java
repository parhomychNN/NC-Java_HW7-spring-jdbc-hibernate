package ru.parhomych.springjdbchibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.parhomych.springjdbchibernate.model.Purchase;
import ru.parhomych.springjdbchibernate.utils.HibernateSessionFactoryUtil;

import java.util.List;

@Transactional
@Repository("PurchaseDAO")
public class PurchaseDAOImpl extends BaseDAO implements PurchaseDAO {
    @Override
    public void savePurchase(Purchase purchase) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(purchase);
        tx1.commit();
        session.close();
    }

    @Override
    public void updatePurchase(Purchase purchase) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(purchase);
        tx1.commit();
        session.close();
    }

    @Override
    public void deletePurchase(Purchase purchase) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(purchase);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Purchase> findAllPurchases() {
        return (List<Purchase>) HibernateSessionFactoryUtil.getSessionFactory().openSession().
                createQuery("From Purchase").list();
    }

    @Override
    public Purchase findPurchaseById(int id) {
        return sessionFactory.openSession().get(Purchase.class, id);
    }

    @Override
    public void deletePurchaseById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(findPurchaseById(id));
        tx1.commit();
        session.close();
    }

    @Override
    public int howManyPurchases() {
        long amount = ( (long) HibernateSessionFactoryUtil.getSessionFactory().
                openSession().createQuery("select count(*) from Purchase").iterate().next() );

        return Math.toIntExact(amount);
    }
}
