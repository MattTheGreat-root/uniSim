package base;
import java.util.ArrayList;

public class Person {
   public int personID;
    public String name;
    public String nationalID;
    public static ArrayList<Person> personList = new ArrayList<Person>();

    public Person(String name, String nationalID) {
        this.name = name;
        this.nationalID = nationalID;
        personList.add(this);
        this.personID = personList.size();
    }

    public static Person findByID(int personID){
        for (Person peron : personList){
            if (peron.personID == personID){
                return peron;
            }
        }
        return null;
    }

}
