package demo.src.main.java.com.example;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
public class Word
{
    private String word;
    private int occurences;
    private Text textObj;
    public static double fontSizeModifier=5;
    
    public Word(String word, int occurences)
    {
        this.word=word;
        this.occurences=occurences;
        textObj=new Text(word);
        double fontSize=(occurences*fontSizeModifier)+5;
        textObj.setFont(new Font("monospace", fontSize));
        textObj.setFill(Color.rgb((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256)));
        
        
        textObj.setX(Math.random()*500);
        textObj.setY(Math.random()*500);
    }
    public Text getTextObj()
    {
        return textObj;
    }
    public void setTextObjCoords(double x, double y)
    {
        textObj.setX(x);
        textObj.setY(y);
    }
    public void rotateTextObj()
    {
        textObj.setRotate(270);
    }
}
