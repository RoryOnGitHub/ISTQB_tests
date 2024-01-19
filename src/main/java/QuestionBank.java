public class QuestionBank {
    public static void main(String[] args) {

    }
    static String[] k1_questions = {
            "What is the capital of the UK?",
            "Which is heavier a tonne of bricks or a tonne of feathers?",
            "What is the capital of France?"
    };
    // Using a getter to return the array to another class
    public static String[] getK1_questions() {
        return k1_questions.clone();
    }
}
