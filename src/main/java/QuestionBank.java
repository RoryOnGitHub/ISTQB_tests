import java.util.HashMap;
public class QuestionBank {
    public static void main(String[] args) {

    }
    static String[] k1_questions = {
            "What is the capital of the UK?",
            "Which is heavier a tonne of bricks or a tonne of feathers?",
            "What is the capital of France?"
    };

    static String[] k2_questions = {
            "Which day of the week is named after the Norse god Tyr?",
            "Which day of the week is named after the Norse god Odin?",
            "Which day of the week is named after the Norse god Frigg?"
    };

    public static HashMap<String, String[]> getQuestionsBySubject() {
        HashMap<String, String[]> subjects = new HashMap<String, String[]>();
        subjects.put("General_trivia", getK1_questions());
        subjects.put("Norse", getK2_questions());
        return subjects;
    }

    // Using a getter to return the array to another class
    public static String[] getK1_questions() {
        return k1_questions.clone();
    }
    public static String[] getK2_questions() {
        return k2_questions.clone();
    }
}
