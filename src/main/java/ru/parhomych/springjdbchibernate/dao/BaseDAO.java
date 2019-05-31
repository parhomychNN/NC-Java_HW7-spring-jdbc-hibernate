package ru.parhomych.springjdbchibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.parhomych.springjdbchibernate.utils.HibernateSessionFactoryUtil;

//@Repository ("baseDAO")
public class BaseDAO {


    SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    protected Session getSession(){
        if (sessionFactory.isClosed()){
            sessionFactory.openSession();
        }
        return sessionFactory.getCurrentSession();
    }

    protected void persist(Object object){
        getSession().persist(object);
    }

    protected void delete(Object object){
        getSession().delete(object);
    }
}
