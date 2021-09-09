package lt.mif.vu.domain;

public class ValidationRule {
    public String prefix;
    public int length;

    public ValidationRule(String prefix, int length) {
        this.prefix = prefix;
        this.length = length;
    }
}
