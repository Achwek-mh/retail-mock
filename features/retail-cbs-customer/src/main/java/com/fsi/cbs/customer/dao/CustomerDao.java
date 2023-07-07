package com.fsi.cbs.customer.dao;

import com.fsi.cbs.customer.repo.entity.Customers;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {

    void save(Customers customer);


    List<Customers> findAll();
    public Optional<Customers> selectCustomerById(Long customerId);

    public boolean existsCustomerById(Long customerId);
    public void deleteCustomerById(Long customerId);
    public void updateCustomer(Customers newCustomer);

}
