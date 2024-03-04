package ru.bank.assigment.productservice.product;

import java.math.BigDecimal;

public abstract class BankProduct implements BankProductOperations {

    protected String name;
    protected String currency;
    protected BigDecimal balance;

    public BankProduct(String name, String currency, BigDecimal balance) {
        this.name = name;
        this.currency = currency;
        this.balance = balance;
    }

    public void topUp(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public BigDecimal getBalance() {
        return balance;
    }
}