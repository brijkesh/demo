package com.example.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.UserEntity;

@Repository
public interface UserRepository<User> extends JpaRepository<UserEntity, Integer> {

//	Optional<UserEntity> finduById(int id);

	////UserEntity findUIdByUId(Integer uId);
	
	
	@Query(value = "select * from user_entity order by lower(user_name )",nativeQuery = true)
	List<UserEntity> getEmpAscOrder();
	
	@Query(value = "select * from user_entity order by lower(user_name) DESC",nativeQuery = true)
	List<UserEntity> getEmpDscOrder();
	
	
	
}
