package ru.bank.assigment.productservice.product.card;

import java.math.BigDecimal;

import ru.bank.assigment.productservice.product.BankProduct;

public abstract class BankCard extends BankProduct implements BankCardOperations {

    public BankCard(String name, String currency, BigDecimal balance) {
        super(name, currency, balance);
    }

    public void debit(BigDecimal amount) throws IllegalArgumentException {
        if (getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("The amount cannot be less than the balance.");
        }
        balance = balance.subtract(amount);
    }
}
