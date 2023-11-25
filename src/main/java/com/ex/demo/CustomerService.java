package com.ex.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;


    public List<Customer>findCustomers(){
        return customerRepository.findAll();
    }

    public void save(Customer customer){
        customerRepository.save(customer);
    }
}
