package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Model.EducationDetails;

public interface EducationRepo extends JpaRepository<EducationDetails, Integer> {

}
