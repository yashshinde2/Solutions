class Person{

    private String name;
    private int age;

    public Person(String name){

        this(name,0);
    }

    public Person(String name, int age){

        this.name = name;
        this.age = age;
    }

    public void displayInfo(){

        System.out.println(name + " " + age);
    }

    public String getName(){

        return name;
    }

    public int getAge(){

        return age;
    }

    public static void main(String[] args){

        Person p1 = new Person("yash");
        p1.displayInfo();

        Person p2 = new Person("Yash" , 21);
        p2.displayInfo();

        System.out.println(p1.getName());
        System.out.println(p1.getAge());
    }
}