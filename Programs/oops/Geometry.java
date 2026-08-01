abstract class Shape{

    String name;

    public Shape(String name){

        this.name = name;
    }

    public abstract void area();

    public abstract void perimeter();

    public void printShape(){

        System.out.println("This is a shape");
    }

    public void displayAll(){

        System.out.println("Name of shape is : " + name);
        printShape();
        area();
        perimeter();
    }
}

class Circle extends Shape{

    float radius;

    public Circle(String name, float radius){

        super(name);
        this.radius = radius;
    }

    public void area(){

        float area = 3.14F * radius * radius;
        System.out.println("Area of circle is : " + area);

    }

    public void perimeter(){

        float perimeter = 2 * 3.14F * radius;
        System.out.println("Perimeter of circle is : " + perimeter);
    }
}

class Rectangle extends Shape{

    float length;
    float width;

    public Rectangle(String name, float length, float width){

        super(name);
        this.length = length;
        this.width = width;

    }

    public void area(){

        float area = length * width;
        System.out.println("Area of rectangle is : " + area);
    }

    public void perimeter(){

        float perimeter = 2 * (length + width);
        System.out.println("Perimeter of rectangle is : " + perimeter);
    }
}

class Geometry{

    public static void main(String[] args){

        Shape c = new Circle("Mycircle", 5);
        c.displayAll();

        Shape r = new Rectangle("MyRectangle", 4, 6);
        r.displayAll();

        Shape[] shapes = {new Circle("c1", 3), new Rectangle("r1", 2 ,3 )};
        for  (Shape s : shapes){

            s.displayAll();
        }
    }
}