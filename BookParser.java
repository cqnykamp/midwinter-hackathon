import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

import java.util.HashMap;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors


public class BookParser {

    public static void main(String[] args) {

        String filepath = "texts/AChristmasCarol.txt";

        HashMap<String, Integer> words = new HashMap<>();

        try {
            File myObj = new File(filepath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] split = myReader.nextLine().split(" ");

                String extraPunct = "!@#$%^&*()+~,.?\'\"[]";
                
                for(String word : split) {
                    String newWord = "";
                    for(int i=0; i<word.length(); i++) {
                        char c = word.charAt(i);
                        if(extraPunct.indexOf(c) != -1) {

                        } else {
                            newWord += c;
                        }
                    }

                    if(newWord != "") {
                        if(words.containsKey(newWord)) {
                            words.put(newWord, words.get(newWord) + 1);
                        } else {
                            words.put(newWord, 1);
                        }

                    }

                }
                // System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("words.txt");
            // myWriter.write("Files in Java might be tricky, but it is fun enough!");

            for(String word : words.keySet()) {
                myWriter.write(word + " " + words.get(word) + "\n");
                // System.out.println();
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
    
}
