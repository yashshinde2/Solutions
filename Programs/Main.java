class Vehicle{

    String name;
    String color;
    int year;

    public Vehicle(String name , String color, int year){

        this.name = name;
        this.color = color;
        this.year = year;
    }

    public void displayInfo(){

        System.out.println("Vehicle name is: " + name + " color is: " + color + " year of manufacturing is: " + year);
    }

    public void start(){

        System.out.println("Vehicle started...");
    }
}

class Car extends Vehicle{

    int numberofDoors;

    public Car(String name, String color, int year, int numberofDoors){

        super(name, color, year);
        this.numberofDoors= numberofDoors;
    }

    public void displayInfo(){

        super.displayInfo();

        System.out.println("Car name : " + name + " color is : " + color + " year is : " + year + " number of doors : " + numberofDoors);

    }

    public void start(){

        super.start();

        System.out.println("Car is starting");
    }

    public void honk(){

        System.out.println("Honking...");
    }
}

class Main{

    public static void main(String[] args) {
        
        Vehicle v1 = new Vehicle("GenericVehicle", "Red", 2020);
        v1.displayInfo();
        v1.start();

        Car c1 = new Car("Honda Civic", "Blue", 2021, 4);
        c1.displayInfo(); 
        c1.start(); 
        c1.honk();
    }
}