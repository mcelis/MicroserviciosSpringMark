package com.ccti.cards.service.impl;

import com.ccti.cards.constants.CardsConstants;
import com.ccti.cards.dto.CardsDto;
import com.ccti.cards.entity.Cards;
import com.ccti.cards.exception.CardAlreadyExistsException;
import com.ccti.cards.exception.ResourceNotFoundException;
import com.ccti.cards.mapper.CardsMapper;
import com.ccti.cards.service.ICardsService;
import com.ccti.cards.repository.CardsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements ICardsService {

    private CardsRepository cardsRepository;


    @Override
    public void createCard(String email) {
        Optional<Cards> optionalCards= cardsRepository.findByEmail(email);
        if(optionalCards.isPresent()){
            throw new CardAlreadyExistsException("Card already registered with given email "+email);
        }
        cardsRepository.save(createNewCard(email));
    }

    private Cards createNewCard(String email) {
        Cards newCard = new Cards();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setEmail(email);
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        return newCard;
    }

    @Override
    public CardsDto fetchCard(String email) {
        Cards cards = cardsRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Card", "email", email)
        );
        return CardsMapper.mapToCardsDto(cards, new CardsDto());
    }

    @Override
    public boolean updateCard(CardsDto cardsDto) {
        Cards cards = cardsRepository.findByCardNumber(cardsDto.getCardNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Card", "CardNumber", cardsDto.getCardNumber()));
        CardsMapper.mapToCards(cardsDto, cards);
        cardsRepository.save(cards);
        return  true;
    }

    @Override
    public boolean deleteCard(String email) {
        Cards cards = cardsRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Card", "email", email)
        );
        cardsRepository.deleteById(cards.getCardId());
        return true;
    }


}
