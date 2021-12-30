package ch06_creation.replace_constructors_with_creation_methods.example;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CapitalCalculationTest {

    @Test
    void testTermLoanNoPayments() {
        //given
        double commitment = 10000;
        int riskRating = 1;
        Date maturity = new Date();

        //when
        Loan loan = new Loan(commitment, riskRating, maturity);

        //then
        assertEquals(CapitalStrategyTermLoan.class, loan.capitalStrategy.getClass());
    }

    @Test
    void testTermLoanOnePayment() {
        //given
        double commitment = 10000;
        int riskRating = 1;
        Date maturity = new Date();

        //when
        Loan loan = new Loan(commitment, riskRating, maturity);

        //then
        assertEquals(CapitalStrategyTermLoan.class, loan.capitalStrategy.getClass());
    }

    @Test
    void testTermLoanWithRiskAdjustedCapitalStrategy() {
        // given
        CapitalStrategy riskAdjustedCapitalStrategy = new CapitalStrategyTermLoan();
        double commitment = 10000;
        double outstanding = 3;
        int riskRating = 1;
        Date maturity = new Date();

        // when
        Loan loan = new Loan(riskAdjustedCapitalStrategy, commitment, outstanding, riskRating, maturity, null);

        //then
        assertEquals(CapitalStrategyTermLoan.class, loan.capitalStrategy.getClass());
    }

    @Test
    void testResolver() {
        //given
        double commitment = 10000;
        double outstanding = 3;
        int riskRating = 1;
        Date expiry = new Date();

        //when
        Loan loan = new Loan(commitment, outstanding, riskRating, null, expiry);

        //then
        assertEquals(CapitalStrategyResolver.class, loan.capitalStrategy.getClass());
    }

    @Test
    void testResolverWithStrategy() {
        //given
        CapitalStrategy strategy = new CapitalStrategyResolver();
        double commitment = 10000;
        double outstanding = 3;
        int riskRating = 1;
        Date expiry = new Date();

        //when
        Loan loan = new Loan(strategy, commitment, outstanding, riskRating, null, expiry);

        //then
        assertEquals(CapitalStrategyResolver.class, loan.capitalStrategy.getClass());
    }

    @Test
    void testRCTL() {
        //given
        double commitment = 10000;
        double outstanding = 3;
        int riskRating = 1;
        Date maturity = new Date();
        Date expiry = new Date();

        //when
        Loan loan = new Loan(commitment, outstanding, riskRating, maturity, expiry);

        //then
        assertEquals(CapitalStrategyRCTL.class, loan.capitalStrategy.getClass());
    }

    @Test
    void testRCTLWithStrategy() {
        //given
        CapitalStrategy strategy = new CapitalStrategyRCTL();
        double commitment = 10000;
        double outstanding = 3;
        int riskRating = 1;
        Date maturity = new Date();
        Date expiry = new Date();

        //when
        Loan loan = new Loan(strategy, commitment, outstanding, riskRating, maturity, expiry);

        //then
        assertEquals(CapitalStrategyRCTL.class, loan.capitalStrategy.getClass());
    }
}