import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Graph {
    private BST tree;
    //Constructor
    public Graph(String edgeListFile,BST tree) {
        this.tree = tree;

        try (BufferedReader br = new BufferedReader(new FileReader(edgeListFile))) {    //try with resources
            System.out.println("Reading edge list from file " + edgeListFile);
            String line;
            while ((line = br.readLine()) != null) {
                String[] edge = line.split(",");    // Split the line into fields
                if (edge.length == 2) {
                    Colleague c1 = tree.findColleague(edge[0]); //findColleague method in BST
                    Colleague c2 = tree.findColleague(edge[1]);

                    if (c1 == null) {   //if colleague is not found
                        System.err.println("Colleague " + edge[0] + " not found in BST");
                    } else if (c2 == null) {
                        System.err.println("Colleague " + edge[1] + " not found in BST");
                    } else {
                        c1.befriend(c2);    //befriend method in Colleague
                    }
                } else {
                    System.err.println("Invalid edge: " + line);
                }
            }
        } catch (IOException e) {   //catch exception
            System.err.println("Error reading edge list file: " + e.getMessage());
        }
    }
    //findFriend method
    public Colleague findFriend(String userName) throws IllegalArgumentException {  //throws exception if colleague is not found
        Colleague c = tree.findColleague(userName);
        if (c == null) {    //if colleague is null
            throw new IllegalArgumentException("Colleague " + userName + " not found in BST");
        }

        Colleague bestFriend = null;
        int lowestDegree = 1;
        String latestJoinDate = "2022-01-01";
        int lastestyear = 2022;

        for (Colleague friend : tree.getColleagueFriends(c)) {  //getColleagueFriends method in BST
            boolean shareInterest = false;
            for(String interest : c.getInterests()) {    //getInterests method in Colleague
                if (friend.getInterests().contains(interest)) {    //getInterests method in Colleague
                    shareInterest = true;
                    break;
                }
            }
            //is not already friends with c AND shares an interest with c and has the lowest number of friends and joined the most recently
            if(!c.isFriendsWith(friend) && friend.numFriends() < lowestDegree && shareInterest && friend.getJoinYear() > lastestyear) {   //isFriendsWith method in Colleague
                bestFriend = friend;
            }// in case of ties 
            else if (c.isFriendsWith(friend) && friend.numFriends() == lowestDegree && shareInterest) {   
                bestFriend = friend;
            }
        }

        return bestFriend;
    }
}
