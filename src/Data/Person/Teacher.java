package Data.Person;

public abstract class Teacher extends Person{
    protected float baseSalary;
    private static int NextTeacherID = 101;
    private int teacherID;

    public Teacher(String name) {
        super(name);
        this.baseSalary = 50000f;
        this.teacherID = NextTeacherID++;
    }

    public static int getNextTeacherID() {
        return NextTeacherID;
    }

    public static void setNextTeacherID(int nextTeacherID) {
        NextTeacherID = nextTeacherID;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public Teacher(float baseSalary) {
        this.baseSalary = 50000f;
    }

    public float getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(float baseSalary) {
        this.baseSalary = baseSalary;
    }

    public abstract float teacherSalary ();

    public abstract float teacherSalary(float getBaseSalary);

    public String teacherToString () {
       return "Select the main teacher: " + "Teacher ID:" + this.teacherID +" "+ this.name;
    }

}
