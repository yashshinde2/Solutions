interface ComputerComponent {
    void install();
    void test();

    default String getSpecifications() {
        return "Generic Component Specifications";
    }
}

class CPU implements ComputerComponent {
    private String model;
    private double clockSpeedGHz;

    public CPU(String model, double clockSpeedGHz) {
        this.model = model;
        this.clockSpeedGHz = clockSpeedGHz;
    }

    public void install() {
        System.out.println("Installing CPU: " + model);
    }

    public void test() {
        System.out.println("Testing CPU at " + clockSpeedGHz + " GHz");
    }

    public double getClockSpeed() {
        return clockSpeedGHz;
    }

    public String getSpecifications() {
        return "CPU Model: " + model + ", Clock Speed: " + clockSpeedGHz + " GHz";
    }
}

class RAM implements ComputerComponent {
    private int sizeGB;

    public RAM(int sizeGB) {
        this.sizeGB = sizeGB;
    }

    public void install() {
        System.out.println("Installing RAM: " + sizeGB + "GB");
    }

    public void test() {
        System.out.println("Testing RAM: " + sizeGB + "GB working fine");
    }

    public int getMemorySize() {
        return sizeGB;
    }

    public String getSpecifications() {
        return "RAM Size: " + sizeGB + " GB";
    }
}

class GPU implements ComputerComponent {
    private String brand;
    private int vramGB;

    public GPU(String brand, int vramGB) {
        this.brand = brand;
        this.vramGB = vramGB;
    }

    public void install() {
        System.out.println("Installing GPU: " + brand + " with " + vramGB + "GB VRAM");
    }

    public void test() {
        System.out.println("Testing GPU: " + brand + " rendering graphics smoothly");
    }

    public int getVRAM() {
        return vramGB;
    }

    public String getSpecifications() {
        return "GPU Brand: " + brand + ", VRAM: " + vramGB + " GB";
    }
}

public class ComputerBuilder {
    public static void main(String[] args) {
 
        CPU cpu = new CPU("Intel i7", 3.8);
        RAM ram = new RAM(16);
        GPU gpu = new GPU("NVIDIA RTX 3060", 12);

        System.out.println("----- Building Computer -----");

        cpu.install();
        cpu.test();
        System.out.println(cpu.getSpecifications());

        ram.install();
        ram.test();
        System.out.println(ram.getSpecifications());

        gpu.install();
        gpu.test();
        System.out.println(gpu.getSpecifications());

        System.out.println("----- Computer Build Complete -----");
    }
}
