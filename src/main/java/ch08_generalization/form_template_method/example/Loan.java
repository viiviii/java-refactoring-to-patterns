package ch08_generalization.form_template_method.example;

import ch08_generalization.form_template_method.example.etc.Payment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Loan {
    private double commitment;
    private double outstanding;
    private double unusedPercentage;
    private Date start;
    private Date today;
    private Date maturity;
    private Date expiry;
    private int riskRating;
    private List<Payment> payments = new ArrayList<>();
    private CapitalStrategy capitalStrategy;

    private Loan(double commitment, double outstanding, Date start, Date expiry, Date maturity, int riskRating, CapitalStrategy capitalStrategy) {
        this.commitment = commitment;
        this.outstanding = outstanding;
        this.start = start;
        this.expiry = expiry;
        this.maturity = maturity;
        this.riskRating = riskRating;
        this.capitalStrategy = capitalStrategy;
    }

    public static Loan newTermLoan(double commitment, Date start, Date maturity, int riskRating) {
        return new Loan(commitment, commitment, start, null, maturity, riskRating, new CapitalStrategyTermLoan());
    }

    public static Loan newResolver(double commitment, Date start, Date expiry, int riskRating) {
        return new Loan(commitment, 0, start, expiry, null, riskRating, new CapitalStrategyResolver());
    }

    public static Loan newAdvisedLine(double commitment, Date start, Date expiry, int riskRating) {
        if (riskRating > 3) return null;
        Loan advisedLine = new Loan(commitment, 0, start, expiry, null, riskRating, new CapitalStrategyAdvisedLine());
        advisedLine.setUnusedPercentage(0.1);
        return advisedLine;
    }

    public void payment(double amount, Date date) {
        Payment payment = new Payment(amount, date);
        payments.add(payment);
    }

    public double capital() {
        return capitalStrategy.capital(this);
    }

    public double duration() {
        return capitalStrategy.duration(this);
    }

    double outstandingRiskAmount() {
        return outstanding;
    }

    double unusedRiskAmount() {
        return (commitment - outstanding);
    }

    double getUnusedPercentage() {
        return unusedPercentage;
    }

    private void setUnusedPercentage(double unusedPercentage) {
        this.unusedPercentage = unusedPercentage;
    }

    double getCommitment() {
        return commitment;
    }

    Date getStart() {
        return start;
    }

    Date getToday() {
        return today;
    }

    Date getExpiry() {
        return expiry;
    }

    int getRiskRating() {
        return riskRating;
    }

    List<Payment> getPayments() {
        return payments;
    }
}
