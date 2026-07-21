interface Assemblable {
    void assemble();
    void disassemble();
    void listParts();

    default String getInstructions() {
        return "Follow the steps in the user manual.";
    }
}

class Furniture implements Assemblable {
  
    public void assemble() {
        System.out.println("Assembling Furniture: Connecting legs and attaching screws.");
    }
  
    public void disassemble() {
        System.out.println("Disassembling Furniture: Unscrewing parts and separating legs.");
    }

    public void listParts() {
        System.out.println("Furniture Parts: Legs, Screws, Wooden Boards, Nuts.");
    }
}

class Toy implements Assemblable {
  
    public void assemble() {
        System.out.println("Assembling Toy: Snapping parts together.");
    }

    public void disassemble() {
        System.out.println("Disassembling Toy: Pulling parts apart.");
    }

    public void listParts() {
        System.out.println("Toy Parts: Body, Head, Arms, Legs, Stickers.");
    }
}

class ElectronicDevice implements Assemblable {
 
    public void assemble() {
        System.out.println("Assembling Electronic Device: Installing circuit board and casing.");
    }

    public void disassemble() {
        System.out.println("Disassembling Electronic Device: Removing screws and opening casing.");
    }

    public void listParts() {
        System.out.println("Electronic Device Parts: Circuit Board, Battery, Screen, Casing, Screws.");
    }
}

public class assembly {
    public static void main(String[] args) {
        Assemblable furniture = new Furniture();
        Assemblable toy = new Toy();
        Assemblable device = new ElectronicDevice();

        System.out.println("Furniture");
        furniture.listParts();
        System.out.println(furniture.getInstructions());
        furniture.assemble();
        furniture.disassemble();

        System.out.println("\nToy");
        toy.listParts();
        System.out.println(toy.getInstructions());
        toy.assemble();
        toy.disassemble();

        System.out.println("\nElectronic Device");
        device.listParts();
        System.out.println(device.getInstructions());
        device.assemble();
        device.disassemble();
    }
}
