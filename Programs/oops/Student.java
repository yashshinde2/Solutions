class Student{

    String name;
    int rollNumber;
    float gpa;

    public void displayStudentInfo(){

        System.out.println(name + " " + rollNumber + " " + gpa);

    }

    public static void main(String[] args) {
        
        Student s1 = new Student();
        s1.name = "Yash";
        s1.rollNumber = 79;
        s1.gpa = 8.9F;
        s1.displayStudentInfo();
        
        Student s2 = new Student();
        s2.name = "Yash";
        s2.rollNumber = 80;
        s2.gpa = 7.9F;
        s2.displayStudentInfo();

        Student s3 = new Student();
        s3.name = "Yash";
        s3.rollNumber = 85;
        s3.gpa = 9.9F;
        s3.displayStudentInfo();
         
     
    }

}