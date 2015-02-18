import java.util.*;
/**
 * This class runs the IQS
 * @author Grace Rosenvall
 * last modded 12 Feb 2015
 */
public class Main{
    protected static int score;
    protected static String name;
    protected static Question test = new Question("What is the capital of Idaho?","Boise", "wikipedia.org");
    public static void main(String[] args){
        Scanner kbReader = new Scanner(System.in);
        boolean x = true;
        String input = "";
        score = 0;
        System.out.println("Hello and welcome to the Interactive Quiz System. I am Cora, your guide through this process. Please type your name.");
        input = kbReader.nextLine();
        name = input;
        System.out.println("Welcome to the IQS, " + name + "!" + "\nWhat would you like to do?");
        while(x){
            input = kbReader.nextLine();
            System.out.println("Your score is " + score);
            System.out.println("What would you like to do?");
            if(input.equalsIgnoreCase("exit")){
                x = false;
            }
            else if(input.equalsIgnoreCase("test")){
                askQuestion(test);
                input = kbReader.nextLine();
                checkAnswer(input, test);
            }
           
        }
    }
    public static void addScore(int p){
        score += p;
    }
    public static void askQuestion(Question quest){
        System.out.println(quest.getQuestion());
    }
    public static void checkAnswer(String i, Question quest){
        Scanner kbReader = new Scanner(System.in);
        if(i.equalsIgnoreCase(quest.getAnswer())){
            quest.setCorrect(true);
            addScore(2);
            System.out.println("That was correct! Would you like more information on this topic?");
            String input = kbReader.nextLine();
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