import java.util.*;
/**
 * This class runs the IQS
 * @author Grace Rosenvall
 * last modded 12 Feb 2015
 */
public class Main{
    protected static int score;
    protected static String name;
    
    public static void main(String[] args){
        Scanner kbReader = new Scanner(System.in);
        String input = "";
        score = 0;
        System.out.println("Hello and welcome to the Interactive Quiz System. I am Cora, your guide through this process. Please type your name.");
        input = kbReader.nextLine();
        name = input;
        System.out.println("Welcome to the IQS, " + name + "!");
        
    }
    public static void addScore(int p){
        score += p;
    }
    public static void checkAnswer(String input, Question quest){
        Scanner kbReader = new Scanner(System.in);
        if(input.equalsIgnoreCase(quest.getAnswer())){
            quest.setCorrect(true);
            addScore(2);
            System.out.println("That was correct! Would you like more information on this topic?");
            input = kbReader.nextLine();
            if(input.equalsIgnoreCase("yes")){
                System.out.println("Here is the link to the Wikipedia article with more information:");
                System.out.println(quest.getSource());
            }
        }
        else{
            System.out.println("I'm sorry, that was not correct. Here is the link to the Wikipedia article with more information:");
            System.out.println(quest.getSource());
        }
    }
}