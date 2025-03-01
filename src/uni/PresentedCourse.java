package uni;

import java.util.ArrayList;

public class PresentedCourse {
    public int presentedCourseID;
    public static ArrayList<PresentedCourse> presentedCourseList;
    public int courseID;
    public int professorID;
    public int capacity;
    public ArrayList<Integer> studentIDs;

    public PresentedCourse(int courseID, int professorID, int capacity) {
        this.courseID = courseID;
        this.professorID = professorID;
        this.capacity = capacity;
        presentedCourseList = new ArrayList<PresentedCourse>(capacity);
        studentIDs = new ArrayList<Integer>();
        presentedCourseList.add(this);
        presentedCourseID = presentedCourseList.size();
    }

    public static PresentedCourse findByID(int presentedCourseID) {
        for (PresentedCourse p : presentedCourseList) {
            if (p.presentedCourseID == presentedCourseID) {
                return p;
            }
        }
        return null;
    }

    public void addStudent(int studentID) {
        if (!studentIDs.contains(studentID)) {
            if (studentIDs.size() < capacity) {
                studentIDs.add(studentID);
            }
            else {
                System.out.println("Maximum capacity exceeded");
            }
        }
        else {
            System.out.println("Student ID already in use");
        }
    }

}
