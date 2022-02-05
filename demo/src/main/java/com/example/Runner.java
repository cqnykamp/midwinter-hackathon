package demo.src.main.java.com.example;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.HashMap;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Runner extends Application
{
    public HashMap<String, Integer> fileToWordMap(String filename)
    {
        HashMap<String, Integer> wordOccurences=new HashMap<String, Integer>();
        try(BufferedReader bRead=new BufferedReader(new FileReader(filename)))
        {
            Scanner fileScanner=new Scanner(bRead);
            int minOccurences=Integer.MAX_VALUE;
            int maxOccurences=0;
            while(fileScanner.hasNext())
            {
                String line=fileScanner.nextLine();
                String word=line.substring(0, line.indexOf(" "));
                int occurences=Integer.parseInt(line.substring(line.indexOf(" ")+1));
                if(occurences<minOccurences)
                    minOccurences=occurences;
                if(occurences>maxOccurences)
                    maxOccurences=occurences;
                wordOccurences.put(word, occurences);
            }
        }
        catch(IOException e)
        {
            System.out.println("error reading the file :(");
        }
        return wordOccurences;
    }
    public void start(Stage stage)
    {
        HashMap<String, Integer> stringsAndOccurences=new HashMap<String, Integer>();
        int minOccurences=Integer.MAX_VALUE;
        int maxOccurences=0;
        try(BufferedReader bRead=new BufferedReader(new FileReader("book.txt")))
        {
            Scanner fileScanner=new Scanner(bRead);
            while(fileScanner.hasNext())
            {
                String line=fileScanner.nextLine();
                String word=line.substring(0, line.indexOf(" "));
                int occurences=Integer.parseInt(line.substring(line.indexOf(" ")+1));
                if(occurences<minOccurences)
                    minOccurences=occurences;
                if(occurences>maxOccurences)
                    maxOccurences=occurences;
                stringsAndOccurences.put(word, occurences);
            }
        }
        catch(IOException e)
        {
            System.out.println("error reading the file :(");
        }
        Word.fontSizeModifier=((maxOccurences-minOccurences)/20);
        
        ArrayList<Word> words=new ArrayList<Word>();
        for(String str:stringsAndOccurences.keySet())
        {
            words.add(new Word(str, stringsAndOccurences.get(str)));
        }
        
        //System.out.println(test.getTextObj().getBoundsInParent());
        
        Group root=new Group();
        for(Word word:words)
            root.getChildren().add(word.getTextObj());
        root.setId("root");
        stage.setTitle("Word Cloud");
        Scene scene=new Scene(root, 600, 600);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args)
    {
        launch();
    }
}
