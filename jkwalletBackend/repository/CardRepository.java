package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.CardDetails;

public interface CardRepository extends JpaRepository<CardDetails, Long> {

	Optional<CardDetails> findByCardNumber(Long cardNumber);
	
}
