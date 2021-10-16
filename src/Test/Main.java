package Test;

import Data.Course;
import Data.Person.Student;
import Data.Person.Teacher;
import Data.Person.TypeTeacher.FullTime;
import Data.Person.TypeTeacher.PartTime;
import Data.University;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        University university = new University();

        // initialating minimun 4 Teacher (two by class)


        university.addTeacher(new FullTime("Jorge Moreno",20));
        university.addTeacher(new FullTime("Erika Londoño", 15));
        university.addTeacher(new PartTime("Jorge Rojas", 4));
        university.addTeacher(new PartTime("Diana Villa", 8));

        // initialating minimun 6 student
        Student student1 = new Student("Alberto Contreras", 20);
        Student student2 = new Student("Juliana Santana", 19);
        Student student3 = new Student("Roberto Gomez", 21);
        Student student4 = new Student("Carlos Garcia", 18);
        Student student5 = new Student("Carolina Zapata", 19);
        Student student6 = new Student("Milena Ceballos", 21);

        university.addNewStudent(student1);
        university.addNewStudent(student2);
        university.addNewStudent(student3);
        university.addNewStudent(student4);
        university.addNewStudent(student5);
        university.addNewStudent(student6);

        Course course1 = new Course("Televisión", "A101");
        Course course2 = new Course("Radio", "B302");
        Course course3 = new Course("Desarrollo Front End", "A204");
        Course course4 = new Course("Java Basic", "B202");

        university.newCourse(course1);
        university.newCourse(course2);
        university.newCourse(course3);
        university.newCourse(course4);


        university.findCourse("Televisión").addTeacher(university.getTeacherList().get(2));
        university.findCourse("Televisión").addNewStudent(student1);
        university.findCourse("Televisión").addNewStudent(student2);
        university.findCourse("Televisión").addNewStudent(student3);


        university.findCourse("Radio").addTeacher(university.getTeacherList().get(0));
        university.findCourse("Radio").addNewStudent(student4);
        university.findCourse("Radio").addNewStudent(student5);
        university.findCourse("Radio").addNewStudent(student6);


        university.findCourse("Desarrollo Front End").addTeacher(university.getTeacherList().get(1));
        university.findCourse("Desarrollo Front End").addNewStudent(student1);
        university.findCourse("Desarrollo Front End").addNewStudent(student3);
        university.findCourse("Desarrollo Front End").addNewStudent(student5);


        university.findCourse("Java Basic").addTeacher(university.getTeacherList().get(3));
        university.findCourse("Java Basic").addNewStudent(student2);
        university.findCourse("Java Basic").addNewStudent(student4);
        university.findCourse("Java Basic").addNewStudent(student6);

        Scanner scanner = new Scanner(System.in);


        int option;
        do {
            System.out.println("========Welcome to the Final University=======\n" +
                    "==========PLEASE MAKE YOUR SELECTION========== \n" +
                    "1. The teacher list. \n" +
                    "2. The Classes at the campus. \n" +
                    "3. Create a new student. \n" +
                    "4. Create a new Class. \n" +
                    "5. The where the student are included. \n" +
                    "6. Exit.");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("=======Teacher List======");
                    for (int i = 0; i < university.getTeacherList().size(); i++) {
                        System.out.println("Name: " + university.getTeacherList().get(i).getName() + "\n" +
                                "Salary: " + university.getTeacherList().get(i).teacherSalary() + "\n");
                    }
                    break;
                case 2:
                    boolean optionSubMenu =true;
                    while (optionSubMenu) {
                        System.out.println("\n=======Classes and class rooms======\n" +
                                "Select the class you want to check the Teacher and the students");
                        System.out.println("0. Exit");
                        for (int i = 0; i < university.getCoursesList().size(); ++i) {
                            System.out.println(1 + i + "." + " Class name: " + university.getCoursesList().get(i).getName() +
                                    ". Class room: " + university.getCoursesList().get(i).getCourseRoom() + " Course ID: " +
                                    university.getCoursesList().get(i).getCourseId());
                        }
                        Scanner subMenu1 = new Scanner(System.in);
                        int optionSubMenu1 = subMenu1.nextInt();
                        if (optionSubMenu1>0 && optionSubMenu1 <= university.getCoursesList().size()){
                            System.out.println("Teacher: " + university.getCoursesList().get(optionSubMenu1-1).getMainTeacher().getName());
                            for (Student i: university.getCoursesList().get(optionSubMenu1-1).getStudentsList()) {
                                System.out.println("Student: " + i.getName() +
                                        " - Student ID: " + i.getStudentId());
                            }
                        } else if (optionSubMenu1 == 0) {
                            optionSubMenu=false;
                        }
                        else {
                            System.out.println("Select a valid option");
                        }
                    }
                    break;
                case 3:
                    Scanner newStudent = new Scanner(System.in);
                    System.out.print("Please enter new student name: ");
                    String student = newStudent.nextLine();
                    System.out.print("Please enter the student age: ");
                    int studentAge = newStudent.nextInt();
                    Student newStudentAdd = new Student(student, studentAge);
                    university.addNewStudent(newStudentAdd);
                    System.out.println("Select the Class (by number) where the new student will be add: \n" +
                             university.getCoursesList().get(0).getCourseId() + " Televisión. \n" +
                             university.getCoursesList().get(1).getCourseId() + " Radio \n" +
                             university.getCoursesList().get(2).getCourseId() + " Desarrollo Front End \n" +
                             university.getCoursesList().get(3).getCourseId() + " Java Basic \n");
                    Scanner courseChoice= new Scanner(System.in);
                    int id= courseChoice.nextInt();
                    university.findCourseByID(id).addNewStudent(newStudentAdd);
                    break;
                case 4:
                    Scanner newCourse = new Scanner(System.in);
                    System.out.println("Name of the new class: ");
                    String courseNew = newCourse.nextLine();
                    System.out.println("Please enter the classroom: ");
                    String classRoom = newCourse.nextLine();
                    Course newCourseAdd = new Course(courseNew, classRoom);
                    university.newCourse(newCourseAdd);
                    for (int i = 0; i < university.getTeacherList().size(); i++) {
                        System.out.println("Select the main teacher: " + "Teacher ID:"
                                +university.getTeacherList().get(i).getTeacherID() +" "+
                                university.getTeacherList().get(i).getName());
                    }
                    int teacherSelect = newCourse.nextInt();
                    Teacher teacherAdd = university.findTeacherByID(teacherSelect);
                    university.findCourse(courseNew).addTeacher(teacherAdd);
                    System.out.println("Do you want to add a student to this class: \n" +
                            "1. Yes \n" +
                            "2. No");
                    Scanner a=new Scanner(System.in);
                    int optionSubMenu3= a.nextInt();
                    boolean option4=true;
                    while (option4){
                        System.out.println("select the ID of the student that you want to add:");
                        for (int i = 0; i < university.getStudentsList().size(); i++) {
                            System.out.println("--" + "Student ID: " + university.getStudentsList().get(i).getStudentId() +
                                    "-" + university.getStudentsList().get(i).getName());
                        }
                        int studentSelected=scanner.nextInt();
                        Student studentToAdd= university.findStudentByID(studentSelected);
                        university.findCourse(courseNew).addNewStudent(studentToAdd);
                        System.out.println("Do you want to add another student? \n" +
                                "1. Yes.\n" +
                                "2. No");
                        Scanner b=new Scanner(System.in);
                        int optionSubMenu4= b.nextInt();
                        if (optionSubMenu4 < 1 ) {
                            System.out.println("Do you want to add another student? \n" +
                                    "1. Yes.\n" +
                                    "2. No");
                        } else if (optionSubMenu4 == 2) {
                                    option4=false;
                        } else {
                            System.out.println("Select a correct option");
                        }
                    }
                    break;
                case 5:
                    System.out.println("-- Which student you want to check for his classes--\n" +
                            "-------Select the ID that you want to search:");
                    for (int i = 0; i < university.getStudentsList().size(); i++) {
                        System.out.println(university.getStudentsList().get(i).toString());
                    }
                    scanner = new Scanner(System.in);
                    int studentID= scanner.nextInt();
                    System.out.println("There are the classes that the student attend: ");
                    for (int i = 0; i < university.getCoursesList().size(); i++) {
                        if (university.getCoursesList().get(i).findStudentByID(studentID) != null) {
                            System.out.println("OK=> " + university.getCoursesList().get(i).getName());
                        } else {
                                System.out.println("No here: " + university.getCoursesList().get(i).getName());
                        }
                    }
                    break;
                case 6:
                    System.out.println("Thanks for using our service ");
                    break;
                default:
                    System.out.println("you enter an incorrect item, thanks for using our service ");
                    break;
            }
        } while (option < 6);
    }

    }
