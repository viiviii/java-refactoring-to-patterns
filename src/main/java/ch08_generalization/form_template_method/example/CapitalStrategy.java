package ch08_generalization.form_template_method.example;

import ch08_generalization.form_template_method.example.etc.RiskFactor;

import java.util.Date;

public abstract class CapitalStrategy {
    private static final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;
    private static final long DAYS_PER_YEAR = 365;

    public abstract double capital(Loan loan);

    protected double riskFactorFor(Loan loan) {
        return RiskFactor.getFactors().forRating(loan.getRiskRating());
    }

    public double duration(Loan loan) {
        return yearsTo(loan.getExpiry(), loan);
    }

    protected double yearsTo(Date endDate, Loan loan) {
        Date beginDate = (loan.getToday() == null ? loan.getStart() : loan.getToday());
        return ((endDate.getTime() - beginDate.getTime()) / MILLIS_PER_DAY) / DAYS_PER_YEAR;
    }
}
