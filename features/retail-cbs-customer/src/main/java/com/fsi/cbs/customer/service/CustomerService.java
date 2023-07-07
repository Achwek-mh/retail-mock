package com.fsi.cbs.customer.service;

import com.fsi.common.dto.CustomerDto;

import java.util.List;

/**
 * @author med-amine.Dahmen
 * Date 05/07/2023
 */
public interface CustomerService {

    void save(CustomerDto customerDto);

    List<CustomerDto> findALl();


   // Optional<CustomerDto> getCustomer(Long customerID);

    void deleteCustomer(Long customerID);

    void checkIfCustomerExistsOrThrow(Long customerID);


    void updateCustomer(Long customerID, CustomerDto update);
}
