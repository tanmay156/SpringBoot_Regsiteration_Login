package in.ap.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ap.main.entity.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	User findByEmail(String email);
	
}
