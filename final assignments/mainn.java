
abstract class Shape {
    String color;

    Shape(String color) {
        this.color = color;
    }

 
    String getColor() {
        return color;
    }

    void setColor(String color) {
        this.color = color;
    }


    abstract double calculateArea();
    abstract double calculatePerimeter();

   
    void displayProperties() {
        System.out.println("Color: " + color);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
    }
}


class Circle extends Shape {
    double radius;

    Circle(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    double calculateArea() {
        return 3.14 * radius * radius;
    }

    double calculatePerimeter() {
        return 2 * 3.14 * radius;
    }
}


class Rectangle extends Shape {
    double length, width;

    Rectangle(double length, double width, String color) {
        super(color);
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }

    double calculatePerimeter() {
        return 2 * (length + width);
    }
}


class Triangle extends Shape {
    double side1, side2, side3;

    Triangle(double s1, double s2, double s3, String color) {
        super(color);
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }

    double calculateArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    double calculatePerimeter() {
        return side1 + side2 + side3;
    }
}


public class mainn {
    public static void main(String[] args) {
        Circle c = new Circle(5, "Red");
        Rectangle r = new Rectangle(4, 6, "Blue");
        Triangle t = new Triangle(3, 4, 5, "Green");

        c.displayProperties();
        System.out.println();
        r.displayProperties();
        System.out.println();
        t.displayProperties();
    }
}