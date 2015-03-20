import java.util.*;
/**
 * This class creates Entered Questions
 * @author Grace Rosenvall
 */
public class EnteredQuestions{
    ArrayList<Question> eQ = new ArrayList<Question>();
    /**
     * This creates new entered questions
     * @param q the question
     * @param a the answer
     * @param s the source
     * @param p the point value
     */
    public void add(String q, String a, String s, int p){
        Question k = new Question(q,a,s,p);
        eQ.add(k);
    }
}