import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class GraphMain {
    public static void main(String[] args) {
        BST colleagueBST = new BST();   //Here we have a empty BST
        ArrayList <String> interest1 = new ArrayList<>(Arrays.asList("programming", "reading"));
        ArrayList<String> interest2 = new ArrayList<>(Arrays.asList("sports", "movies"));
        ArrayList<String> interest3 = new ArrayList<>(Arrays.asList("cooking", "traveling","programming"));
        ArrayList<String> interest4 = new ArrayList<>(Arrays.asList("hiking", "photography","movies"));


        Colleague colleague1 = new Colleague("tika", 2022, 4, 30, interest1);
        Colleague colleague2 = new Colleague("misty", 2022, 4, 29, interest2);
        Colleague colleague3 = new Colleague("beetle", 2022, 4, 28, interest3);
        Colleague colleague4 = new Colleague("JoeMam", 2022, 4, 27, interest4);
        
        colleagueBST.insertColleague(colleague1);
        colleagueBST.insertColleague(colleague2);
        colleagueBST.insertColleague(colleague3);
        colleagueBST.insertColleague(colleague4);

        Graph colleagueGraph = new Graph("edges.txt",colleagueBST);

        // Print the BST to verify that it was populated correctly
        System.out.println("BST:");
        colleagueBST.printTree();

        


        // Test the findFriend method for a few colleagues
        System.out.println("Candidate friends:");
        Colleague c1 = colleagueBST.findColleague("HAR@tika");
        if (c1 != null) {
            Colleague friend1 = colleagueGraph.findFriend(c1.getUserName());
            if (friend1 != null) {
                System.out.println(friend1.getUserName());
            } else {
                System.out.println("No suitable friend found for " + c1.getUserName());
            }
        } else {
            System.out.println("Colleague not found: HAR@tika");
        }

        Colleague c2 = colleagueBST.findColleague("HAR@misty");
        if (c2 != null) {
            Colleague friend2 = colleagueGraph.findFriend(c2.getUserName());
            if (friend2 != null) {
                System.out.println(friend2.getUserName());
            } else {
                System.out.println("No suitable friend found for " + c2.getUserName());
            }
        } else {
            System.out.println("Colleague not found: HAR@misty");
        }

        Colleague c3 = colleagueBST.findColleague("HAR@beetle");
        if (c3 != null) {
            Colleague friend3 = colleagueGraph.findFriend(c3.getUserName());
            if (friend3 != null) {
                System.out.println(friend3.getUserName());
            } else {
                System.out.println("No suitable friend found for " + c3.getUserName());
            }
        } else {
            System.out.println("Colleague not found: HAR@beetle");
        }
    }
}
