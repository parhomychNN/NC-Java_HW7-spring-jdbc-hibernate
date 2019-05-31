package ru.parhomych.springjdbchibernate.services;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.parhomych.springjdbchibernate.dao.BookDAOImpl;
import ru.parhomych.springjdbchibernate.model.Book;

import java.util.List;

@Service("bookService")
@NoArgsConstructor
public class BookService {

    private BookDAOImpl bookDAO = new BookDAOImpl();

    public Book findBook(int id){
        return bookDAO.findById(id);
    }

    public void addBook(Book book){
        bookDAO.saveBook(book);
    }

    public void deleteBook(Book book){
        bookDAO.deleteBook(book);
    }

    public void deleteBookByID(int id){
        bookDAO.deleteBookById(id);
    }

    public void updateBook(Book book){
        bookDAO.updateBook(book);
    }

    public List<Book> findAllBooks(){
        return bookDAO.findAllBooks();
    }

    public int howManyBooks(){
        return bookDAO.howManyBooks();
    }

    BookService bookService(){
        return this;
    }

}
