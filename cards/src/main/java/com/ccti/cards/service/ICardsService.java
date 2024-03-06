package com.ccti.cards.service;

import com.ccti.cards.dto.CardsDto;

public interface ICardsService {

    void createCard(String email);

    CardsDto fetchCard(String email);

    boolean updateCard(CardsDto cardsDto);

    boolean deleteCard(String email);

}
