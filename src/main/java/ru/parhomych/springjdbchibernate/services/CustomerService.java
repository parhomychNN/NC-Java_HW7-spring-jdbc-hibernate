package ru.parhomych.springjdbchibernate.services;

import lombok.NoArgsConstructor;
import ru.parhomych.springjdbchibernate.dao.CustomerDAO;
import ru.parhomych.springjdbchibernate.dao.CustomerDAOImpl;
import ru.parhomych.springjdbchibernate.model.Book;
import ru.parhomych.springjdbchibernate.model.Customer;

import java.util.List;

@NoArgsConstructor
public class CustomerService {

    CustomerDAOImpl customerDAO = new CustomerDAOImpl();

    public Customer findCustomer(int id){
        return customerDAO.findCustomerById(id);
    }

    public void addCustomer(Customer customer){
        customerDAO.saveCustomer(customer);
    }

    public void deleteCustomer(Customer customer){
        customerDAO.deleteCustomer(customer);
    }

    public void deleteCustomerByID(int id){
        customerDAO.deleteCustomerById(id);
    }

    public void updateCustomer(Customer customer){
        customerDAO.updateCustomer(customer);
    }

    public List<Customer> findAllCustomers(){
        return customerDAO.findAllCustomers();
    }

    public int howManyCustomers(){
        return customerDAO.howManyCustomers();
    }

}
