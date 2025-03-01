package uni;
import java.util.HashMap;

public class Transcript {
    public int studentID;
    public HashMap<Integer, Double> transcript;

    public Transcript(int StudentID) {
        this.studentID = StudentID;
    }

    public void setGrade(int presentedCourseID, double grade) {
        PresentedCourse presentedCourse = PresentedCourse.findByID(presentedCourseID);
        boolean exists = false;
        if (presentedCourse != null) {
            exists = presentedCourse.studentIDs.contains(this.studentID);
        }
        else {
            System.out.println("Course " + presentedCourseID + " does not exist");
        }
        if (exists) {
            transcript.put(presentedCourseID, grade);
        }
        else {
            System.out.println("Student " + studentID + " does not have this course");
        }
    }

    public void printTranscript() {
        //null pointer should be handled
        for (Integer i : transcript.keySet()) {
            String name = Course.findById(PresentedCourse.findByID(i).courseID).title;
            double grade = transcript.get(i);
            System.out.println(name + " : " + grade);
        }
    }

//    public double getGPA(){
//
//    }
}
