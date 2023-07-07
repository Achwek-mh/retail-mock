package com.fsi.cbs.customer.api;

import com.fsi.cbs.customer.service.CustomerService;
import com.fsi.common.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author med-amine.Dahmen
 * Date 05/07/2023
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public HttpEntity<List<CustomerDto>> listCustomerss() {
        return new HttpEntity<>(customerService.findALl());
    }
  /*  @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable("id") Long id){
        Optional<CustomerDto> customers = customerService.getCustomer(id);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }*/

    @PostMapping
    public ResponseEntity<Object> addCustomer(@RequestBody CustomerDto customer){
        customerService.save(customer);
        return new ResponseEntity<>("customer added successfully", HttpStatus.CREATED);

    }
    @PutMapping("{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerDto updatedCustomer) {


        customerService.updateCustomer(id,updatedCustomer);
        return new ResponseEntity<>("customer has been updated successfully", HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id")Long id ) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>( "customer is deleted successfully",HttpStatus.NO_CONTENT);

    }

    @GetMapping("/will-fail")
    public HttpEntity<List<CustomerDto>> willNeverWork() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/will-succeed")
    public HttpEntity<List<CustomerDto>> willAlwaysWork() {
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/will-throw-an-exception")
    @SneakyThrows
    public HttpEntity<List<CustomerDto>> willThrowException() {

        throw new Exception("An Exception");
    }


}
