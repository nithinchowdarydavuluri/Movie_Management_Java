package org.example.service;

import org.example.Model.Customer;
import org.example.repository.CustomerRepositoryImpl;

import java.util.List;

public class CustomerService {
    public  static  CustomerRepositoryImpl cr;
    public CustomerService(CustomerRepositoryImpl cr){
        this.cr = cr;

    }
    public List<Customer> getcustomers(){

        return cr.findAll();
    }
}
