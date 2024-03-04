package ru.bank.assigment.productservice.product;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class BankProductTest {
    private BankProduct bankProduct;

    @Before
    public void setUp() {
        bankProduct = new BankProduct("Default product", "RU", BigDecimal.valueOf(0)) {
        };
    }

    @Test
    public void testTopUp() {
        bankProduct.topUp(BigDecimal.valueOf(1000));
        assertEquals("Balance should be 1000 after top up", BigDecimal.valueOf(1000), bankProduct.getBalance());
    }

    @Test
    public void testGetBalance() {
        assertEquals("Initial balance is not as expected.", BigDecimal.valueOf(0), bankProduct.getBalance());
    }
}
