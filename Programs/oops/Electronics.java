interface Chargeable {

    void charge();

    int getChargePercentage();

    default void displayChargeStatus() {
        System.out.println("Charge Percentage: " + getChargePercentage() + "%");
    }
}

interface Connectable {

    void connect(String deviceName);

    void disconnect();
}

class Smartphone implements Chargeable, Connectable {

    private String deviceName;
    private int chargePercentage;

    public Smartphone(String deviceName) {
        this.deviceName = deviceName;
        this.chargePercentage = 20;
    }

    @Override
    public void charge() {
        chargePercentage += 20;
        if (chargePercentage > 100) {
            chargePercentage = 100;
        }
        System.out.println(deviceName + " is charging...");
    }

    @Override
    public int getChargePercentage() {
        return chargePercentage;
    }

    @Override
    public void connect(String deviceName) {
        System.out.println("Connected to " + deviceName);
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnected from device");
    }
}

class Laptop implements Chargeable, Connectable {

    private String deviceName;
    private int chargePercentage;

    public Laptop(String deviceName) {
        this.deviceName = deviceName;
        this.chargePercentage = 50;
    }

    @Override
    public void charge() {
        chargePercentage += 15;
        if (chargePercentage > 100) {
            chargePercentage = 100;
        }
        System.out.println(deviceName + " is charging...");
    }

    @Override
    public int getChargePercentage() {
        return chargePercentage;
    }

    @Override
    public void connect(String deviceName) {
        System.out.println("Connected to " + deviceName);
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnected from device");
    }
}

class Electronics {

    public static void main(String[] args) {

        Smartphone phone = new Smartphone("iPhone");
        phone.charge();
        phone.displayChargeStatus();
        phone.connect("WiFi");
        phone.disconnect();

        System.out.println();

        Laptop laptop = new Laptop("Dell");
        laptop.charge();
        laptop.displayChargeStatus();
        laptop.connect("Ethernet");
        laptop.disconnect();

        System.out.println();

        Chargeable[] devices = {phone, laptop};

        for (Chargeable device : devices) {
            device.charge();
            device.displayChargeStatus();
        }
    }
}