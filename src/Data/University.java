package Data;

import Data.Person.Student;
import Data.Person.Teacher;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Teacher> teacherList;
    private List<Student> studentsList;
    private List<Course> coursesList;


    public University() {
        this.teacherList = new ArrayList<Teacher>();
        this.coursesList = new ArrayList<Course>();
        this.studentsList = new ArrayList<Student>();
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }


    public List<Course> getCoursesList() {
        return this.coursesList;
    }

    public void setCoursesList(List<Course> coursesList) {
        this.coursesList = coursesList;
    }

    public void createNewTeacher() {
    }

    public void createNewStudent() {
    }

    public void addNewStudent(Student student) {
        this.studentsList.add(student);
    }

    public void addTeacher(Teacher teacher) {
        this.teacherList.add(teacher);
    }

    public void newCourse(Course course) {
        this.coursesList.add(course);
    }

    public Course findCourse(String name) {
        for (Course findTheCourse : this.getCoursesList()) {
            if (findTheCourse.getName().equals(name)) {
                return findTheCourse;
            }
        }
        return null;
    }

    public Course findCourseByID(int id) {
        for (Course _ID : getCoursesList()) {
            if (_ID.getCourseId() == id) {
                return _ID;
            }
        }
        return null;
    }

    public Teacher findTeacherByID(int id) {
        for (Teacher _ID : getTeacherList()) {
            if (_ID.getTeacherID() == id) {
                return _ID;
            }
        }
        return null;
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

    public void cursesListToString () {
        for (int i = 0; i < this.getCoursesList().size(); ++i) {
            System.out.println(1 + i + "." + " Class name: " + this.getCoursesList().get(i).getName() +
                    ". Class room: " + this.getCoursesList().get(i).getCourseRoom() + " Course ID: " +
                    this.getCoursesList().get(i).getCourseId());
        }
    }
}
