public class FileReaderMain {
    
    public static void main(String[] args) {
        BST bst = FileReader.readColleagues("colleagues (2).txt");
        
        
        bst.printTree();
    }
    
}
