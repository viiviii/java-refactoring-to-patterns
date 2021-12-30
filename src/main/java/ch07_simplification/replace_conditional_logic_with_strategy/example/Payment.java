package ch07_simplification.replace_conditional_logic_with_strategy.example;

import java.util.Date;
import java.util.Objects;

public class Payment {
    private final double amount;
    private final Date date;

    public Payment(double amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    public double amount() {
        return amount;
    }

    public Date date() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return Double.compare(payment.amount, amount) == 0 && date.equals(payment.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, date);
    }

    @Override
    public String toString() {
        return "Payment{" + "amount=" + amount + ", date=" + date + '}';
    }
}
