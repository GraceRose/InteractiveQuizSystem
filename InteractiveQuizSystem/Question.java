public class Question{
    protected String question = "";
    protected String answer = "";
    protected boolean isCorrect = false;
    public Question(String q, String a){
        question = q;
        answer = a;
    }
    public String getQuestion(){
        return question;
    }
    public String getAnswer(){
        return answer;
    }
    public void setCorrect(boolean c){
        isCorrect = c;
    }
}