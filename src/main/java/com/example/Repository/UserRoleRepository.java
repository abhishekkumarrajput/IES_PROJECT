package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

}
