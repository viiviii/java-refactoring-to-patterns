package ch08_generalization.form_template_method.example.etc;

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
