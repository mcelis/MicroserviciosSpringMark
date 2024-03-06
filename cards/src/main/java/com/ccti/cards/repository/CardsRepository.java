package com.ccti.cards.repository;

import com.ccti.cards.entity.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Long> {

    Optional<Cards> findByEmail(String email);

    Optional<Cards> findByCardNumber(String cardNumber);

}
