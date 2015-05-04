public class DefaultQuestions{
    protected static Question[] defQuest = new Question[5];
    protected static Question test1 = new Question("What is the capital of Idaho?","Boise", "http://en.wikipedia.org/wiki/Boise,_Idaho", 2);
    protected static Question test2 = new Question("In which state is the highest point in the United States?","Alaska","http://en.wikipedia.org/wiki/Mount_McKinley",2);
    protected static Question test3 = new Question("Which state contains the Great Salt Lake?","Utah","http://en.wikipedia.org/wiki/Utah",2);
    protected static Question test4 = new Question("The only non-rectangular shaped flag belongs to what country?","Nepal","http://en.wikipedia.org/wiki/Nepal",2);
    protected static Question test5 = new Question("What state is the FRC team 254 from?","California","team254.com/",2);
    protected static String[] answers = new String[5];
    public void fillArray(){
        defQuest[0] = test1;
        defQuest[1] = test2;
        defQuest[2] = test3;
        defQuest[3] = test4;
        defQuest[4] = test5;
    }
    public static Question[] getArray(){
        return defQuest;
    }
    public static void addAnswer(String a, int i){
        answers[i-1] = a;
    }
    public static Question getQuestion(int i){
        return defQuest[i-1];
    }
    public static String getAnswer(int i){
        return answers[i];
    }
}