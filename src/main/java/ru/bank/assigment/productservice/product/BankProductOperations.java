package ru.bank.assigment.productservice.product;

import java.math.BigDecimal;

public interface BankProductOperations {

    void topUp(BigDecimal amount);

    BigDecimal getBalance();
}
