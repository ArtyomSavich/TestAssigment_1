package ru.bank.assigment.productservice.product.card.debit;

import java.math.BigDecimal;

import ru.bank.assigment.productservice.product.card.BankCard;

public class DebitCard extends BankCard implements DebitCardOperations{

    public DebitCard(String name, String currency, BigDecimal balance) {
        super(name, currency, balance);
    }
}
