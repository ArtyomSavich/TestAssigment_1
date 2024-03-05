package ru.bank.assigment.productservice.product.card.credit;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import ru.bank.assigment.productservice.product.card.BankCardTest;

public class CreditCardTest extends BankCardTest {

    private static final Logger logger = LogManager.getLogger(CreditCardTest.class);

    private CreditCard creditCard;

    @Before
    public void setUp() {
        logger.info( "Before method started" );
        creditCard = new CreditCard("Default Name", "RU", BigDecimal.valueOf(-100), BigDecimal.ZERO);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testGetDebt() {
        logger.info( "testGetDebt started" );
        assertEquals("Credit card debt is not as expected.", BigDecimal.valueOf(-100), creditCard.getDebt());
    }

    @After
    public void message() {
        logger.info("Test finished");
    }
}
