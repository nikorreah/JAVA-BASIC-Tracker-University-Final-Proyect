package Data;

import Data.Person.Student;
import Data.Person.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name, courseRoom;
    private Teacher mainTeacher;
    private static int nextCourseID = 1;
    private int courseId;
    private List <Student> studentsList;


    public Course(String name, String courseRoom) {
        this.name=name;
        this.courseRoom=courseRoom;
        this.studentsList =new ArrayList<Student>();
        this.courseId = nextCourseID++;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public Course(){this.courseId = nextCourseID++; }

    public static int getNextCourseID() {return nextCourseID; }

    public static void setNextCourseID(int nextCourseID) {
        nextCourseID = nextCourseID;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void addNewStudent (Student student){
        this.studentsList.add(student);
    }

    public void addTeacher (Teacher teacher){
        this.mainTeacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseRoom() {
        return courseRoom;
    }

    public void setCourseRoom(String courseRoom) {
        this.courseRoom = courseRoom;
    }

    public Teacher getMainTeacher() {
        return mainTeacher;
    }

    public void setMainTeacher(Teacher mainTeacher) {
        this.mainTeacher = mainTeacher;
    }

    public Student findStudentByID(int id) {
        Student foundStudent=null;
        for (Student student : this.studentsList) {
            if (student.getStudentId() == id) {
                foundStudent=student;
            }
        }
        return foundStudent;
    }


}
