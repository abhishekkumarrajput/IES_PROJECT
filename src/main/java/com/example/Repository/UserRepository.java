package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	@Query("update UserEntity set status=:stats where userId=:userId")
	public Integer updateStatus(Integer userId,String status);

	public UserEntity findByEmail(String email);

	 public UserEntity findByEmailAndPassword(String email,String password);
	
	
}
