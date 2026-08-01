class Student1{

    private String name;
    private float gpa;
    private int age;
    final String universityName;

    public Student1(String name, float gpa, int age){

        this.name = name;
        this.gpa = gpa;
        this.age = age;
        this.universityName = "DYP";
    }

    public String getName(){

        return name;
    }

    public float getgpa(){

        return gpa;
    }

    public int getAge(){

        return age;
    }

    public void setgpa(float gpa){

        if(gpa < 0 || gpa > 4.0){

            System.out.println("Enter a valid gpa");
        }
        else{
        this.gpa = gpa;
        }
    }

    public void displayInfo(){

        System.out.println("Name of student is :" + name + " age is :" + age + " and gpa is :" + gpa + " and university is:" + universityName);
    }

    public static void main(String[] args) {
        
        Student1 s1 = new Student1("Yash", 3.5F, 21);
        s1.displayInfo();

        System.out.println("GPA :" + s1.getgpa());

        s1.setgpa(3.4F);
        s1.displayInfo();

        s1.setgpa(5.0F);
        s1.displayInfo();
        
    }
}
