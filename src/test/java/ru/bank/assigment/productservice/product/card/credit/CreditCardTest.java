package ru.bank.assigment.productservice.product.card.credit;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import ru.bank.assigment.productservice.product.card.BankCardTest;

public class CreditCardTest extends BankCardTest {
    private CreditCard creditCard;

    @Before
    public void setUp() {
        creditCard = new CreditCard("Default Name", "RU", BigDecimal.valueOf(-100), BigDecimal.ZERO);
    }

    @Test
    public void testGetDebt() {
        assertEquals("Credit card debt is not as expected.", BigDecimal.valueOf(-100), creditCard.getDebt());
    }
}
