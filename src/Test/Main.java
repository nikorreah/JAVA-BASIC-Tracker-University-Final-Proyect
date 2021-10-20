package Test;

import Data.Course;
import Data.Person.Student;
import Data.Person.Teacher;
import Data.Person.TypeTeacher.FullTime;
import Data.Person.TypeTeacher.PartTime;
import Data.University;

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

        // initialating minimun 4 classes
        university.newCourse(new Course("Televition", "A101"));
        university.newCourse(new Course("Radio", "B302"));
        university.newCourse(new Course("Desarrollo Front End", "A204"));
        university.newCourse(new Course("Java Basic", "B202"));


        university.findCourse("Televition").addTeacher(university.getTeacherList().get(2));
        university.findCourse("Televition").addNewStudent(student1);
        university.findCourse("Televition").addNewStudent(student2);
        university.findCourse("Televition").addNewStudent(student3);


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
            initMenu();
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    selectMenu1(university);
                    break;
                case 2:
                    selectMenu2(university);
                    break;
                case 3:
                    selectMenu3(university);
                    break;
                case 4:
                    selectMenu4(university);
                    break;
                case 5:
                    selectMenu5(university);
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
    private static void initMenu () {
        System.out.println("========Welcome to the Final University=======\n" +
                "==========PLEASE MAKE YOUR SELECTION========== \n" +
                "1. The teacher list. \n" +
                "2. The Classes at the campus. \n" +
                "3. Create a new student. \n" +
                "4. Create a new Class. \n" +
                "5. The where the student are included. \n" +
                "6. Exit.");
    }

    private static void selectMenu1 (University university) {
        System.out.println("=======Teacher List======");
        for (int i = 0; i < university.getTeacherList().size(); i++) {
            System.out.println(university.getTeacherList().get(i).toString());
        }
    }

    private static void selectMenu2 (University university) {
        boolean optionSubMenu =true;
        while (optionSubMenu) {
            System.out.println("\n=======Classes and class rooms======\n" +
                    "Select the class you want to check the Teacher and the students");
            System.out.println("0. Exit");
            university.cursesListToString();
            Scanner subMenu1 = new Scanner(System.in);
            int optionSubMenu1 = subMenu1.nextInt();
            if (optionSubMenu1>0 && optionSubMenu1 <= university.getCoursesList().size()){
                System.out.println("Teacher: " + university.getCoursesList().get(optionSubMenu1-1).getMainTeacher().getName());
                for (Student i: university.getCoursesList().get(optionSubMenu1-1).getStudentsList()) {
                    System.out.println(i.toString());
                }
            } else if (optionSubMenu1 == 0) {
                optionSubMenu=false;
            }
            else {
                System.out.println("Select a valid option");
            }
        }
    }

    private static void selectMenu3 (University university){
        Scanner newStudent = new Scanner(System.in);
        System.out.print("Please enter new student name: ");
        String student = newStudent.nextLine();
        System.out.print("Please enter the student age: ");
        int studentAge = newStudent.nextInt();
        Student newStudentAdd = new Student(student, studentAge);
        university.addNewStudent(newStudentAdd);
        System.out.println("Select the Class (by number) where the new student will be add: \n");
        university.cursesListToString();
        Scanner courseChoice= new Scanner(System.in);
        int id= courseChoice.nextInt();
        if (id > university.getCoursesList().size()){
            System.out.println("You have select a invalid option");
            } else {
        university.findCourseByID(id).addNewStudent(newStudentAdd);}
    }

    private static void selectMenu4 (University university) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of the new class: ");
        String courseNew = scanner.nextLine();
        System.out.println("Please enter the classroom: ");
        String classRoom = scanner.nextLine();
        Course newCourseAdd = new Course(courseNew, classRoom);
        university.newCourse(newCourseAdd);
        for (int i = 0; i < university.getTeacherList().size(); i++) {
            System.out.println(university.getTeacherList().get(i).teacherToString());
        }
        int teacherSelect = scanner.nextInt();
        Teacher teacherAdd = university.findTeacherByID(teacherSelect);
        university.findCourse(courseNew).addTeacher(teacherAdd);
        System.out.println("Do you want to add a student to this class: \n" +
                "1. Yes \n" +
                "2. No");
        scanner=new Scanner(System.in);
        int option4 = scanner.nextInt();
        while (option4 < 2){
            System.out.println("select the ID of the student that you want to add:");
            for (int i = 0; i < university.getStudentsList().size(); i++) {
                System.out.println(university.getStudentsList().get(i).toString());
            }
            int studentSelected=scanner.nextInt();
            Student studentToAdd= university.findStudentByID(studentSelected);
            university.findCourse(courseNew).addNewStudent(studentToAdd);
            System.out.println("Do you want to add another student? \n" +
                    "1. Yes.\n" +
                    "2. No");
            scanner=new Scanner(System.in);
            int optionSubMenu4= scanner.nextInt();
            if (optionSubMenu4 < 1 ) {
                System.out.println("Do you want to add another student? \n" +
                        "1. Yes.\n" +
                        "2. No");
            } else if (optionSubMenu4 == 2) {
                option4=2;
            } else {
                System.out.println("Select a correct option");
            }
        }
    }

    private static void selectMenu5 (University university) {
        System.out.println("-- Which student you want to check for his classes--\n" +
                "-------Select the ID that you want to search:");
        for (int i = 0; i < university.getStudentsList().size(); i++) {
            System.out.println(university.getStudentsList().get(i).toString());
        }
        Scanner scanner = new Scanner(System.in);
        int studentID= scanner.nextInt();
        System.out.println("There are the classes that the student attend: ");
        for (int i = 0; i < university.getCoursesList().size(); i++) {
            if (university.getCoursesList().get(i).findStudentByID(studentID) != null) {
                System.out.println("OK=> " + university.getCoursesList().get(i).getName());
            } else {
                System.out.println("No here: " + university.getCoursesList().get(i).getName());
            }
        }
    }
    }
