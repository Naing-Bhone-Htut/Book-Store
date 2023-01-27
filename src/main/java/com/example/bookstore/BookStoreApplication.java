package com.example.bookstore;

import com.example.bookstore.dao.CustomerDao;
import com.example.bookstore.dao.RoleDao;
import com.example.bookstore.entity.Address;
import com.example.bookstore.entity.Customer;
import com.example.bookstore.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class BookStoreApplication {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private RoleDao roleDao;

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Bean
    @Transactional
    @Profile("dev")
    public ApplicationRunner runner(){
        return  r->{
            Role customerRole = new Role();
            customerRole.setRoleName("ROLE_USER");
            Role adminRole = new Role();
            adminRole.setRoleName("ROLE_ADMIN");

            Customer customer=new Customer();
            customer.setUsername("john");
            customer.setPassword(passwordEncoder.encode("12345"));
            customer.addRole(adminRole);

            Address address=new Address();

            address.setCountry("Myanmar");
            address.setPhoneNumber("455-454-232");
            address.setStreetName("15 Street");

            customer.setAddress(address);

//            roleDao.save(customerRole);
//            roleDao.save(adminRole);
//            customerDao.save(customer);

        };
    }

}
