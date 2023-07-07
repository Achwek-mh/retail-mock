package com.fsi.cbs.customer.dao;

import com.fsi.cbs.customer.repo.CustomerRepo;
import com.fsi.cbs.customer.repo.entity.Customers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author med-amine.Dahmen
 * Date 05/07/2023
 */

@Repository
@Slf4j
@RequiredArgsConstructor
public class CustomerDaoImpl implements CustomerDao {

    private final CustomerRepo customerRepo;

    @Override
    public void save(Customers customer) {
        log.info("save a customer");
        customerRepo.save(customer);

    }

    @Override
    public List<Customers> findAll() {
        return customerRepo.findAll();
    }






    @Override
    public Optional<Customers> selectCustomerById(Long id) {
        return customerRepo.findById(id);
    }



    @Override
    public boolean existsCustomerById(Long id) {
        return customerRepo.existsById(id);
    }




    @Override
    public void deleteCustomerById(Long id) {
        customerRepo.deleteById(id);

    }

    @Override
    public void updateCustomer(Customers newCustomer) {
        customerRepo.save(newCustomer);

    }



}
