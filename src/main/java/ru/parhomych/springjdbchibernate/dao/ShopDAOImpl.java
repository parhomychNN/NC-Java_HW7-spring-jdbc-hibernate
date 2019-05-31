package ru.parhomych.springjdbchibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.parhomych.springjdbchibernate.model.Shop;
import ru.parhomych.springjdbchibernate.utils.HibernateSessionFactoryUtil;

import java.util.List;


@Transactional
@Repository("ShopDAO")
public class ShopDAOImpl extends BaseDAO implements ShopDAO {
    @Override
    public void saveShop(Shop shop) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(shop);
        tx1.commit();
        session.close();
    }

    @Override
    public void updateShop(Shop shop) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(shop);
        tx1.commit();
        session.close();
    }

    @Override
    public void deleteShop(Shop shop) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(shop);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Shop> findAllShops() {
        return (List<Shop>) HibernateSessionFactoryUtil.getSessionFactory().openSession().
                createQuery("From Shop").list();
    }

    @Override
    public Shop findShopById(int id) {
        return sessionFactory.openSession().get(Shop.class, id);
    }

    @Override
    public void deleteShopById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(findShopById(id));
        tx1.commit();
        session.close();
    }

    @Override
    public int howManyShops() {
        long amount = ( (long) HibernateSessionFactoryUtil.getSessionFactory().
                openSession().createQuery("select count(*) from Shop").iterate().next() );

        return Math.toIntExact(amount);
    }
}
