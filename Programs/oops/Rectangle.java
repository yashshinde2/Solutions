class Rectangle{

    int length;
    int width;

    public Rectangle(){

        this.length = 1;
        this.width = 1;
    }

    public Rectangle(int length){

        this.length = length;
        this.width = length;
    }

    public Rectangle(int length, int width){

        this.length = length;
        this.width = width;
    }

    public void calculateArea(){

        int area = length * width;

        if(length == width){

            System.out.println("Square with side : " + length);
        }
        else{

            System.out.println("Rectangle with length : " + length + " and width : " + width);
        }

        System.out.println("Area is : " + area);

    }

    public static void main(String[] args) {
      
      Rectangle r1 = new Rectangle();
      r1.calculateArea();

      Rectangle r2 = new Rectangle(5);
      r2.calculateArea();

      Rectangle r3 = new Rectangle(5, 10);
      r3.calculateArea();

        
    }
}