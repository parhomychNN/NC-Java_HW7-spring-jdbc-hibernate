package ru.parhomych.springjdbchibernate.dao;

import ru.parhomych.springjdbchibernate.model.Book;

import java.util.List;

public interface BookDAO {

    void saveBook(Book book);
    void updateBook(Book book);
    void deleteBook(Book book);
    List<Book> findAllBooks();
    Book findById(int id);
    void deleteBookById(int id);
    int howManyBooks();

}
