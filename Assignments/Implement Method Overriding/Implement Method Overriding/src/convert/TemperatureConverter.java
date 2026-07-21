package convert;

public class TemperatureConverter extends Converter {

    public void convert() {
        double celsius = 25; 
        double fahrenheit = (celsius * 9/5) + 32; 
        System.out.println(celsius + "°C is equal to " + fahrenheit + "°F");
    }
}
