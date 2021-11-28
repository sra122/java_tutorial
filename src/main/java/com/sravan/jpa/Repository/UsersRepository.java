package com.sravan.jpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sravan.jpa.Entity.User;

public interface UsersRepository extends JpaRepository<User, Integer> {
	
	@Query(value = "select * from users where email = (:email) limit 1",  nativeQuery = true)
	public User findByEmail(@Param("email") String email);

}
