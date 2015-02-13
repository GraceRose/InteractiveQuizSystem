public class Question{
    protected String question = "";
    protected String answer = "";
    protected String source = "";
    protected boolean isCorrect = false;
    public Question(String q, String a, String s ){
        question = q;
        answer = a;
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
    public void setCorrect(boolean c){
        isCorrect = c;
    }
}