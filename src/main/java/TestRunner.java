import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class TestRunner {
    QuestionBank Questions = new QuestionBank();
    QuestionOptions Options = new QuestionOptions();
    Answers QuestionAnswers = new Answers();

    public static void main(String[] args) {


        QuestionBank Questions = new QuestionBank();
        QuestionOptions Options = new QuestionOptions();
        Answers QuestionAnswers = new Answers();

        // Getting the question
        String[] k1QuestionsArray = Questions.getK1_questions();


        // A loop to make sure each question is visually separate


        // Looping through the ArrayList of random questions
        String question = "";
        for (int i = 0; i < questionRandomizer(2).size(); i++) {
            question = questionRandomizer(2).get(i);
        }


        // Getting the options from the array (turning this into a method you might want to think about amount of times run and the optionselector
        for (int i = 0; i < getInitialOptions(question).size(); i++) {
            System.out.println(getInitialOptions(question).get(i));
        }
        questionPrinter(question,null);
    // Deal with say option A if it has been removed etc and if so when it is re-entered then its ignored.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type your answer here (A,B,C,D): ");
        String answer = scanner.nextLine().toUpperCase();
        // Needs the ability to decide if it is correct or incorrect
        ArrayList<Integer> optionSelector = new ArrayList<Integer>();
        //Current breaks here as it's now an array of size 3
        Collections.addAll(optionSelector,0,1,2,3);
        System.out.println(optionSelector);
        int exitCriteria = 1;
        while (exitCriteria == 1) {
            if (answer.equals("A")) {
                optionSelector.remove((Integer) 0);
                if (QuestionOptions.getOptions().get(question)[0].equals(Answers.getAnswers().get(question))) {
                    System.out.println("That is correct!");
                    break;
                } else {
                    System.out.println("That is not correct try again:");
                    // pass the optionSelecter to the printer
                    questionPrinter(question,optionSelector);
                    if (optionSelector.size() == 1) {
                        System.out.println("You have ran out of attempts, the answer is: " + Answers.getAnswers().get(question));
                        break;
                    }
                    answer = scanner.nextLine().toUpperCase();
                }
            } else if (answer.equals("B")) {
                optionSelector.remove((Integer) 1);
                if (QuestionOptions.getOptions().get(question)[1].equals(Answers.getAnswers().get(question))) {
                    System.out.println("That is correct!");
                    break;
                } else {
                    System.out.println("That is not correct try again:");
                    questionPrinter(question,optionSelector);
                    if (optionSelector.size() == 1) {
                        System.out.println("You have ran out of attempts, the answer is: " + Answers.getAnswers().get(question));
                        break;
                    }
                    answer = scanner.nextLine().toUpperCase();
                }
            } else if (answer.equals("C")) {
                optionSelector.remove((Integer) 2);
                if (QuestionOptions.getOptions().get(question)[2].equals(Answers.getAnswers().get(question))) {
                    System.out.println("That is correct!");
                    break;
                } else {
                    System.out.println("That is not correct try again:");
                    questionPrinter(question,optionSelector);
                    if (optionSelector.size() == 1) {
                        System.out.println("You have ran out of attempts, the answer is: " + Answers.getAnswers().get(question));
                        break;
                    }
                    answer = scanner.nextLine().toUpperCase();
                }
            } else if (answer.equals("D")) {
                optionSelector.remove((Integer) 3);
                if (QuestionOptions.getOptions().get(question)[3].equals(Answers.getAnswers().get(question))) {
                    System.out.println("That is correct!");
                    break;
                } else {
                    System.out.println("That is not correct try again:");
                    questionPrinter(question,optionSelector);
                    if (optionSelector.size() == 1) {
                        System.out.println("You have ran out of attempts, the answer is: " + Answers.getAnswers().get(question));
                        break;
                    }
                    answer = scanner.nextLine().toUpperCase();
                }
            } else {
                System.out.println("The answer you provided was neither A, B, C or D, please enter one of these letters");
                answer = scanner.nextLine().toUpperCase();
            }
        }
        System.out.println("----------------------------------------------");
        System.out.println("If your answer was this then you are correct:");

        // Getting the answers
        System.out.println(Answers.getAnswers().get(question));


        // Randomize test from the questions in the bank
        // must select certain amount per category
        // Shows question and possible answers
        // When answered if right it logs it as correct on your score then moves on
        // When incorrect it removes the incorrect answer and prompts you again
        // Continues until correct or the last option is left
        // Gives you a score at the end
        // Based on categories got wrong it tells you where to focus

        // Have the questions in Arrays which are in categories
        // Then have a question details hash with the options and answer

        // Distinguish between ISTQB versions, 2018 etc


        // For removing questions A would map to index 0


        // The user requirements
        // Be able to specify the amount of questions
        // Have option to be able to specify the type of questions can skip (assume even split if default)
        // Have the results shown at the end, showing both score and areas that need focus

        //Have a loop, or even a class that deals with the graphic output (messages and layout etc)
    }

    // Creating an ArrayList to hold the questions randomly grabbed
    public static ArrayList<String> questionRandomizer(int num_of_questions) {
        ArrayList<String> randomQuestions = new ArrayList<String>();
        for (int i = 0; i < num_of_questions; i++) {
            int randomIndex = (int) (Math.random() * QuestionBank.getK1_questions().length);
            String randomElement = QuestionBank.getK1_questions()[randomIndex];
            randomQuestions.add(randomElement);
        }
        return randomQuestions;
    }

    public static ArrayList<String> getInitialOptions(String question) {
        String[] arrayOfOptions = QuestionOptions.getOptions().get(question);
        ArrayList<String> optionsArray = new ArrayList<String>();
        for (int i = 0; i < arrayOfOptions.length; i++) {
            optionsArray.add(arrayOfOptions[i]);
        }
        return optionsArray;
    }

    public static void questionPrinter(String currentQuestion, ArrayList<Integer> options) {
        for (int i = 0; i < 10; i++) {
            System.out.println("****************************************************************");
        }
        System.out.println(currentQuestion);
        System.out.println("----------------------------------------------");
        System.out.println("Select an answer from the below options:");
        System.out.println("----------------------------------------------");
        if (options == null) {
            for (int i = 0; i < getInitialOptions(currentQuestion).size(); i++) {
                System.out.println(getInitialOptions(currentQuestion).get(i));
            }
        } else {
            for (int i : options) {
                System.out.println(getInitialOptions(currentQuestion).get(i));
            }
        }
    }
}
