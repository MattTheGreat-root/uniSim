package uni;
import java.util.HashMap;

public class Transcript {
    public int studentID;
    //keys are the presentedCourseID and values are the grades
    public HashMap<Integer, Double> transcript = new HashMap<>();

    public Transcript(int StudentID) {
        this.studentID = StudentID;
    }

    public void setGrade(int presentedCourseID, double grade) {
        boolean exists = false;
        if (PresentedCourse.findByID(presentedCourseID) != null) {
            exists = PresentedCourse.findByID(presentedCourseID).studentIDs.contains(this.studentID);
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

    public double getGPA(){
        int numberOfUnits = 0;
        double soorat=0;
        for (Integer i : transcript.keySet()) {
            numberOfUnits += Course.findById(PresentedCourse.findByID(i).courseID).units;
            soorat += Course.findById(PresentedCourse.findByID(i).courseID).units * transcript.get(i);
        }
        return soorat/numberOfUnits;
    }
}
