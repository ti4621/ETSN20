import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StringSearch {
	
    public static void main(String[] args) {
        new StringSearch().run(args);
    }
    
    /*
     * The run method that controls the flow of the program
     * @param args - arguments from the command line
     * @return nothing
     */
    public void run(String[] args) {
        if(args[0].equals("search")) {
        	readFile(args[2], args[1]);
        }else {
        	 System.out.println("Invalid input");
        }
    }
 

    /*
     * Reads file
     * @param fileName name of file
     * @param searchName
     * @return nothing
     */
    public void readFile(String fileName, String searchName){
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              searchLine(data, searchName);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
          }
    }
    
    /*
     * Search for seachName in the string data and prints if searchName exists
     * @param data the line of information
     * @param searchName the word to search for
     * @return nothing
     */
    public void searchLine(String data, String searchName){
        String[] line = data.split(" ");
        for (var word : line){
            if (word.equals(searchName)){
                System.out.println(data);
            }
        }
    }

}

    
