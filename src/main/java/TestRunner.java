import java.util.*;

public class TestRunner {
    QuestionBank Questions = new QuestionBank();

    public static void main(String[] args) {

        boolean valid = false;
        int usersTotalQuestions = 0;
        Scanner scanner = new Scanner(System.in);
        while (!valid) {
            System.out.println("How many questions in total would you like? (Choose a number between 1 and 40)");
            try {
                usersTotalQuestions = scanner.nextInt();
                valid = true;
                if (usersTotalQuestions > 0 && usersTotalQuestions <= 40) {
                    break;
                } else {
                    System.out.println("You must choose a number between 0 and 40 ");
                }
            } catch (InputMismatchException e){
                System.out.println("You must choose a number between 0 and 40 ");      // Continues to loop needs fixing
                valid = false;
            }
        }


        ArrayList<String> questions = null;
        while (true) {
            System.out.println("Would you like to choose your own subjects? (Y/N)? ");
            String subjectOption = scanner.nextLine();
            if (subjectOption.equalsIgnoreCase("N")) {
                // Default option for subject selection
                questions = defaultSubjects(subjectSetToArray(), usersTotalQuestions);
                break;
            } else if (subjectOption.equalsIgnoreCase("Y")){
                // Subject printer (The subjects will be the papers i.e., 2018 version) returns an array of chosen subjects
                ArrayList<String> result = subjectPrinter(subjectSetToArray(), usersTotalQuestions);

                // Getting a good split of questions per subject returning this as an array
                ArrayList<Integer> split = questionSubjectSplit(usersTotalQuestions, result.size());

                // The question randomizer takes in the (questionSubjectSplit) Array and the (subjectPrinter) Array and returns an Array of all questions   needs if for default options
                questions = questionRandomizer(split, result);
                break;
            }
        }


        // TESTING PURPOSES printing out the randomized questions (so far it occasionally repeats itself)
        System.out.println("TEST--------------------------");
        for (String i : questions) {
            System.out.println(i);
        }
        System.out.println("TEST--------------------------");

        // Have a HashMap initiated here to collect the question, attempts and question category etc for the report

        // The outer loop which Loops through the ArrayList of randomly compiled questions
        for (int i = 0; i < questions.size(); i++) {
            String currentQuestion = questions.get(i);
            int questionAttempts = 0;
            String questionCategory = "";   // Needs a HashMap retrieval

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
                        break;
                    } else {
                        questionAttempts++;
                        questionPrinter(currentQuestion, optionSelector);
                        System.out.println("That is not correct try again:");
                        System.out.println("Attempts left: " + (optionSelector.size() - questionAttempts)); // Currently not getting the correct value on second attempt
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
            // Grab the question (to get its category),number of tries
            // Get chosen destination to save the report (validate this destination beforehand)
            System.out.println("----------------------------------------------");
            System.out.println("If your answer was this then you are correct:");

            // Getting the answers
            System.out.println(Answers.getAnswers().get(currentQuestion));
        }
    }

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
            for (int i = 0; i < 4; i++) {
                System.out.println("****************************************************************");
            }
            if (chosenSubjects.size() == totalQuestions || subjects.size() == 0) {
                break;
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("----------------------------------------------");
            System.out.println("Select which subjects you would like in your test:");
            System.out.println("----------------------------------------------");
            for (int i = 0; i < subjects.size(); i++) {
                System.out.println(i + ": " + subjects.get(i));
            }
            System.out.println("Select the subject by its allocated number (eg: 1):");
            int selectedSubject = Integer.parseInt(scanner.nextLine());
            if(selectedSubject > subjects.size()) {
                System.out.println("Subject not found, please use select a number within range");
            } else {
                chosenSubjects.add(subjects.get(selectedSubject));
                subjects.remove(subjects.get(selectedSubject));
            }
            if (subjects.size() == 0) {
                break;
            }
            System.out.println("Would you like to continue adding subjects? (Y/N)");
            String continueChoice = scanner.nextLine();
            if (continueChoice.equalsIgnoreCase("N")) {
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
    public static int quitOrContinueOptions(String phrase, ArrayList<String> chosenSubjects, int totalQuestions) {
        int returnOption = 0; // 1 = continue; 2 = break; (when subject added),  3 = break; (when no subject added)
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Would you like to %s? (Y/N)", phrase);
        String continueChoice = scanner.nextLine();
        if (continueChoice.equalsIgnoreCase("N")) {
            returnOption = 2;   // Will break anyway if just 1 subject is selected etc
            if (phrase.equals("add a subject") && chosenSubjects == null) {
                returnOption = 3;
            }
        } else if (continueChoice.equalsIgnoreCase("Y")) {
            returnOption = 1;
        }
        return returnOption;
    }
    // Takes in all the subjects (subjectsSetToArray) and the total questions, if total questions is less than subject count it does 1 question per subject else it splits them evenly
    public static ArrayList<String> defaultSubjects(ArrayList<String> subjectsArray, int totalQuestions) {
        ArrayList<String> defaultChoices = new ArrayList<String>();
        if (subjectsArray.size() <= totalQuestions) {
            for(int i = 0; i < totalQuestions; i++) {
                defaultChoices.add(subjectsArray.get(i));
        }
            return defaultChoices;
        } else {
            return questionRandomizer(questionSubjectSplit(totalQuestions, subjectsArray.size()), subjectsArray);
        }
    }

}
