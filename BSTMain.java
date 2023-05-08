import java.util.ArrayList;
import java.util.Arrays;

public class BSTMain {
    public static void main(String[] args) {
        BST binary_search_tree = new BST();
        
        ArrayList <String> interest1 = new ArrayList<>(Arrays.asList("music", "reading"));
        ArrayList<String> interest2 = new ArrayList<>(Arrays.asList("sports", "movies"));
        ArrayList<String> interest3 = new ArrayList<>(Arrays.asList("cooking", "traveling"));
        ArrayList<String> interest4 = new ArrayList<>(Arrays.asList("hiking", "photography"));


        Colleague colleague1 = new Colleague("LynConway", 2022, 4, 30, interest1);
        Colleague colleague2 = new Colleague("tika", 2022, 4, 29, interest2);
        Colleague colleague3 = new Colleague("litfried", 2022, 4, 28, interest3);
        // Colleague colleague4 = new Colleague("user4", 2022, 4, 27, interest4);
        
        binary_search_tree.insertColleague(colleague1);
        binary_search_tree.insertColleague(colleague2);
        binary_search_tree.insertColleague(colleague3);
        // binary_search_tree.insertColleague(colleague4);

        //verify that it was populated correctly
        System.out.println("BST:");
        binary_search_tree.printTree();



        // for(int i = 0; i < binary_search_tree.().size(); i++){
        //     //print the string returned from printReverseAlphabetic
        //     System.out.println(binary_search_tree.printReverseAlphabetic());
        //     // binary_search_tree.printReverseAlphabetic();
        // }
    }
}
