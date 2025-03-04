package uni;

import java.util.ArrayList;

public class Course {
    public int courseID;
    public String title;
    public static ArrayList<Course> courseList = new ArrayList<Course>();
    public int units;
    public Course(String title, int units) {
        this.title = title;
        this.units = units;
        courseList.add(this);
        this.courseID = courseList.size();
    }
    public static Course findById(int id) {
        for (Course c : courseList) {
            if (c.courseID == id) {
                return c;
            }
        }
        return null;
    }

}
