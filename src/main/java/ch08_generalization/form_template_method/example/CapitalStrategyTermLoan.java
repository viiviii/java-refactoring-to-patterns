package ch08_generalization.form_template_method.example;

import ch08_generalization.form_template_method.example.etc.Payment;

import java.util.Iterator;

public class CapitalStrategyTermLoan extends CapitalStrategy {
    @Override
    public double capital(Loan loan) {
        return loan.getCommitment() * duration(loan) * riskFactorFor(loan);
    }

    @Override
    public double duration(Loan loan) {
        return weightedAverageDuration(loan);
    }

    private double weightedAverageDuration(Loan loan) {
        double duration = 0.0;
        double weightedAverage = 0.0;
        double sumOfPayments = 0.0;
        Iterator loanPayments = loan.getPayments().iterator();
        while (loanPayments.hasNext()) {
            Payment payment = (Payment) loanPayments.next();
            sumOfPayments += payment.amount();
            weightedAverage += yearsTo(payment.date(), loan) * payment.amount();
        }
        if (loan.getCommitment() != 0.0) {
            duration = weightedAverage / sumOfPayments;
        }
        return duration;
    }
}
