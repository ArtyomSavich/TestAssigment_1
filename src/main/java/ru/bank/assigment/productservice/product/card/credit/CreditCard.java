package ru.bank.assigment.productservice.product.card.credit;

import java.math.BigDecimal;

import ru.bank.assigment.productservice.product.BankProductOperations;
import ru.bank.assigment.productservice.product.card.BankCard;

public class CreditCard extends BankCard implements CreditCardOperations {

    private BigDecimal percentageRate;

    public CreditCard(String name, String currency, BigDecimal balance, BigDecimal percentageRate) {
        super(name, currency, balance);
        this.percentageRate = percentageRate;
    }

    public BigDecimal getDebt() {
        if (getBalance().compareTo(BigDecimal.ZERO) < 0) {
            return balance;
        } else {
            return BigDecimal.ZERO;
        }
    }
}
