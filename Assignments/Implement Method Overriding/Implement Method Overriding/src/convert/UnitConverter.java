package convert;

public class UnitConverter extends Converter {
    
    public void convert() {
        double meters = 5000; 
        double kilometers = meters / 1000; 
        System.out.println(meters + " meters is equal to " + kilometers + " kilometers");
    }
}
