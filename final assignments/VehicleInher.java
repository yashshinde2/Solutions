class Vehicle {
    String manufacturer;
    int yearOfProduction;

        public Vehicle(String manufacturer, int yearOfProduction) {
            this.manufacturer = manufacturer;
            this.yearOfProduction = yearOfProduction;
    }

        public void display() {
            System.out.println("Manufacturer: " + manufacturer);
            System.out.println("Year of Production: " + yearOfProduction);
    }
} 

class Boat extends Vehicle {
    String hullType;
    double length;

   
    public Boat(String manufacturer, int yearOfProduction, String hullType, double length) {
        
        super(manufacturer, yearOfProduction);
      
        this.hullType = hullType;
        this.length = length;
    }

        public void display() {
            super.display();
                System.out.println("Hull Type: " + hullType);
                System.out.println("Length: " + length);
        }

}

public class VehicleInher {
        public static void main(String[] args) {
       
            Boat boat = new Boat("Titanic", 1997, "mono-hull", 30.0);
            System.out.println("Boat Information:");
            boat.display();
        
        }

}
