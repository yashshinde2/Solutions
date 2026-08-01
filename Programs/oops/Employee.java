class Employee{

    private String name;
    private int age;
    private float salary;

    public Employee(String name){

        this(name,0);
    }

    public Employee(String name, int age){

        this(name,age,0);
    }

    public Employee(String name , int age, float salary){

        initialize(name,age,salary);
    }

    private void initialize(String name, int age, float salary){

        this.name = name;
        this.age = age;
        this.salary = salary;

    }
    public void displayInfo(){

        System.out.println("Name of Employee is :" + name + " his/her age is :" + age + " his/her salary is :" + salary);

    }

    public static void main(String[] args){

        Employee e1 = new Employee("Yash");
        e1.displayInfo();

        Employee e2  = new Employee("Yash", 20);
        e2.displayInfo();

        Employee e3 = new Employee("Yash", 20, 200000.0F);
        e3.displayInfo();
    }
}