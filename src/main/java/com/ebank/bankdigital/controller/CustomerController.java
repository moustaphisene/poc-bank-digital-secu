package com.ebank.bankdigital.controller;

import com.ebank.bankdigital.dto.CustomerDTO;
import com.ebank.bankdigital.entity.Customer;
import com.ebank.bankdigital.mapper.CustomerMapper;
import com.ebank.bankdigital.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    // Constructeur avec injection de dépendance
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers().stream()
                .map(CustomerMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public CustomerDTO getCustomer(@PathVariable Long id) {
        Assert.notNull(id, "Customer ID must not be null");
        return CustomerMapper.INSTANCE.toDTO(customerService.getCustomerById(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        Assert.notNull(id, "Customer ID must not be null");
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        Assert.notNull(customerDTO, "CustomerDTO must not be null");
        Customer customer = CustomerMapper.INSTANCE.toEntity(customerDTO);
        Customer createdCustomer = customerService.createCustomer(customer);
        return CustomerMapper.INSTANCE.toDTO(createdCustomer);
    }


    @PutMapping("/{id}")
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        Assert.notNull(id, "Customer ID must not be null");
        Assert.notNull(customerDTO, "CustomerDTO must not be null");
        Customer customer = CustomerMapper.INSTANCE.toEntity(customerDTO);
        Customer updatedCustomer = customerService.updateCustomer(id, customer);
        return CustomerMapper.INSTANCE.toDTO(updatedCustomer);
    }
}
