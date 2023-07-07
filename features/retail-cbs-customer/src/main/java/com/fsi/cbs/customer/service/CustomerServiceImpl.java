package com.fsi.cbs.customer.service;

import com.fsi.cbs.customer.dao.CustomerDao;
import com.fsi.cbs.customer.exception.RequestException;
import com.fsi.cbs.customer.exception.ResourceNotFoundException;
import com.fsi.cbs.customer.repo.entity.Customers;
import com.fsi.common.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author med-amine.Dahmen
 * Date 05/07/2023
 */

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerrepo;
    private final ModelMapper customerDTOMapper;


    @Override
    public void save(CustomerDto customerDto) {
        customerrepo.save(customerDTOMapper.map(customerDto, Customers.class));
    }

    @Override
    public List<CustomerDto> findALl() {
        return customerrepo.findAll().stream().map(x -> customerDTOMapper.map(x, CustomerDto.class)).toList();
    }



    ;

/*    @Override
    public Optional<CustomerDto> getCustomer(Long customerID) {
        return Optional.ofNullable(customerrepo.selectCustomerById(customerID).map(country -> new CountryDto(country.getId())).orElseThrow(() -> new ResourceNotFoundException(
                "country with id [%s] not found".formatted(countryID)
        )));
    }*/



    @Override

    public void deleteCustomer (Long countryID) {
        checkIfCustomerExistsOrThrow(countryID);

        customerrepo.deleteCustomerById(countryID);
    }


    @Override
    public void checkIfCustomerExistsOrThrow(Long countryID) {
        if (!customerrepo.existsCustomerById(countryID)) {
            throw new ResourceNotFoundException("country with id [%s] not found".formatted(countryID));
        }
    }

    @Override
    public void updateCustomer(Long countryID, CustomerDto update) {
        Customers country = customerrepo.selectCustomerById(countryID).orElseThrow(() -> new ResourceNotFoundException("country with id [%s] not found".formatted(countryID)));
        boolean changes = false;
        if (update.name != null && !update.name.equals(country.getName())) {
            country.setName(update.name);
            changes = true;
        }
        if (update.code != null && !update.code.equals(country.getCode())) {
            country.setCode(update.code);
            changes = true;
        }
        if (!changes) {
            throw new RequestException("no data changes found");
        }
        customerrepo.updateCustomer(country);
    }
}
