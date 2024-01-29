import java.util.ArrayList;
import java.util.HashMap;

public class Reporter {

        public static void main(String[] args) {

        }
        // The report will show number of tries per question, the answer and where to focus your study
        // The report will point out the areas to focus on
        // The report will then compile this and output it into a txt file (to chosen destination)

        public static void questionStatsPrinter(HashMap<Integer, String[]> mapOfResults) {
                mapOfResults.forEach((key, value) -> System.out.printf(
                        "----------------------------------------------------------------\n" +
                        "Question %s: %s\n-Number of incorrect tries: %s\n-Category of question: %s\n-Answer: %s", key, value[0], value[1], value[2], Answers.getAnswers().get(value[0]) +
                        "\n----------------------------------------------------------------\n"
                ));
        }

        public static void incorrectAttemptPerCat(HashMap<String, Integer> categoryAttempts, HashMap<String, Integer> questionsPerCategory, int totalQuestions) {
                TestRunner.seperatorPrinter(1);
                TestRunner.headerPrinter("General stats");
                TestRunner.seperatorPrinter(1);
                System.out.printf("--Total questions |%s|\n", Integer.toString(totalQuestions));
                TestRunner.seperatorPrinter(1);
                questionsPerCategory.forEach((key, value) -> System.out.printf(
                        "--Category |%s|\nTotal questions in this category |%s|\n", key, value
                ));
                TestRunner.seperatorPrinter(1);
                TestRunner.headerPrinter("Results breakdown");
                TestRunner.seperatorPrinter(1);
                categoryAttempts.forEach((key, value) -> System.out.printf(
                        "--Category |%s|\nIncorrect attempts |%s| out of possible total attempts of |%s|\n", key, value, questionsPerCategory.get(key) * 3)
                );
        }

        public static void categoryStats(ArrayList<String> result, HashMap<String, Integer> attemptsPerCategory, HashMap<String, Integer> questionsPerCategory, ArrayList<Integer> split) {
                int index = 0;
                for (String i: result) {
                        attemptsPerCategory.put(i, 0);
                        questionsPerCategory.put(i, split.get(index));
                        index++;
                }
        }
}


