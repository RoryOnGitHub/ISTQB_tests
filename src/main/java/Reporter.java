import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Reporter {

        public static void main(String[] args) {

        }

        // Prints question results to console
        public static void questionStatsPrinter(HashMap<Integer, String[]> mapOfResults) {
                mapOfResults.forEach((key, value) -> System.out.printf(
                        "----------------------------------------------------------------\n" +
                        "Question %s: %s\n-Number of incorrect tries: %s\n-Category of question: %s\n-Answer: %s", key, value[0], value[1], value[2], Answers.getAnswers().get(value[0]) +
                        "\n----------------------------------------------------------------\n"
                ));
        }

        // Writes question results to txt file
        public static String questionStatsWriter(HashMap<Integer, String[]> mapOfResults) {
                String output = "";
                for (Map.Entry<Integer, String[]> entry : mapOfResults.entrySet()) {
                        Integer key = entry.getKey();
                        String[] value = entry.getValue();
                        output += String.format("----------------------------------------------------------------\n" +
                        "Question %s: %s\n-Number of incorrect tries: %s\n-Category of question: %s\n-Answer: %s" +
                        "\n----------------------------------------------------------------\n", key, value[0], value[1], value[2], Answers.getAnswers().get(value[0]));
                }
                return output;
        }
        // Prints stats breakdown to console, taking in the HashMaps of attemptsPerCategory and questionsPerCategory as well as total questions and from this shows general stats and their breakdown
        public static void resultsBreakdown(HashMap<String, Integer> categoryAttempts, HashMap<String, Integer> questionsPerCategory, int totalQuestions) {
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
        // Writes stats breakdown to txt file
        public static String resultsBreakdownWriter(HashMap<String, Integer> categoryAttempts, HashMap<String, Integer> questionsPerCategory, int totalQuestions) {
                String output = "";
                output += seperatorWriter(1);
                output += headerWriter("General stats");
                output += seperatorWriter(1);
                output += String.format("--Total questions |%s|\n", Integer.toString(totalQuestions));
                output += seperatorWriter(1);
                for (Map.Entry<String, Integer> entry : questionsPerCategory.entrySet()) {
                        String key = entry.getKey();
                        Integer value = entry.getValue();
                        output += String.format("--Category |%s|\nTotal questions in this category |%s|\n", key, value);
                }
                output += seperatorWriter(1);
                output += headerWriter("Results breakdown");
                output += seperatorWriter(1);
                for (Map.Entry<String, Integer> entry : categoryAttempts.entrySet()) {
                        String key = entry.getKey();
                        Integer value = entry.getValue();
                        output += String.format("--Category |%s|\nIncorrect attempts |%s| out of possible total attempts of |%s|\n", key, value, questionsPerCategory.get(key) * 3);
                }
                return output;
        }

        // Prepares the attemptsPerCategory HashMap with a 0 value for each category and adds the question count from the split array to each category in order
        public static void categoryStats(ArrayList<String> result, HashMap<String, Integer> attemptsPerCategory, HashMap<String, Integer> questionsPerCategory, ArrayList<Integer> split) {
                int index = 0;
                for (String i: result) {
                        attemptsPerCategory.put(i, 0);
                        questionsPerCategory.put(i, split.get(index));
                        index++;
                }
        }
        // Takes in the HashMaps questionsPerCategory and attemptsPerCategory and uses the values in these, dividing the actual attempts by possible attempts to get a percentage value for the key to which is assigns the category
        public static TreeMap<Float, String> areasToFocusStudy(ArrayList<String> result, HashMap<String, Integer> categoryAttempts, HashMap<String, Integer> questionsPerCategory) {
                int attempts = 0;
                int totalAttempts = 0;
                float percentage = 0f;
                TreeMap<Float, String> sortedCategories = new TreeMap<>();
                for (String i: result) {
                        if (categoryAttempts.get(i) != 0) {
                                attempts = categoryAttempts.get(i);  // Category of General trivia = 1
                                totalAttempts = 3 * questionsPerCategory.get(i); // Category of General trivia = 9 (for 3)
                                percentage = (100 * attempts) / totalAttempts;
                                sortedCategories.put(Float.valueOf(String.format("%.2f", percentage)), i);
                        }
                }
                return sortedCategories;
        }
        // Prints out the percentage of total attempts used for each category, indicating where you need to focus your study
        public static void areasToStudyPrinter(TreeMap<Float, String> sortedCategories) {
                TestRunner.seperatorPrinter(1);
                TestRunner.headerPrinter("Score by category (%)");
                TestRunner.seperatorPrinter(1);
                System.out.println("The higher the percentage score the more focus on this area will be needed in studying");
                System.out.println("The lowest in the list will require the most attention");
                TestRunner.seperatorPrinter(1);
                sortedCategories.forEach((key, value) -> System.out.printf(
                        "----------------------------------------------------------------\n" +
                        "|%s| Percent of total attempts used: %s\n", value, key +
                        "\n----------------------------------------------------------------"
                ));
        }
        // Writes percentage of total attempts used for each category to a txt file
        public static String areasToStudyWriter(TreeMap<Float, String> sortedCategories) {
                String output = "";
                output += seperatorWriter(1);
                output += headerWriter("Score by category (%)");
                output += seperatorWriter(1);
                output += "The higher the percentage score the more focus on this area will be needed in studying\n";
                output += "The lowest in the list will require the most attention\n";
                output += "Categories where you had no incorrect attempts will not show here\n";
                output += seperatorWriter(1);
                for (Map.Entry<Float, String> entry : sortedCategories.entrySet()) {
                        Float key = entry.getKey();
                        String value = entry.getValue();
                        output += String.format(
                                "----------------------------------------------------------------\n" +
                                "|%s| Percent of total attempts used: %s\n", value, key +
                                "\n----------------------------------------------------------------\n");
                }
                return output;
        }

        public static void writeReportToFile(String filepath, String textToAdd) throws IOException {
                File file = new File(filepath);
                FileWriter fw = new FileWriter(file);
                fw.write(textToAdd);
                fw.close();
        }

        public static String seperatorWriter(int numLines) {
                String output ="";
                for (int i = 0; i < numLines; i++) {
                        output += "****************************************************************\n";
                }
                return output;
        }

        public static String headerWriter(String message) {
                String output = "";
                output += "----------------------------------------------------------------\n";
                output += String.format("%s \n", message);
                output += "----------------------------------------------------------------\n";
                return output;
        }

}


