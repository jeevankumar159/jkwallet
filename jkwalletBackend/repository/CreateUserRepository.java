package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.CreateUser;

public interface CreateUserRepository extends JpaRepository<CreateUser, Long> {
	 Optional<CreateUser> findByEmail(String email);
	 Optional<CreateUser> findByMobileNumber(String mobileNumber);
	 
}
