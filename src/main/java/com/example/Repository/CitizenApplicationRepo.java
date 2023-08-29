package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Model.CitizenApplication;

public interface CitizenApplicationRepo extends JpaRepository<CitizenApplication,Integer> {

}
