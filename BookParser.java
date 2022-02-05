import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

import java.util.HashMap;

public class BookParser {

    public static void main(String[] args) {

        String filepath = "texts/AChristmasCarol.txt";

        HashMap<String, Integer> words = new HashMap<>();

        try {
            File myObj = new File(filepath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] split = myReader.nextLine().split(" ");
                
                for(String word : split) {
                    if(words.containsKey(word)) {
                        words.put(word, words.get(word) + 1);
                    } else {
                        words.put(word, 1);
                    }
                }
                // System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for(String word : words.keySet()) {
            System.out.println(word + " " + words.get(word));
        }
    }
    
}
