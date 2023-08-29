package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Model.PlansEntity;

public interface PlansRepository extends JpaRepository<PlansEntity, Integer> {

}
