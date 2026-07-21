import convert.CurrencyConverter;
import convert.TemperatureConverter;
import convert.UnitConverter;

public class Main {
    public static void main(String[] args) {
        
        CurrencyConverter currencyConverter = new CurrencyConverter();
        TemperatureConverter temperatureConverter = new TemperatureConverter();
        UnitConverter unitConverter = new UnitConverter();

        currencyConverter.convert(); 
        temperatureConverter.convert(); 
        unitConverter.convert();
        currencyConverter.ParentConvert(); 
    }
}
