import java.util.ArrayList;

public class BSTNodeMain {
    public static void main(String[] args) {
        ArrayList<String> interests = new ArrayList<String>();
        interests.add("Programming");
        interests.add("Reading");
        Colleague colleague = new Colleague("JoeMam", 2020, 6, 15, interests);
        BSTNode node = new BSTNode(colleague);
        
        System.out.println(node.getC().getUserName()); // output: HAR@JoeMam
        
        ArrayList<String> interests2 = new ArrayList<String>();
        interests2.add("Swimming");
        interests2.add("Traveling");
        Colleague colleague2 = new Colleague("Candice", 2022, 1, 1, interests2);
        BSTNode node2 = new BSTNode(colleague2);
        node.setL(node2);
        
        System.out.println(node.getL().getC().getUserName()); // output: HAR@Candice
    }
}
