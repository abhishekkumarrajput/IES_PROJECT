package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Model.EligibilityDetails;

public interface EligibilityRepository extends JpaRepository<EligibilityDetails, Integer> {

}
