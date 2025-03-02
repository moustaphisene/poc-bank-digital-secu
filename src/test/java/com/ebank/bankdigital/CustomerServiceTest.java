package com.ebank.bankdigital;

import com.ebank.bankdigital.entity.Customer;
import com.ebank.bankdigital.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testCreateCustomer() {
        // Utiliser le constructeur avec arguments
        Customer john = new Customer("John Doe", "john.doe@example.com", "1234567890");
        customerRepository.save(john);

        assertThat(john.getId()).isNotNull();
        assertThat(john.getName()).isEqualTo("John Doe");
        assertThat(john.getEmail()).isEqualTo("john.doe@example.com");
        assertThat(john.getPhoneNumber()).isEqualTo("1234567890");
    }

    @Test
    public void testFindCustomer() {
        // Utiliser le constructeur avec arguments
        Customer jane = new Customer("Jane Smith", "jane.smith@example.com", "0987654321");
        customerRepository.save(jane);

        Customer foundCustomer = customerRepository.findById(jane.getId()).orElse(null);
        assertThat(foundCustomer).isNotNull();
        assertThat(foundCustomer.getName()).isEqualTo("Jane Smith");
        assertThat(foundCustomer.getEmail()).isEqualTo("jane.smith@example.com");
        assertThat(foundCustomer.getPhoneNumber()).isEqualTo("0987654321");
    }
}
