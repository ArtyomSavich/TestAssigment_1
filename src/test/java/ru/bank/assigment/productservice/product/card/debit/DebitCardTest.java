package ru.bank.assigment.productservice.product.card.debit;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import ru.bank.assigment.productservice.product.card.BankCardTest;

public class DebitCardTest extends BankCardTest {

    private DebitCard debitCard;

    @Before
    public void setUp() {
        debitCard = new DebitCard("Default Name", "RU", BigDecimal.ZERO);
    }


    @Test
    public void  testDebitCard() throws IllegalArgumentException{
        debitCard.topUp(BigDecimal.valueOf(2500));
        debitCard.debit(BigDecimal.valueOf(1000));
        assertEquals("Debit card balance is not as expected.", BigDecimal.valueOf(1500), debitCard.getBalance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDebitIllegalArgument() throws IllegalArgumentException {
        debitCard.debit(BigDecimal.valueOf(2000));
    }
}
