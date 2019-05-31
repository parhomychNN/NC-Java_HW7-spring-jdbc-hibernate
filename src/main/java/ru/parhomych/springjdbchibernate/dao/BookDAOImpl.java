package ru.parhomych.springjdbchibernate.dao;

import lombok.NoArgsConstructor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.parhomych.springjdbchibernate.model.Book;
import ru.parhomych.springjdbchibernate.utils.HibernateSessionFactoryUtil;

import java.util.List;

@Repository("bookDAO")
@Transactional
public class BookDAOImpl extends BaseDAO implements BookDAO {

    @Override
    public void saveBook(Book book) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(book);
        tx1.commit();
        session.close();
    }

    @Override
    public void updateBook(Book book) {
        //Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction tx1 = session.beginTransaction();
        session.update(book);
        tx1.commit();
        session.close();
    }

    @Override
    public void deleteBook(Book book) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(book);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Book> findAllBooks() {
        return (List<Book>) HibernateSessionFactoryUtil.getSessionFactory().openSession().
                createQuery("From Book").list();
    }

    @Override
    public Book findById(int id) {

        Book book = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Book.class, id);

        return book;

    }

    @Override
    public void deleteBookById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(findById(id));
        tx1.commit();
        session.close();
    }

    @Override
    public int howManyBooks() {
        long amount = ( (long) HibernateSessionFactoryUtil.getSessionFactory().
                openSession().createQuery("select count(*) from Book").iterate().next() );

        return Math.toIntExact(amount);
    }
}
