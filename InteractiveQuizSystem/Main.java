import java.util.*;
import java.io.*;
/**
 * This class runs the IQS
 * @author Grace Rosenvall
 * last modded 17 Apr 2015
 */
public class Main{
    protected static int score;
    protected static String name;
    protected static Question test1 = new Question("What is the capital of Idaho?","Boise", "http://en.wikipedia.org/wiki/Boise,_Idaho", 2);
    protected static Question test2 = new Question("In which state is the highest point in the United States?","Alaska","http://en.wikipedia.org/wiki/Mount_McKinley",2);
    protected static Question test3 = new Question("Which state contains the Great Salt Lake?","Utah","http://en.wikipedia.org/wiki/Utah",2);
    protected static Question test4 = new Question("The only non-rectangular shaped flag belongs to what country?","Nepal","http://en.wikipedia.org/wiki/Nepal",2);
    protected static Question test5 = new Question("What state is the FRC team 254 from?","California","team254.com/",2);
    protected static String FileName = "";
    protected static String FileNameR = "";
    protected static boolean infPoints = true;
    public static ArrayList<String> storedAnswer = new ArrayList<String>();
    /**
     * This method runs the Interactive Quiz System
     * @param args not used
     */
    public static void main(String[] args){
        Main main = new Main();
        Scanner kbReader = new Scanner(System.in);
        boolean x = true;
        
        String input = "";
        score = 0;
        System.out.println("Hello and welcome to the Interactive Quiz System. Please type your name.");
        input = kbReader.nextLine();
        name = input;
        System.out.println("Welcome to the IQS, " + name + "!");
        EnteredQuestions eQu = new EnteredQuestions();
        while(x){
            System.out.println(" ");
            System.out.println("Your score is " + score);
            System.out.println("What would you like to do?");
            input = kbReader.nextLine();
            if(input.equalsIgnoreCase("exit")){
                System.out.println("You want to leave....WHY???????...Fine.");
                x = false;
            }
            if(input.equalsIgnoreCase("help")){
                System.out.println("These are your commands: ");
                System.out.println("This feature is still coming.");
            }
            if(input.equalsIgnoreCase("fact")){
                System.out.println("This statement is false");
                addScoreSpecial(5);
            }
            if(input.equalsIgnoreCase("export")){
                try{                
                    exportAsHTML();
                }
                catch(IOException e){
                    e.printStackTrace();
                    System.exit(1);
                }
                System.out.println("What would you like to name the file?");
                FileName = kbReader.nextLine();
                //FileName = input;
                System.out.println("Stats have been exported");
            }
            if(input.equalsIgnoreCase("bologna")){
                System.out.println("It's as easily pronounceable as COLONEL!");                
            }
            if(input.equalsIgnoreCase("test")){
                test();
            }
            if(input.equalsIgnoreCase("create")){
                int p;
                System.out.println("What is the question?");
                input = kbReader.nextLine();
                String q = input;
                System.out.println("What is the answer?");
                input = kbReader.nextLine();
                String a = input;
                System.out.println("Source?");
                input = kbReader.nextLine();
                String s = input;
                System.out.println("Point value?");
                input = kbReader.nextLine();
                if(input.equalsIgnoreCase("default")){
                    p = 2;
                }
                else{
                    p = 1;
                }
                Question create = new Question(q,a,s,p);
                eQu.add(q,a,s,p);
                System.out.println("Would you like to hear your question?");
                input = kbReader.nextLine();
                if(input.equalsIgnoreCase("yes")){
                    askQuestion(create);
                    input = kbReader.nextLine();
                    checkAnswer(input, create);
                }
                
            }
            if(input.equalsIgnoreCase("Save Questions")){
                
                try{                
                    exportQuestionsAsHTML();
                }
                catch(IOException e){
                    e.printStackTrace();
                    System.exit(1);
                }
                System.out.println("What would you like to name the file?");
                input = kbReader.nextLine();
                FileNameR = input;
                System.out.println("Questions have been exported");
                
                
            }

        }
    }

    /**
     * This runs the testing portion of the program
     */
    public static void test(){
        Scanner kbReader = new Scanner(System.in);
        //    for(int i = 0; i< 5;i++){
        askQuestion(test1);
        String input = kbReader.nextLine();
        checkAnswer(input,test1);
        // }
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

    /**
     * This adds to the score
     * @param p the score to add to the score
     */
    public static void addScore(int p){
        score += p;
    }
    
    public static void addScoreSpecial(int p){
        if(infPoints != false){
            score += p; 
            infPoints = false;
        }
    }

    /**
     * This asks the question
     * @param quest the question to be asked
     */
    public static void askQuestion(Question quest){
        System.out.println(quest.getQuestion());
    }

    /**
     * This checks the question's answer
     * @param i the input String
     * @param quest the quetion with the answer
     */
    public static void checkAnswer(String i, Question quest){
        Scanner kbReader = new Scanner(System.in);
        if(i.equalsIgnoreCase(quest.getAnswer())){
            quest.setCorrect(true);
            addScore(quest.getPointVal());
            System.out.println("That was correct! Would you like more information on this topic?");
            String input = kbReader.nextLine();
            if(input.equalsIgnoreCase("yes")){
                System.out.println("Here is the link to a totally not suspicious webpage with more information:");
                System.out.println(quest.getSource());
                //System.out.println("Press enter to move on to the next question.");

            }

        }
        else{
            System.out.println("I'm sorry, that was not correct. The correct answer is: " + quest.getAnswer());
            System.out.println("Here is the link to a totally not suspicious webpage with more information:");
            System.out.println(quest.getSource());
        }
    }

    /**
     * This exports the file to an HTML file
     */
    public static void exportAsHTML()throws IOException{
        File f = new File(FileName + ".html");
        FileWriter fw = new FileWriter(f);
        PrintWriter pw = new PrintWriter(fw);
        pw.println("<!DOCTYPE.html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title> Your Results </title>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<h1>Your Results:</h1>");
        pw.println("<hr/>");
        
        pw.println("<li>" +score + " points" + "</li>");
        for(int i = 0;i < DefaultQuestions.getArray().length;i++){
            pw.println("<li>" + "Question: You have not paid for this feature yet."+ "</li>");
            pw.println("<li>" + "Correct Answer: You have not paid for this feature yet."+ "</li>");
            pw.println("<li>" + "Your Answer: You have not paid for this feature yet."+ "</li>");
            pw.println("<li>" + "Source: You have not paid for this feature yet."+ "</li>");
            pw.println("<li></li>");
            /*
             * pw.println("Question: " + DefaultQuestions.getQuestion(i+1).getQuestion());
            pw.println("Correct Answer: " + DefaultQuestions.getQuestion(i+1).getAnswer());
            pw.println("Your Answer: " + storedAnswer.get(i));
            pw.println("Source: " + DefaultQuestions.getQuestion(i+1).getSource());
             * */
             
        }
        
        pw.println("</body>");
        pw.println("</html>");
        pw.close();
        fw.close();
    }
    /**
     * This exports questions as HTML
     */
    public static void exportQuestionsAsHTML()throws IOException{
        File f = new File("Questions.html");
        FileWriter fw = new FileWriter(f);
        PrintWriter pw = new PrintWriter(fw);
        pw.println("<!DOCTYPE.html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title> Your Questions: </title>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<h1>Your Questions:</h1>");
        pw.println("<hr/>");        
        for(int i = 0;i <EnteredQuestions.size();i++){            
            pw.println("Question: " + EnteredQuestions.getInd(i).getQuestion());
            pw.println("Correct Answer: " + EnteredQuestions.getInd(i).getAnswer());            
            pw.println("Source: " + EnteredQuestions.getInd(i).getSource());
            pw.println(" ");
        }        
        pw.println("</body>");
        pw.println("</html>");
        pw.close();
        fw.close();
    }
}