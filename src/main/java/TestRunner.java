import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestRunner {

    public static void main(String[] args) throws IOException, InterruptedException {

        int usersTotalQuestions = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("How many questions in total would you like? (Choose a number between 1 and 40)");
            try {
                usersTotalQuestions = Integer.parseInt(scanner.nextLine());
                if (usersTotalQuestions > 0 && usersTotalQuestions <= 40) {
                    break;
                } else {
                    System.out.println("You must choose a number between 0 and 40 ");
                }
            } catch (NumberFormatException e){
                System.out.println("You must choose a number between 0 and 40 ");
            }
        }

        // Have a HashMap initiated here to collect the attempts per category
        HashMap<String, Integer> attemptsPerCategory = new HashMap<String, Integer>();

        HashMap<String, Integer> questionsPerCategory = new HashMap<String, Integer>();

        ArrayList<String> questions = null;
        ArrayList<String> result = null;
        ArrayList<Integer> split = null;
        while (true) {
            System.out.println("Would you like to choose your own subjects? (Y/N)? ");
            String subjectOption = scanner.nextLine();
            if (subjectOption.equalsIgnoreCase("N")) {
                // Default option for subject selection
                result = defaultSubjects(subjectSetToArray(), usersTotalQuestions);
                split = questionSubjectSplit(usersTotalQuestions, result.size());
                questions = questionRandomizer(split, result);
                // Adds the subjects and a starting attempt of 0 as a value for each, so they can then be added to later and adds questions per category
                Reporter.categoryStats(result, attemptsPerCategory, questionsPerCategory, split);
                break;
            } else if (subjectOption.equalsIgnoreCase("Y")){
                // Subject printer (The subjects will be the categories) returns an array of chosen subjects
                result = subjectPrinter(subjectSetToArray(), usersTotalQuestions);
                // Getting a good split of questions per subject returning this as an array
                split = questionSubjectSplit(usersTotalQuestions, result.size());
                // Adds the subjects and a starting attempt of 0 as a value for each, so they can then be added to later
                Reporter.categoryStats(result, attemptsPerCategory, questionsPerCategory, split);
                // The question randomizer takes in the (questionSubjectSplit) Array and the (subjectPrinter) Array and returns an Array of all questions   needs if for default options
                questions = questionRandomizer(split, result);
                break;
            } else {
                System.out.println("Please enter either (Y or N) for Yes or No");
            }
        }


        // TESTING PURPOSES printing out the randomized questions                               TESTING PURPOSES
        System.out.println("TEST--------------------------");
        for (String i : questions) {
            System.out.println(i);
        }
        System.out.println("TEST--------------------------");
        // TESTING PURPOSES printing out the randomized questions                               TESTING PURPOSES

        // Get the chosen destination (filepath) to save the report (validate this destination beforehand) and create blank report  GIVE OPTION IF THEY DO NOT WANT A REPORT FILE
        String filePath = "";
        if (quitOrContinueOptions("have the test results saved in a report file") == 1) {
            while (true) {
                int valid = 0;
                System.out.println("Please enter a valid file path, this is where your test report will be stored");
                filePath = scanner.nextLine() + "" + "\\test_report.txt";
                try {
                    Reporter.writeReportToFile(filePath, "");
                } catch (IOException e){
                    System.out.println("This file path is invalid, unable to create a report here: " + filePath);
                    valid = 1;
                    if (quitOrContinueOptions("continue adding a file path for the report to be saved to?") == 2) {
                        filePath = "";
                        break;
                    }
                }
                if (valid == 0) {
                    break;
                }
            }
        }


        // Have a HashMap initiated here to collect the question, attempts and question category etc for the report
        HashMap<Integer, String[]> resultsForReport = new HashMap<Integer, String[]>();

        int questionNumber = 0;

        // The outer loop which Loops through the ArrayList of randomly compiled questions
        for (int i = 0; i < questions.size(); i++) {
            String currentQuestion = questions.get(i);
            int questionAttempts = 0;
            String questionCategory = QuestionCategory.getCategory().get(currentQuestion);
            // Initial method call for printing out the question
            questionPrinter(currentQuestion, null);

            System.out.println("Please type your answer here (A,B,C,D): "); // Deal with say option A if it has been removed etc and if so when it is re-entered then its ignored.
            String usersAnswer = scanner.nextLine().toUpperCase();
            ArrayList<Integer> optionSelector = new ArrayList<Integer>();
            Collections.addAll(optionSelector, 0, 1, 2, 3);
            ArrayList<String> choices = new ArrayList<String>();
            Collections.addAll(choices, "A", "B", "C", "D");

            while (true) {
                if (usersAnswer.equals("A") || usersAnswer.equals("B") || usersAnswer.equals("C") || usersAnswer.equals("D")) {
                    int indexOfAnswer = choices.indexOf(usersAnswer);
                    optionSelector.remove((Integer)indexOfAnswer);
                    if (QuestionOptions.getOptions().get(currentQuestion)[indexOfAnswer].equals(Answers.getAnswers().get(currentQuestion))) {
                        System.out.println("That is correct!");
                        TimeUnit.SECONDS.sleep(3);      //A pause so that you can read that you have gotten the question correct
                        break;
                    } else {
                        questionAttempts++;
                        questionPrinter(currentQuestion, optionSelector);
                        System.out.println("That is not correct try again:");
                        System.out.println("Attempts so far: " + questionAttempts + "/" + "3");
                        if (optionSelector.size() == 1) {
                            System.out.println("You have ran out of attempts, the answer is: " + Answers.getAnswers().get(currentQuestion));
                            break;
                        }
                        usersAnswer = scanner.nextLine().toUpperCase();
                    }
                } else {
                    System.out.println("The answer you provided was neither A, B, C or D, please enter one of these letters");
                    usersAnswer = scanner.nextLine().toUpperCase();
                }
            }
            questionNumber++;
            // After each question the report grabs the question (as key) and the number of tries and category as the value both within an array
            resultsForReport.put(questionNumber, new String[] {currentQuestion,String.valueOf(questionAttempts), questionCategory});
            if (questionAttempts > 0) {
                attemptsPerCategory.put(questionCategory, attemptsPerCategory.get(questionCategory) + questionAttempts);
            }

        }
        // Outputting the report, either by console or txt file
        if (!filePath.equals("")) {
            // Compiling the report for writing
            String fullReport =
                    Reporter.questionStatsWriter(resultsForReport) +
                            Reporter.resultsBreakdownWriter(attemptsPerCategory, questionsPerCategory, usersTotalQuestions) +
                            Reporter.areasToStudyWriter(Reporter.areasToFocusStudy(result, attemptsPerCategory, questionsPerCategory));

            // Writing the report
            Reporter.writeReportToFile(filePath, fullReport);
        }

        if (filePath.equals("")) {
            // Printing out the stats for each question
            Reporter.questionStatsPrinter(resultsForReport);

            // Printing out the incorrect attempts per category (Show this against total questions per category)
            Reporter.resultsBreakdown(attemptsPerCategory, questionsPerCategory, usersTotalQuestions);

            // Printing out each category with a score, the higher the score the more attention required
            Reporter.areasToStudyPrinter(Reporter.areasToFocusStudy(result, attemptsPerCategory, questionsPerCategory));
        }

    }




// TestRunner methods

    // Takes in the current question and grabs the initial options returning them
    public static ArrayList<String> getInitialOptions(String question) {
        String[] arrayOfOptions = QuestionOptions.getOptions().get(question);
        ArrayList<String> optionsArray = new ArrayList<String>();
        for (int i = 0; i < arrayOfOptions.length; i++) {
            optionsArray.add(arrayOfOptions[i]);
        }
        return optionsArray;
    }
    // Takes in the current question and an Array with the indexes of the options (0, 1, 2, 3) and prints out the options provided
    public static void questionPrinter(String currentQuestion, ArrayList<Integer> options) {
        seperatorPrinter(10);
        System.out.println(currentQuestion);
        headerPrinter("Select an answer from the below options:");
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
    // Takes in the total amount of questions provided and the amount of subjects provided and returns an Array with an even split i.e., (3, 3, 3)
    public static ArrayList<Integer> questionSubjectSplit(int totalAmountQuestions, int subjects) { // Change subjects to ArrayList<String>
        int remainder = totalAmountQuestions % subjects;
        ArrayList<Integer> groupSplit = new ArrayList<>();
        if (remainder != 0) {
            for(int i = 0; i < subjects - 1; i++) {
                groupSplit.add((totalAmountQuestions - remainder) / subjects);
            }
            groupSplit.add(((totalAmountQuestions - remainder) / subjects) + remainder);
        } else {
            for(int i = 0; i < subjects; i++) {
                groupSplit.add(totalAmountQuestions / subjects);
            }
        }
        return groupSplit;
    }
    // Takes a set of subjects from the HashMap and converts to an Array which it returns for use
    public static ArrayList<String> subjectSetToArray() {
        ArrayList<String> subjects = new ArrayList<>();
        Set<String> questionSubjects = QuestionBank.getQuestionsBySubject().keySet();
        for(int i = 0; i < questionSubjects.toArray().length; i++) {
            subjects.add(questionSubjects.toArray()[i].toString());
        }
        return subjects;
    }
    // Takes an Array of all the subjects and gets the user to select which ones they want then returns an Array of chosen subjects
    public static ArrayList<String> subjectPrinter(ArrayList<String> subjects, int totalQuestions) {
        ArrayList<String> chosenSubjects = new ArrayList<>();
        while(true) {
            seperatorPrinter(4);
            if (chosenSubjects.size() == totalQuestions || subjects.size() == 0) {
                break;
            }
            Scanner scanner = new Scanner(System.in);
            headerPrinter("Select which subjects you would like in your test:");
            for (int i = 0; i < subjects.size(); i++) {
                System.out.println(i + ": " + subjects.get(i));
            }
            System.out.println("Select the subject by its allocated number (eg: 1):");
            try {
                int selectedSubject = Integer.parseInt(scanner.nextLine());
                if (selectedSubject < subjects.size()) {
                    chosenSubjects.add(subjects.get(selectedSubject));
                    subjects.remove(subjects.get(selectedSubject));
                } else {
                    System.out.println("Subject not found, please enter a number within the range presented");
                }
            }catch (NumberFormatException e) {
                System.out.println("That is not a listed number, please enter a number within the range presented");
            }
            if (subjects.size() == 0) {
                break;
            }
            if (quitOrContinueOptions("continue adding subjects?") == 2) {
                break;
            }
        }
        return chosenSubjects;
    }
    // Takes in an array with the questions evenly split  for each subject i.e., (3, 3, 4) and an Array of the subjects chosen, then creates an ArrayList of random questions
    public static ArrayList<String> questionRandomizer(ArrayList<Integer> splitOfSubjects, ArrayList<String> subjects) {
        ArrayList<String> randomQuestions = new ArrayList<String>();
        int splitIndexer = 0;
        for(String subject : subjects) {
            String[] subjectQuestions = QuestionBank.getQuestionsBySubject().get(subject);  // Changed to an arrayList so it can be modified
            ArrayList<String> retrievedQuestions = new ArrayList<>(Arrays.asList(subjectQuestions));
            for (int i = 0; i < splitOfSubjects.get(splitIndexer); i++) {
                int randomIndex = (int) (Math.random() * retrievedQuestions.size());
                String randomElement = retrievedQuestions.get(randomIndex);
                randomQuestions.add(randomElement);
                retrievedQuestions.remove(randomIndex); // Removing the item from the list should prevent duplicates
            }
            splitIndexer++;
        }
        return randomQuestions;
    }
    // Takes in a phrase, an array of chosenSubjects and the total questions and returns a choice for another conditional statement to interpret
    public static int quitOrContinueOptions(String phrase) {
        int returnOption = 0; // 1 = continue; 2 = break;  3 = Invalid input
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("Would you like to %s? (Y/N)\n", phrase);
            String continueChoice = scanner.nextLine();
            if (continueChoice.equalsIgnoreCase("N")) {
                returnOption = 2;   // Will break anyway if just 1 subject is selected etc
                break;
            } else if (continueChoice.equalsIgnoreCase("Y")) {
                returnOption = 1;
                break;
            } else {
                System.out.println("Please enter a valid input as requested");
            }
        }
        return returnOption;
    }
    // Takes in all the subjects (subjectsSetToArray) and the total questions, if total questions is less than subject count it does 1 question per subject else it splits them evenly
    public static ArrayList<String> defaultSubjects(ArrayList<String> subjectsArray, int totalQuestions) {
        ArrayList<String> defaultChoices = new ArrayList<String>();
        if (subjectsArray.size() < totalQuestions) {
            for(int i = 0; i < subjectsArray.size(); i++) {
                defaultChoices.add(subjectsArray.get(i));
        }
            return defaultChoices;
        } else {
            return subjectsArray;
        }
    }

    public static void seperatorPrinter(int numLines) {
        for (int i = 0; i < numLines; i++) {
            System.out.println("****************************************************************");
        }
    }

    public static void headerPrinter(String message) {
            System.out.println("----------------------------------------------------------------");
            System.out.printf("%s \n", message);
            System.out.println("----------------------------------------------------------------");
    }

}
