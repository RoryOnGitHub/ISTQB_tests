import java.util.HashMap;
import java.util.ArrayList;
public class QuestionOptions {
    public static void main(String[] args) {

    }
    // Getter method with the options in it
    public static HashMap<String, String[]> getOptions() {
        HashMap<String, String[]> options = new HashMap<String, String[]>();
        //K1 Question options
        options.put("What is the capital of the UK?", new String[] {"A: London", "B: Berlin", "C: Oslo", "D: Washington DC"});
        options.put("Which is heavier a tonne of bricks or a tonne of feathers?", new String[] {"A: Bricks","B: Feathers","C: Both weigh the same", "D: Eggs"});
        options.put("What is the capital of France?", new String[] {"A: London","B: Berlin","C: Oslo","D: Paris"});
        //K2 Question options
        options.put("Which day of the week is named after the Norse god Tyr?", new String[] {"A: Thursday", "B: Wednesday", "C: Tuesday", "D: Monday"});
        options.put("Which day of the week is named after the Norse god Odin?", new String[] {"A: Friday","B: Wednesday","C: Monday", "D: Saturday"});
        options.put("Which day of the week is named after the Norse god Frigg?", new String[] {"A: Sunday","B: Tuesday","C: Wednesday","D: Friday"});
        return options;
    };
}
