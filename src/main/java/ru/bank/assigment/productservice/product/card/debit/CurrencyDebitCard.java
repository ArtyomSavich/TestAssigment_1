package ru.bank.assigment.productservice.product.card.debit;

import java.math.BigDecimal;

public class CurrencyDebitCard extends DebitCard {

    public CurrencyDebitCard(String name, String currency, BigDecimal balance) {
        super(name, currency, balance);
    }

}
