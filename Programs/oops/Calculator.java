class Calculator {

    String name;

    // Default Constructor
    public Calculator() {
        this.name = "Default Calculator";
        System.out.println("Default Constructor Called");
    }

    // Parameterized Constructor
    public Calculator(String name) {
        this.name = name;
        System.out.println("Calculator Name: " + name);
    }

    // Addition of 2 integers
    public int calculate(int a, int b) {
        return a + b;
    }

    // Addition of 3 integers
    public int calculate(int a, int b, int c) {
        return a + b + c;
    }

    // Multiplication of 2 doubles
    public double calculate(double a, double b) {
        return a * b;
    }

    // Operation based on String
    public int calculate(String op, int a, int b) {

        switch (op) {

            case "+":
                return a + b;

            case "-":
                return a - b;

            case "*":
                return a * b;

            case "/":
                if (b == 0) {
                    System.out.println("Division by zero is not allowed.");
                    return 0;
                }
                return a / b;

            default:
                System.out.println("Invalid Operator");
                return 0;
        }
    }

    // Varargs method
    public int calculate(int... numbers) {

        int sum = 0;

        for (int num : numbers) {
            sum += num;
        }

        return sum;
    }

    public static void main(String[] args) {

        Calculator c1 = new Calculator();
        Calculator c2 = new Calculator("My Calculator");

        System.out.println();

        System.out.println("Addition (2 int): " + c1.calculate(5, 3));

        System.out.println("Addition (3 int): " + c1.calculate(5, 3, 2));

        System.out.println("Multiplication (double): " + c1.calculate(5.0, 3.0));

        System.out.println("Addition using String: " + c1.calculate("+", 5, 3));

        System.out.println("Subtraction: " + c1.calculate("-", 10, 4));

        System.out.println("Multiplication: " + c1.calculate("*", 5, 4));

        System.out.println("Division: " + c1.calculate("/", 20, 5));

        System.out.println("Varargs Sum: " + c1.calculate(1, 2, 3, 4, 5));
    }
}