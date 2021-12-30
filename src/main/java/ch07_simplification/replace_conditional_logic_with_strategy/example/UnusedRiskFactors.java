package ch07_simplification.replace_conditional_logic_with_strategy.example;

public class UnusedRiskFactors {
    private static final UnusedRiskFactors factors = new UnusedRiskFactors();

    private UnusedRiskFactors() {
    }

    public static UnusedRiskFactors getFactors() {
        return factors;
    }

    public double forRating(int riskRating) {
        return riskRating;
    }
}
