package com.lms.repository;

import java.util.List;

import com.lms.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	public List<Users> findAllByOrderByDisplayNameAsc();
	public List<Users> findAllByActiveOrderByDisplayNameAsc(Integer active);
	public Users findByUsername(String username);
}
