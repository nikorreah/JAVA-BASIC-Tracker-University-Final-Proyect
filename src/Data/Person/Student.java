package Data.Person;

public class Student extends Person {
    private static int NextCostumerID = 2021001;
    private int studentId;
    private int age;


    public Student(String name, int age){
        super(name);
        this.age=age;
        this.studentId = NextCostumerID++;
    }

    public Student(){
        this.studentId = NextCostumerID++;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString (){
        return "Student ID: " + this.studentId + " Name: " + this.name;
    }
}
