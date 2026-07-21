class Employee{

    String name;
    int empid;
    double salary;

        public Employee(String name, int empid, double salary){
            this.name = name;
            this.empid = empid;
            this.salary = salary;
        }

        public void display(){
            System.out.println("Name: " + name);
            System.out.println("Employee ID: " + empid);
            System.out.println("Salary: " + salary);
        }
}

class Employee1 extends Employee{
    String dept;
    String desig;

    public Employee1(String name, int empid, double salary, String dept, String desig){
        super(name, empid, salary);
        this.dept = dept;
        this.desig = desig;
    }

    public void display(){
        super.display();
        System.out.println("Department: " + dept);
        System.out.println("Designation: " + desig);
    }

}

class Employee2 extends Employee1{
    String addr;
    String phno;

    public Employee2(String name, int empid, double salary, String dept, String desig, String addr, String phno){
        super(name, empid, salary, dept, desig);
        this.addr = addr;   
        this.phno = phno;
    }

    public void display(){
        super.display();
        System.out.println("Address: " + addr);
        System.out.println("Phone Number: " + phno);
    }

}



public class InherEmp {

    public static void main(String[] args){
        Employee2 e = new Employee2("Yash", 100, 50000.0, "IT", "Software Developer", "Kolhapur", "9096104433");
        e.display();
        
    }
}
