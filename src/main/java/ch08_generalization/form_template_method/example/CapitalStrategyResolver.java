package ch08_generalization.form_template_method.example;

import ch08_generalization.form_template_method.example.etc.UnusedRiskFactors;

public class CapitalStrategyResolver extends CapitalStrategy {

    @Override
    public double capital(Loan loan) {
        return (loan.outstandingRiskAmount() * duration(loan) * riskFactorFor(loan))
                + (loan.unusedRiskAmount() * duration(loan) * unusedRiskFactorFor(loan));
    }

    private double unusedRiskFactorFor(Loan loan) {
        return UnusedRiskFactors.getFactors().forRating(loan.getRiskRating());
    }
}