import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class FileReader {
    // Reads the colleagues from the given file and returns a BST containing them
    public static BST readColleagues(String filename) {     
        BST bst = new BST();
        
        try {       // Try to open the file
            Scanner scanner = new Scanner(new File(filename));
            
            while (scanner.hasNextLine()) {    // Read each line of the file
                String line = scanner.nextLine();
                String[] fields = line.split(";");  // Split the line into fields
                String tag = fields[0];
                String[] dateFields = fields[1].split("-"); // Split the date into year, month, and day
                int year = Integer.parseInt(dateFields[0]);
                int month = Integer.parseInt(dateFields[1]);
                int day = Integer.parseInt(dateFields[2]);
                ArrayList<String> interests = new ArrayList<String>(Arrays.asList(fields[2].split(",")));   // Split the interests into an ArrayList
                
                Colleague colleague = new Colleague(tag, year, month, day, interests);
                bst.insertColleague(colleague); // Insert the colleague into the BST
            }
            
            scanner.close();
            
        } catch (FileNotFoundException e) {    // Catch the exception if the file is not found
            System.out.println("File not found.");
            e.printStackTrace();
        }
        
        return bst;
    }
    
}
