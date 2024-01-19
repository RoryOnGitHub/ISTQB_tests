import java.util.HashMap;
import java.util.ArrayList;
public class QuestionOptions {
    public static void main(String[] args) {

    }
    // Getter method with the options in it
    public static HashMap<String, String[]> getOptions() {
        HashMap<String, String[]> options = new HashMap<String, String[]>();
        options.put("What is the capital of the UK?", new String[] {"A: London", "B: Berlin", "C: Oslo", "D: Washington DC"});
        options.put("Which is heavier a tonne of bricks or a tonne of feathers?", new String[] {"A: Bricks","B: Feathers","C: Both weigh the same", "D: Eggs"});
        options.put("What is the capital of France?", new String[] {"A: London","B: Berlin","C: Oslo","D: Paris"});
        return options;
    };
    // Change the second String to Array to store an array?
}
