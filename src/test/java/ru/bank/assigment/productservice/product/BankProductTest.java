package ru.bank.assigment.productservice.product;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class BankProductTest {

    private static final Logger logger = LogManager.getLogger(BankProductTest.class);

    private BankProduct bankProduct;

    @Before
    public void setUp() {
        bankProduct = new BankProduct("Default product", "RU", BigDecimal.valueOf(0)) {
        };
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testTopUp() {
        logger.info( "testTopUp started" );
        bankProduct.topUp(BigDecimal.valueOf(1000));
        assertEquals("Balance should be 1000 after top up", BigDecimal.valueOf(1000), bankProduct.getBalance());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testGetBalance() {
        logger.info( "testGetBalance started" );
        assertEquals("Initial balance is not as expected.", BigDecimal.valueOf(0), bankProduct.getBalance());
    }

    @After
    public void message() {
        logger.info("Test finished\n");
    }
}
