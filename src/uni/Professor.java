package uni;

import java.util.ArrayList;

public class Professor {
    public int professorID;
    public static ArrayList<Professor> professorList;
    public int personID;
    public int majorID;

    public Professor(int personID, int majorID) {
        this.personID = personID;
        this.majorID = majorID;
        professorList = new ArrayList<Professor>();
        professorList.add(this);
    }

    public static Professor findByID(int professorID) {
        for (Professor p : professorList) {
            if (p.professorID == professorID) {
                return p;
            }
        }
        return null;
    }
}
