package ru.bank.assigment.productservice.product.card.credit;

import java.math.BigDecimal;

import ru.bank.assigment.productservice.product.card.BankCardOperations;

public interface CreditCardOperations extends BankCardOperations {

    BigDecimal getDebt();
}
