import java.util.*;
public class EnteredQuestions{
    ArrayList<Question> eQ = new ArrayList<Question>();
    public void add(String q, String a, String s, int p){
        Question k = new Question(q,a,s,p);
        eQ.add(k);
    }
}