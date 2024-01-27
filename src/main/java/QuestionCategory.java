import java.util.HashMap;
import java.util.ArrayList;
public class QuestionCategory {
    public static void main(String[] args) {

    }
    // Getter method with the options in it
    public static HashMap<String, String> getCategory() {
        HashMap<String, String> category = new HashMap<String, String>();
        //K1 Question categories
        category.put("What is the capital of the UK?", "General trivia");
        category.put("Which is heavier a tonne of bricks or a tonne of feathers?", "General trivia");
        category.put("What is the capital of France?", "General trivia");
        //K2 Question categories
        category.put("Which day of the week is named after the Norse god Tyr?", "Norse Mythology");
        category.put("Which day of the week is named after the Norse god Odin?", "Norse Mythology");
        category.put("Which day of the week is named after the Norse god Frigg?", "Norse Mythology");
        return category;
    };
}
