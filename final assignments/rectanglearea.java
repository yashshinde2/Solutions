class rectangle{

    int length;
    int breadth;
    int area;
    int perimeter;

    rectangle(){

        this.length = length;
        this.breadth = breadth;
        this.area = area;
        this.perimeter = perimeter;
    }

    int area(){

            area = length * breadth;
            return(area);
    }

    int perimeter(){

          perimeter = length + breadth;
          return(perimeter);
    }
}

class rectanglearea{

    public static void main(String[] args){

        int rectarea, rectperi;
        rectangle r = new rectangle();
        rectarea = r.area();
        rectperi = r.perimeter();
        System.out.println("Area :" +r.area);
        System.out.println("Perimeter:" +r.perimeter);

    }
}
