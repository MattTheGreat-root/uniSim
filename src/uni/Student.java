package uni;
import java.util.ArrayList;

public class Student {
    public int studentID;
    public static ArrayList<Student> students;
    public int personID; //Person object id
    public final int entranceYear;
    public int majorID; //Major object id
    public String studentCode;

    public Student(int personID, int entranceYear, int majorID) {
        this.personID = personID;
        this.entranceYear = entranceYear;
        this.majorID = majorID;
        students = new ArrayList<Student>();
        students.add(this);
        this.studentID = students.size();
        //Major m = Major.findById(majorID);
        if (Major.findById(majorID) != null) {
            Major.findById(majorID).addStudent();
        }
        else {
            System.out.println("No major found");
        }
        setStudentCode();
    }


    public static Student findById(int id) {
        for (Student s : students) {
                if (s.studentID == id) {
                    return s;
                }
        }
        return null;
    }

    public void setStudentCode(){
        this.studentCode = String.valueOf(entranceYear) + String.valueOf(majorID) + String.valueOf(Major.findById(majorID));
    }

}
