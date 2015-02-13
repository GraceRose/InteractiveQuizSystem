/**
 * This class runs the IQS
 * @author Grace Rosenvall
 * last modded 12 Feb 2015
 */
public class Main{
    public static void main(String[] args){
    }
    public static void addScore(int p){
    }
    public static void checkAnswer(String input, Question quest){
        if(input.equalsIgnoreCase(quest.getAnswer())){
            quest.setCorrect(true);
            addScore(2);
            System.out.println("That was correct!");
        }
    }
}