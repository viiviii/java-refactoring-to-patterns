package ch08_generalization.form_template_method.example;

public class CapitalStrategyAdvisedLine extends CapitalStrategy {

    @Override
    public double capital(Loan loan) {
        return loan.getCommitment() * loan.getUnusedPercentage() *
                duration(loan) * riskFactorFor(loan);
    }
}
