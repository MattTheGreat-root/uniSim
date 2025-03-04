package uni;
import java.util.ArrayList;

public class Major {
    public int majorID;
    public static ArrayList<Major> majorList = new ArrayList<Major>();
    public String name;
    public final int maxCapacity;
    public int numberOfStudents = 0;

    public Major(String name, int maxCapacity) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        majorList.add(this);
        this.majorID = majorList.size();
    }

    public static Major findById(int majorID){
        for (Major m : majorList){
            if (m.majorID == majorID){
                return m;
            }
        }
        return null;
    }

    public void addStudent(){
        if (numberOfStudents < maxCapacity){
            numberOfStudents++;
        }
        else{
            System.out.println("Maximum capacity exceeded");
        }
    }
}
