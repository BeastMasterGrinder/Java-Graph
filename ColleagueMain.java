import java.util.ArrayList;

public class ColleagueMain {
    public static void main(String[] args) {
        ArrayList<String> interests = new ArrayList<String>();
        interests.add("Programming");
        interests.add("Reading");
        Colleague colleague = new Colleague("JoeMam", 2020, 6, 15, interests);
        System.out.println(colleague.getDateJoined()); // output: 2020-06-15
        System.out.println(colleague.getUserName()); // output: HAR@JoeMam
        System.out.println(colleague.toString()); // output: Colleague{tag=JohnDoe, joinYear=2020, joinMonth=6, joinDay=15, interests=[Programming, Reading]}
        System.out.println(colleague.getUniqueUserName());
    }
}
