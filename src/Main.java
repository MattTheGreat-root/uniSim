import base.Person;
import uni.*;

public class Main {
    public static void printLine(){
        System.out.println("-----------------------------------------");
    }

    public static void main(String[] args) {
        Major computer = new Major("Computer Science", 15);
        Major art = new Major("art", 10);

        Person person1 = new Person("Trevor", "123");
        Person person2 = new Person("Franklin", "456");
        Person person3 = new Person("Amanda", "789");
        Person person4 = new Person("Lamar", "321");
        Person person5 = new Person("Tracy", "654");

        person1.personID = 1;
        person2.personID = 2;
        person3.personID = 3;
        person4.personID = 4;
        person5.personID = 5;

        Student student1 = new Student(1,403,computer.majorID);
        Student student2 = new Student(2,403,computer.majorID);
        Student student3 = new Student(3,403,art.majorID);

        System.out.println("Students and their student codes:");
        int j = 0;
        for (int i = 1; i <= 3; i++) {
            if (Person.findByID(i) != null) {
                System.out.println(Person.findByID(i).name);
                System.out.println(Student.students.get(j).studentCode);
                j++;
            }
            else {
                System.out.println("No student found with ID " + i);
            }
        }
        printLine();

        Professor professor1 = new Professor(4, computer.majorID);
        Professor professor2 = new Professor(5, art.majorID);

        System.out.println("Professors and their professor IDs in order:");
        int z = 0;
        for (int i = 4; i <= 5; i++) {
            if (Person.findByID(i) != null) {
                System.out.println(Person.findByID(i).name);
                System.out.println(Professor.professorList.get(z).professorID);
                z++;
            }
            else {
                System.out.println("No professor found with ID " + i);
            }
        }
        printLine();

        Course course1 = new Course("Basic Programming", 3);
        Course course2 = new Course("Advanced Programming", 3);
        Course course3 = new Course("Art", 2);

        PresentedCourse presentedCourse1 = new PresentedCourse(course1.courseID, professor1.professorID, 30);
        PresentedCourse presentedCourse2 = new PresentedCourse(course2.courseID, professor1.professorID, 35);
        PresentedCourse presentedCourse3 = new PresentedCourse(course3.courseID, professor2.professorID, 33);

        presentedCourse1.addStudent(student1.studentID);
        presentedCourse1.addStudent(student2.studentID);
        presentedCourse2.addStudent(student1.studentID);
        presentedCourse2.addStudent(student2.studentID);
        presentedCourse2.addStudent(student3.studentID);
        presentedCourse3.addStudent(student3.studentID);

        Transcript transcript1 = new Transcript(student1.studentID);
        Transcript transcript2 = new Transcript(student2.studentID);
        Transcript transcript3 = new Transcript(student3.studentID);

        transcript1.setGrade(presentedCourse1.presentedCourseID, 18);
        transcript1.setGrade(presentedCourse2.presentedCourseID, 19.5);
        transcript2.setGrade(presentedCourse1.presentedCourseID, 15);
        transcript2.setGrade(presentedCourse2.presentedCourseID, 17);
        transcript3.setGrade(presentedCourse2.presentedCourseID, 12);
        transcript3.setGrade(presentedCourse3.presentedCourseID, 20);

        System.out.println(Person.findByID(student1.personID).name + "'s courses and grades:");
        transcript1.printTranscript();
        printLine();
        System.out.println(Person.findByID(student2.personID).name + "'s courses and grades:");
        transcript2.printTranscript();
        printLine();
        System.out.println(Person.findByID(student3.personID).name + "'s courses and grades:");
        transcript3.printTranscript();
        printLine();

        if (Person.findByID(student1.personID) != null) {
            System.out.println(Person.findByID(student1.personID).name + "'s GPA:");
            System.out.println(transcript1.getGPA());
        }
        else {
            System.out.println("No student found with ID " + student1.personID);
        }
        if (Person.findByID(student2.personID) != null) {
            System.out.println(Person.findByID(student2.personID).name + "'s GPA:");
            System.out.println(transcript2.getGPA());
        }
        else {
            System.out.println("No student found with ID " + student2.personID);
        }
        if (Person.findByID(student3.personID) != null) {
            System.out.println(Person.findByID(student3.personID).name + "'s GPA:");
            System.out.println(transcript3.getGPA());
        }
        else {
            System.out.println("No student found with ID " + student3.personID);
        }
    }
}