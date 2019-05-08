import java.util.Arrays;
import java.util.HashSet;

public class SalesTax {
    public enum Tax {
        CA(0.0975, new HashSet<String>(Arrays.asList())),
        NY(0.08875, new HashSet<>());
        private double taxRate;
        private HashSet<String> exempt;
        private Tax(Double taxRate,HashSet<String> exempt) {
            this.taxRate = taxRate;
            this.exempt = exempt;
        }
        public double getTaxRate(){
            return taxRate;
        }
    }
}
