package convert;

public class CurrencyConverter extends Converter {

    public void convert() {
        double usd = 100; 
        double conversionRate = 83.00; 
        double inr = usd * conversionRate; 
        System.out.println(usd + " USD is equal to " + inr + " INR");
    }

   
}
