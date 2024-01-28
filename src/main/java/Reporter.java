import java.util.HashMap;

public class Reporter {

        public static void main(String[] args) {

        }
        // The report will show number of tries per question, the answer and where to focus your study
        // The report will point out the areas to focus on
        // The report will then compile this and output it into a txt file (to chosen destination)

        public static void questionStatsPrinter(HashMap<Integer, String[]> mapOfResults) {
                mapOfResults.forEach((key, value) -> System.out.printf(
                        "---------------------------------------------------------------------------------\n" +
                        "Question %s: %s\n-Number of incorrect tries: %s\n-Category of question: %s\n-Answer: %s", key, value[0], value[1], value[2], Answers.getAnswers().get(value[0]) +
                        "\n---------------------------------------------------------------------------------\n"
                ));
        }

        public static void incorrectAttemptPerCat(HashMap<String, Integer> categoryAttempts) {
                categoryAttempts.forEach((key, value) -> System.out.printf(
                        "Category |%s| Incorrect attempts |%s|\n", key, value)
                );
        }
}


