import java.util.HashMap;

public class Answers {
    public static void main(String[] args) {


    }

    public static HashMap<String, String> getAnswers() {
        HashMap<String, String> answers = new HashMap<String, String>();
        // K1 Answers
        answers.put("What is the capital of the UK?", "a) London");
        answers.put("Which is heavier a tonne of bricks or a tonne of feathers?", "c) Both weigh the same");
        answers.put("What is the capital of France?", "d) Paris");

        // K2 Answers
        answers.put("Which day of the week is named after the Norse god Tyr?", "c) Tuesday");
        answers.put("Which day of the week is named after the Norse god Odin?", "b) Wednesday");
        answers.put("Which day of the week is named after the Norse god Frigg?", "d) Friday");
        return answers;
    };

}
