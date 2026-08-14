class Employee {
    String name;
    double salary;
    double providentFund;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.providentFund = salary * 0.12;
    }


    void displayInfo() {
        System.out.println("Name : " + name);
        System.out.println("Salary : " + salary);
        System.out.println("Provident Fund : " + providentFund);
        System.out.println("In hand Salary : " + (salary - providentFund));
    }

    public static void main(String[] args) {
        Employee e = new Employee("Swara", 40000);
        e.displayInfo();
    }
}