package ru.parhomych.springjdbchibernate.dao;

import ru.parhomych.springjdbchibernate.model.Book;
import ru.parhomych.springjdbchibernate.model.Customer;

import java.util.List;

public interface CustomerDAO {
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    List<Customer> findAllCustomers();
    Customer findCustomerById(int id);
    void deleteCustomerById(int id);
    int howManyCustomers();
}
