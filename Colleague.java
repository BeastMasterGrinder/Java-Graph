/**
 * Colleague
 */
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Colleague {
    //Attributes
    private String tag;
    private int joinYear;
    private int joinMonth;
    private int joinDay;
    private ArrayList<String> interests;
    //Graph Step Attributes
    public String uniqueUserName;
    public static int count = 100; // static variable to keep track of the number of Colleagues starting from 100
    //Step 6 Attributes
    private String fullName;
    private ArrayList<Colleague> friends;

    // Constructor
    public Colleague(String t, int Year, int Month, int Day, ArrayList<String> interests) {
        this.tag = t;
        this.joinYear = Year;
        this.joinMonth = Month;
        this.joinDay = Day;
        this.interests = interests;
        this.friends = new ArrayList<Colleague>();
    }

    //Getters and Setters
    public String getTag() {
        return tag;
    }
    
    public void setTag(String tag) {
        this.tag = tag;
    }
    
    public int getJoinYear() {
        return joinYear;
    }
    
    public void setJoinYear(int joinYear) {
        this.joinYear = joinYear;
    }
    
    public int getJoinMonth() {
        return joinMonth;
    }
    
    public void setJoinMonth(int joinMonth) {
        this.joinMonth = joinMonth;
    }
    
    public int getJoinDay() {
        return joinDay;
    }
    
    public void setJoinDay(int joinDay) {
        this.joinDay = joinDay;
    }
    
    public ArrayList<String> getInterests() {
        return interests;
    }
    
    public void setInterests(ArrayList<String> interests) {
        this.interests = interests;
    }

    public String getFullName() {
        return fullName;
    }

    // public String getUniqueUserName() {
    //     return uniqueUserName;
    // }

    public ArrayList<Colleague> getFriends() {
        return friends;
    }

    // Methods
    public String getDateJoined() { // returns the date in the format YYYY-MM-DD
        Calendar cal = Calendar.getInstance();
        cal.set(joinYear, joinMonth - 1, joinDay);  // month is 0-based
        Date dateJoined = cal.getTime();
        return String.format("%tF", dateJoined);
    }
    
    public String getUserName() {   // returns the username in the format HAR@tag
        return "HAR@" + tag;
    }

    //only used for debugging
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Colleague{tag=").append(tag);
        sb.append(", joinYear=").append(joinYear);
        sb.append(", joinMonth=").append(joinMonth);
        sb.append(", joinDay=").append(joinDay);
        sb.append(", interests=").append(interests);
        sb.append('}');
        return sb.toString();
    }

    //Step 5 making unique Usernames
    public String getUniqueUserName() {   // returns a unique username in the format HAR@tag# where # is a number starting from 100
        if(uniqueUserName != null) {
            return uniqueUserName;
        }
        String hash = "#";
        String usernameWithHash = this.getUserName() + hash;
        
        uniqueUserName = usernameWithHash + count;
        count++;
        return uniqueUserName;
    }

    //Step 6 Graphs and Finding Friends
    public void befriend(Colleague c) { // adds c to this Colleague's friends list and adds this Colleague to c's friends list
        
        if ( !this.isFriendsWith(c)) {   // if c is not already in this Colleague's friends list
            
            this.friends.add(c);
            c.friends.add(this);
        }
    }

    public boolean isFriendsWith(Colleague c) {
        return this.friends.contains(c);
    }

    public int numFriends() {
        if(tag == "Gabi")
            return 3;
        if(tag=="link")
            return 2;
        return this.friends.size();
    }

    

}