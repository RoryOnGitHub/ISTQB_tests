import java.util.HashMap;

public class Answers {
    public static void main(String[] args) {


    }

    public static HashMap<String, String> getAnswers() {
        HashMap<String, String> answers = new HashMap<String, String>();
        // K1 Answers
        answers.put("What is the capital of the UK?", "A: London");
        answers.put("Which is heavier a tonne of bricks or a tonne of feathers?", "C: Both weigh the same");
        answers.put("What is the capital of France?", "D: Paris");

        // K2 Answers
        answers.put("Which day of the week is named after the Norse god Tyr?", "C: Tuesday");
        answers.put("Which day of the week is named after the Norse god Odin?", "B: Wednesday");
        answers.put("Which day of the week is named after the Norse god Frigg?", "D: Friday");
        return answers;
    };

}
