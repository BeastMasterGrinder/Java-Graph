import java.util.ArrayList;

public class BST {
    private BSTNode root;
    
    
    //Recursive Helper function for inserting a colleague into the BST
    private void HelperFunction(BSTNode current, BSTNode newNode) {
        //if the new colleague's tag's first letter is less than the current colleague's tag's first letter
        //keeping in mind the case of the letters
        if(Character.toLowerCase(newNode.getC().getTag().charAt(0)) < Character.toLowerCase(current.getC().getTag().charAt(0)) || (Character.toLowerCase(newNode.getC().getTag().charAt(0)) == Character.toLowerCase(current.getC().getTag().charAt(0)) && Character.toLowerCase(newNode.getC().getTag().charAt(1)) < current.getC().getTag().charAt(1))) {
            if(current.getL() == null) {       //if left child is null
                current.setL(newNode);
                // current.getC().count++;
            }
            else {
                HelperFunction(current.getL(), newNode);
            }
        }
        else {
            if(current.getR() == null) {       //if right child is null
                current.setR(newNode);
                // current.getC().count++;
            }
            else {
                HelperFunction(current.getR(), newNode);
            }
        }
    }
    //Private function for printing the BST in order
    private void printTree(BSTNode node) {
        if (node != null) {
            printTree(node.getL());
            System.out.println(node.getC());
            printTree(node.getR());
        }
    }
    //Private function for printing the BST in reverse alphabetical order
    private void reverseAlphabeticTraversal(BSTNode node, StringBuilder string_builder) {
        if (node != null) { // if not at a leaf
            reverseAlphabeticTraversal(node.getR(), string_builder);    // traverse the right subtree
            string_builder.append(node.getC().getUniqueUserName() + "\n");  // append the colleague's unique username to the string
            reverseAlphabeticTraversal(node.getL(), string_builder);    // traverse the left subtree
        }
    }
    //Constructor
    public BST() {
        root = null;
    }
    //Inserting a colleague into the BST
    public void insertColleague(Colleague c) {
        BSTNode newNode = new BSTNode(c);
        newNode.getC().getUniqueUserName();
        if (root == null) {
            root = newNode;
        } else {
            HelperFunction(root, newNode);
        }
    }
    
    
    //Inorder traversal of Tree
    public void printTree() {
        if (root == null) {
            System.out.println("Tree is empty.");
        } else {
            printTree(root);
        }
    }
    
    
    
    //Step 5 reversing the alphabetical order
    public String printReverseAlphabetic() {
        StringBuilder string_builder = new StringBuilder();
        reverseAlphabeticTraversal(this.root, string_builder);
        return string_builder.toString();
    }

    


    //Step 6    Graphs and Finding Freinds!!
    public Colleague findColleague(String username) {
        BSTNode current = root;
        while (current != null) {   // while not at a leaf
            if (username.compareTo(current.getC().getUserName()) == 0) {    // if the username matches
                return current.getC();
            } else if (username.compareTo(current.getC().getUserName()) < 0) {  // if the username is less than the current colleague's username
                current = current.getL();
            } else {
                current = current.getR();
            }
        }
        return null; // colleague not found
    }
    //Step 6    Graphs and Finding Freinds!!
    public ArrayList<Colleague> getColleagueFriends(Colleague col) {
        ArrayList<Colleague> friends = new ArrayList<>();
        for (Colleague friend : col.getFriends()) { // for each friend of the colleague
            Colleague foundFriend = findColleague(friend.getUserName());    // find the friend in the BST
            if (foundFriend != null) {  // if the friend is in the BST
                friends.add(foundFriend);   // add the friend to the list of friends
            }
        }
        return friends;
    }
    
}
