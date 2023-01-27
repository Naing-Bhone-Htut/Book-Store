package com.example.bookstore.dao;

import com.example.bookstore.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleDao extends JpaRepository<Role,Integer> {

    Optional<Role> findRoleByRoleName(String roleName);
}
