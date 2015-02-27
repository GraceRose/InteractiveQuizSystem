import java.util.*;
/**
 * This class runs the IQS
 * @author Grace Rosenvall
 * last modded 12 Feb 2015
 */
public class Main{
    protected static int score;
    protected static String name;
    protected static Question test1 = new Question("What is the capital of Idaho?","Boise", "wikipedia.org", 2);
    protected static Question test2 = new Question("In which state is the highest point in the United States?","Alaska","wikipedia.org",2);
    protected static Question test3 = new Question("Which state contains the Great Salt Lake?","Utah","wikipedia.org",2);
    protected static Question test4 = new Question("The only non-rectangular shaped flag belongs to what country?","Nepal","wikipedia.org",2);
    protected static Question test5 = new Question("What state is the FRC team 254 from?","California","wikipedia.org",2);
    public static void main(String[] args){
        Scanner kbReader = new Scanner(System.in);
        boolean x = true;
        String input = "";
        score = 0;
        System.out.println("Hello and welcome to the Interactive Quiz System. I am Cora, your guide through this process. Please type your name.");
        input = kbReader.nextLine();
        name = input;
        System.out.println("Welcome to the IQS, " + name + "! Press enter to start.");
        while(x){
            input = kbReader.nextLine();
            System.out.println("Your score is " + score);
            System.out.println("What would you like to do?");
            if(input.equalsIgnoreCase("exit")){
                System.out.println("Oh right you want to leave. Fine.");
                x = false;
            }
            
            if(input.equalsIgnoreCase("fact")){
                System.out.println("This statement is false");
            }
            if(input.equalsIgnoreCase("create")){

            }

            if(input.equalsIgnoreCase("test")){
                /*
                askQuestion(test);
                input = kbReader.nextLine();
                checkAnswer(input, test);
                */
               test();
            }

        }
    }
    
    public static void test(){
        Scanner kbReader = new Scanner(System.in);
        askQuestion(test1);
        String input = kbReader.nextLine();
        checkAnswer(input,test1);
        askQuestion(test2);
        input = kbReader.nextLine();
        checkAnswer(input,test2);
        askQuestion(test3);
        input = kbReader.nextLine();
        checkAnswer(input,test3);
        askQuestion(test4);
        input = kbReader.nextLine();
        checkAnswer(input,test4);
        askQuestion(test5);
        input = kbReader.nextLine();
        checkAnswer(input,test5);
        
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
            addScore(quest.getPointVal());
            System.out.println("That was correct! Would you like more information on this topic?");
            String input = kbReader.nextLine();
            if(input.equalsIgnoreCase("yes")){
                System.out.println("Here is the link to the Wikipedia article with more information:");
                System.out.println(quest.getSource());
                System.out.println("Press enter to move on to the next question.");

            }

        }
        else{
            System.out.println("I'm sorry, that was not correct. Here is the link to the Wikipedia article with more information:");
            System.out.println(quest.getSource());
        }
    }
}