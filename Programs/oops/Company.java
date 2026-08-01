abstract class Employee {

    protected String name;
    protected float salary;

    public Employee(String name, float salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract float calculateBonus();

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

abstract class Manager extends Employee {

    protected int teamSize;

    public Manager(String name, float salary, int teamSize) {
        super(name, salary);
        this.teamSize = teamSize;
    }

    @Override
    public float calculateBonus() {
        return salary * 0.15f * (teamSize / 10.0f);
    }
}

class ProjectManager extends Manager {

    private int projectsHandled;

    public ProjectManager(String name, float salary, int teamSize, int projectsHandled) {
        super(name, salary, teamSize);
        this.projectsHandled = projectsHandled;
    }

    @Override
    public float calculateBonus() {
        return super.calculateBonus() + (projectsHandled * 1000);
    }
}

class HRManager extends Manager {

    public HRManager(String name, float salary, int teamSize) {
        super(name, salary, teamSize);
    }

    @Override
    public float calculateBonus() {
        return salary * 0.20f;
    }
}

public class Company {

    public static void main(String[] args) {

        Employee[] employees = {
                new ProjectManager("Yash", 50000, 5, 3),
                new HRManager("Aniket", 45000, 10),
                new ProjectManager("Priya", 60000, 8, 5)
        };

        for (Employee emp : employees) {
            emp.displayInfo();
            System.out.println("Bonus: " + emp.calculateBonus());
            System.out.println();
        }
    }
}