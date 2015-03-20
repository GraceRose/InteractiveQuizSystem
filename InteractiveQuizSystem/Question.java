/**
 * This class represents a Question
 * @author Grace Rosenvall
 */
public class Question{
    protected String question = "";
    protected String answer = "";
    protected String source = "";
    protected int pointVal = 0;
    protected boolean isCorrect = false;
    /**
     * This creates a question
     * @param q the question
     * @param a the answer to said question
     * @param s the source to said question
     * @param p the point value of said question
     */
    public Question(String q, String a, String s, int p){
        question = q;
        answer = a;
        source = s;
        pointVal = p;
    }
    
    /**
     * This returns the question
     * @return the question
     */
    public String getQuestion(){
        return question;
    }
    
    /**
     * This returns the answer
     * @return the answer
     */
    public String getAnswer(){
        return answer;
    }
    
    /**
     * This returns the source
     * @return the source
     */
    public String getSource(){
        return source;
    }
    
    /**
     * This returns the point value
     * @return the point value
     */
    public int getPointVal(){
        return pointVal;
    }
    
    /**
     * This says if the question is correct
     * @param c if the question is correct
     */
    public void setCorrect(boolean c){
        isCorrect = c;
    }
}