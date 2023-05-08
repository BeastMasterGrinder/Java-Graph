public class BSTNode {
    private Colleague c;
    private BSTNode l;
    private BSTNode r;
    //Constructor
    public BSTNode(Colleague elem) {
        this.c = elem;
    }
    //Getters and Setters
    public Colleague getC() {
        return c;
    }
    
    public void setL(BSTNode l) {
        this.l = l;
    }
    
    public void setR(BSTNode r) {
        this.r = r;
    }
    
    public BSTNode getL() {
        return l;
    }
    
    public BSTNode getR() {
        return r;
    }
}
