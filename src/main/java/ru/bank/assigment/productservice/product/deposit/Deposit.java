package ru.bank.assigment.productservice.product.deposit;

import java.math.BigDecimal;

import ru.bank.assigment.productservice.product.BankProduct;

public class Deposit extends BankProduct implements DepositOperations {

    public Deposit(String name, String currency, BigDecimal balance) {
        super(name, currency, balance);
    }

    public void close() {
        if (getBalance().equals(BigDecimal.ZERO)) {
            System.out.println("Deposit is already closed.");
        }
        //TODO: необходимо продумать логику закрытия депозита: возврат средств процентов и т.д.
        balance = BigDecimal.ZERO;
        System.out.println("Deposit closed");
    }
}
