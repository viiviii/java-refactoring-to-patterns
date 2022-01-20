package ch08_generalization.form_template_method.example.etc;

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
