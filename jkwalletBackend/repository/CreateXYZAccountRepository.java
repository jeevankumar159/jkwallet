package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import model.XYZBank;

public interface CreateXYZAccountRepository extends JpaRepository<XYZBank, Long> {
	Optional<XYZBank> findByMobileNumber(String mobileNumber) ;
	Optional<XYZBank> findByAccountNumber(Long accountNumber);
}
