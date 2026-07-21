abstract class Device{

    String brand;
    String model;
    Boolean powerStatus; 

    public Device(String brand, String model){

        this.brand = brand;
        this.model = model;
        this.powerStatus = false;

    }

    public abstract void turnOn();
    public abstract void turnOff();

    public String checkPowerStatus() {

            if(powerStatus){

                return "on";
            }
            else{

                return "off";
            }

    }
}

class Television extends Device{

    private int screenSize;

    public Television(String brand, String model, int screenSize){

        super(brand, model);
        this.screenSize = screenSize;
    }

    public void turnOn(){

        if(!powerStatus){

            System.out.println(brand + " " + model + " is turning on");
            powerStatus = true;
        }
        else{

            System.out.println(brand + " " + model + " is already on");
        }
    }

    public void turnOff(){

        if(powerStatus){

            System.out.println(brand + " " + model + " is turning off");
            powerStatus = false;
        }
        else{

            System.out.println(brand + " " + model + " is already off");
        }
    }

    public void changeChannel(int channel){

        System.out.println(brand + " " + model + " changing channel to" + channel);

    }
}

class Computer extends Device{

    private String os;

    public Computer(String brand, String model, String os){

        super(brand, model);
        this.os = os;
    }

    public void turnOn(){

        if(!powerStatus){

            System.out.println(brand + " " + model + " is turning on");
            powerStatus = true;
        }
        else{

            System.out.println(brand + " " + model + " is already on");
        }
    }

    public void turnOff(){

        if(powerStatus){

            System.out.println(brand + " " + model + " is turning off");
            powerStatus = false;
        }
        else{

            System.out.println(brand + " " + model + " is already off");
        }
    }

    public void software(String app){

        System.out.println(brand + " " + model + " installing software " + app);

    }
}

class smartPhone extends Device{

    private String operatingSystem;

    public smartPhone(String brand, String model, String os){

        super(brand, model);
        this.operatingSystem = operatingSystem;
    }

    public void turnOn(){

        if(!powerStatus){

            System.out.println(brand + " " + model + " is turning on");
            powerStatus = true;
        }
        else{

            System.out.println(brand + " " + model + " is already on");
        }
    }

    public void turnOff(){

        if(powerStatus){

            System.out.println(brand + " " + model + " is turning off");
            powerStatus = false;
        }
        else{

            System.out.println(brand + " " + model + " is already off");
        }
    }

    public void makeCall(String phoneNumber) {
        System.out.println("Making a call to " + phoneNumber + " on " + brand + " " + model + ".");
    }
}

public class Main {

    public static void main(String[] args) {
        
        Device tv = new Television("Samsung", "QLED 75", 75);
        Device pc = new Computer("Apple", "MacBook Pro", "macOS");
        Device ph = new smartPhone("Apple", "iPhone 15", "iOS");

        System.out.println("\nTesting Television:");
        System.out.println("Power status: " + tv.checkPowerStatus());
        tv.turnOn();
        System.out.println("Power status: " + tv.checkPowerStatus());
        ((Television) tv).changeChannel(104); 
        tv.turnOff();
        System.out.println("Power status: " + tv.checkPowerStatus());

        System.out.println("\nTesting Computer:");
        System.out.println("Power status: " + pc.checkPowerStatus());
        pc.turnOn();
        System.out.println("Power status: " + pc.checkPowerStatus());
        ((Computer) pc).software("GTA VI"); 
        pc.turnOff();
        System.out.println("Power status: " + pc.checkPowerStatus());

        System.out.println("\nTesting Smartphone:");
        System.out.println("Power status: " + ph.checkPowerStatus());
        ph.turnOn();
        System.out.println("Power status: " + ph.checkPowerStatus());
        ((smartPhone) ph).makeCall("9096104433"); 
        ph.turnOff();
        System.out.println("Power status: " + ph.checkPowerStatus());
    }
    
}
