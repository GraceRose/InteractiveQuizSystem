public class Question{
    protected String question = "";
    protected String answer = "";
    protected String source = "";
    protected int pointVal = 0;
    protected boolean isCorrect = false;
    public Question(String q, String a, String s, int p){
        question = q;
        answer = a;
        source = s;
        pointVal = p;
    }
    public String getQuestion(){
        return question;
    }
    public String getAnswer(){
        return answer;
    }
    public String getSource(){
        return source;
    }
    public int getPointVal(){
        return pointVal;
    }
    public void setCorrect(boolean c){
        isCorrect = c;
    }
}