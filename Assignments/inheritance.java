class Animal {
    String breed;
    String voice;
    int age;

   
    public Animal(String breed, String voice, int age) {
        this.breed = breed;
        this.voice = voice;
        this.age = age;
    }

    
    public void displaypinfo() {
        System.out.println("Breed: " + breed);
        System.out.println("Voice: " + voice);
        System.out.println("Age: " + age);
    }
}

class Lab extends Animal {
    String size;
    String ears;

    
    public Lab(String breed, String voice, int age, String size, String ears) {
        super(breed, voice, age); 
        this.size = size;
        this.ears = ears;
    }

    
    public void displaypinfo() {
        
        System.out.println("Breed: " + breed);  
        System.out.println("Voice: " + voice);  
        System.out.println("Age: " + age);      
        System.out.println("Size of Body: " + size);  
        System.out.println("Length of ears: " + ears); 
    }
}

class Inheritance {
    public static void main(String[] args) {
        //
        Lab l = new Lab("Labrador", "wohwoh", 10, "bulky", "medium");
        l.displaypinfo();  
    }
}
