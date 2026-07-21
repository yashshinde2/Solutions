class Person {
    String name;
    String address;
    int age;

    
    public Person(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    
    public void displaypinfo() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Age: " + age);
    }
}

class Student extends Person {
    int roll_no;
    double fees;

    
    public Student(String name, String address, int age, int roll_no, double fees) {
        
        super(name, address, age);
        this.roll_no = roll_no;
        this.fees = fees;
    }

    
    public void displaypinfo() {
        
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Age: " + age);
        
       
        System.out.println("Roll Number of Student: " + roll_no);
        System.out.println("Fees of Education: " + fees);
    }
}

public class inher {
    public static void main(String[] args) {
        
        Student s = new Student("Yash", "Kolhapur", 20, 100, 72000.0);
        s.displaypinfo();  
    }
}
