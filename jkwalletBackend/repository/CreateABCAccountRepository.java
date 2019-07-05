package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.ABCBank;

public interface CreateABCAccountRepository extends JpaRepository<ABCBank, Long>{
		 Optional<ABCBank> findByMobileNumber(String mobileNumber) ;
		 Optional<ABCBank> findByAccountNumber(Long accountNumber);
}
