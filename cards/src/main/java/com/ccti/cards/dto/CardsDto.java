package com.ccti.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class CardsDto {

    @Email(message = "A valid email address must be entered")
    @NotEmpty(message = "Email address can not be a null or empty")
    private String email;

    @NotEmpty(message = "Card Number can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{12})",message = "CardNumber must be 12 digits")
    private String cardNumber;

    @NotEmpty(message = "CardType can not be a null or empty")
    private String cardType;

    @Positive(message = "Total card limit should be greater than zero")
    private int totalLimit;

    @PositiveOrZero(message = "Total amount used should be equal or greater than zero")
    private int amountUsed;

    @PositiveOrZero(message = "Total available amount should be equal or greater than zero")
    private int availableAmount;

}
