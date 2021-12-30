package ch07_simplification.replace_conditional_logic_with_strategy.example;

public class RiskFactor {
    private static final RiskFactor factors = new RiskFactor();

    private RiskFactor() {
    }

    public static RiskFactor getFactors() {
        return factors;
    }

    public double forRating(int riskRating) {
        return riskRating;
    }
}
