package uni;
import java.util.ArrayList;

public class Student {
    public int studentID;
    public static ArrayList<Student> students = new ArrayList<Student>();
    public int personID;
    public final int entranceYear;
    public int majorID;
    public String studentCode;

    public Student(int personID, int entranceYear, int majorID) {
        this.personID = personID;
        this.entranceYear = entranceYear;
        this.majorID = majorID;
        students.add(this);
        this.studentID = students.size();

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
        String temp = String.valueOf(entranceYear);
        if (majorID < 10){
            temp += "0";
        }
        temp += String.valueOf(majorID);
        if (Major.findById(majorID).numberOfStudents < 10 && Major.findById(majorID) != null) {
            temp += "0";
        }
        if (Major.findById(majorID) != null){
            temp += String.valueOf(Major.findById(majorID).numberOfStudents);
        }
        else {
            System.out.println("No major found with this ID");
        }
        this.studentCode = temp;
    }

}
