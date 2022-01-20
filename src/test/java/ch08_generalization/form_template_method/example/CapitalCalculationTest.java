package ch08_generalization.form_template_method.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class CapitalCalculationTest {
    private static final int HIGH_RISK_RATING = 1;
    private static final double LOAN_AMOUNT = 105.00;
    private static final double TWO_DIGIT_PRECISION = 0.01;

    @Test
    void testTermLoanSamePayments() {
        //given
        Date start = november(20, 2003);
        Date maturity = november(20, 2006);
        Loan termLoan = Loan.newTermLoan(LOAN_AMOUNT, start, maturity, HIGH_RISK_RATING);

        //when
        termLoan.payment(1000.00, november(20, 2004));
        termLoan.payment(1000.00, november(20, 2005));
        termLoan.payment(1000.00, november(20, 2006));

        //then
        assertEquals("duration", 2.0, termLoan.duration(), TWO_DIGIT_PRECISION);
        assertEquals("capital", 210.0, termLoan.capital(), TWO_DIGIT_PRECISION);
    }

    private Date november(int day, int year) {
        GregorianCalendar calendar = new GregorianCalendar(year, Calendar.NOVEMBER, day);
        return calendar.getTime();
    }

    private void assertEquals(String message, double expected, double actual, double delta) {
        Assertions.assertEquals(expected, actual, delta, message);
    }
}