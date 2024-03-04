package ru.bank.assigment.productservice.product.card;

import java.math.BigDecimal;

import ru.bank.assigment.productservice.product.BankProductOperations;

public interface BankCardOperations extends BankProductOperations {

    void debit(BigDecimal amount);
}
