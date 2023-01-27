package com.example.bookstore.service;

import com.example.bookstore.dao.CustomerDao;
import com.example.bookstore.ds.SecurityCustomer;
import com.example.bookstore.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*Optional<Customer> customerOptional = customerDao.findCustomerByUsername(username);
        if(customerOptional.isPresent()){
            return new SecurityCustomer(customerOptional.get())
        }*/

        return customerDao.findCustomerByUsername(username)
                .map(SecurityCustomer:: new)
                .orElseThrow(()-> new UsernameNotFoundException("Error!"));

    }
}
