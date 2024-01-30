import java.util.HashMap;
import java.util.ArrayList;
public class QuestionOptions {
    public static void main(String[] args) {

    }
    // Getter method with the options in it
    public static HashMap<String, String[]> getOptions() {
        HashMap<String, String[]> options = new HashMap<String, String[]>();
        //K1 Question options
        options.put("What is the capital of the UK?", new String[] {"a) London", "b) Berlin", "c) Oslo", "d) Washington DC"});
        options.put("Which is heavier a tonne of bricks or a tonne of feathers?", new String[] {"a) Bricks","b) Feathers","c) Both weigh the same", "d) Eggs"});
        options.put("What is the capital of France?", new String[] {"a) London","b) Berlin","c) Oslo","d) Paris"});
        //K2 Question options
        options.put("Which day of the week is named after the Norse god Tyr?", new String[] {"a) Thursday", "b) Wednesday", "c) Tuesday", "d) Monday"});
        options.put("Which day of the week is named after the Norse god Odin?", new String[] {"a) Friday","b) Wednesday","c) Monday", "d) Saturday"});
        options.put("Which day of the week is named after the Norse god Frigg?", new String[] {"a) Sunday","b) Tuesday","c) Wednesday","d) Friday"});
        return options;
    };
}
