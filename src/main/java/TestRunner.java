import java.util.*;

public class TestRunner {
    QuestionBank Questions = new QuestionBank();
    QuestionOptions Options = new QuestionOptions();
    Answers QuestionAnswers = new Answers();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("How many questions in total would you like? ");
        int usersTotalQuestions = scanner.nextInt();
        System.out.println("How many subjects would you like? ");
        int usersSubjectCount = scanner.nextInt();

        //Gets array of all subjects
//        subjectSetToArray();

        //subject printer (The subjects will be the papers i.e., 2018 version) returns an array of chosen subjects
        ArrayList<String> result = subjectPrinter(subjectSetToArray());

        // Getting a good split of questions per subject returning this as an array
        ArrayList<Integer> split = questionSubjectSplit(usersTotalQuestions, result.size());


        // Randomizer2 takes in the (questionSubjectSplit) Array and the (subjectPrinter) Array and returns an Array of all questions
        ArrayList<String> questions = questionRandomizer2(split, result);

        // printing out the questions from randomizer (so far it occasionally repeats itself)
        System.out.println("HERE--------------------------");
        for (String i : questionRandomizer(2, QuestionBank.getQuestionsBySubject().get("Norse"))) {
            System.out.println(i);
        }

        // Looping through the ArrayList of random questions NEEDS TO BE NESTED ABOVE WHILE LOOP
        String currentQuestion = "";
        for (int i = 0; i < questionRandomizer(2, QuestionBank.getQuestionsBySubject().get("Norse")).size(); i++) {
            currentQuestion = questionRandomizer(2, QuestionBank.getQuestionsBySubject().get("Norse")).get(i);
        }

        // Method call for printing out the question
        questionPrinter(currentQuestion,null);

        // Deal with say option A if it has been removed etc and if so when it is re-entered then its ignored.

        System.out.println("Please type your answer here (A,B,C,D): ");
        String usersAnswer = scanner.nextLine().toUpperCase();
        ArrayList<Integer> optionSelector = new ArrayList<Integer>();
        Collections.addAll(optionSelector,0,1,2,3);


        while (true) {
            if (usersAnswer.equals("A")) {
                optionSelector.remove((Integer) 0);
                if (QuestionOptions.getOptions().get(currentQuestion)[0].equals(Answers.getAnswers().get(currentQuestion))) {
                    System.out.println("That is correct!");
                    break;
                } else {
                    System.out.println("That is not correct try again:");
                    questionPrinter(currentQuestion,optionSelector);
                    if (optionSelector.size() == 1) {
                        System.out.println("You have ran out of attempts, the answer is: " + Answers.getAnswers().get(currentQuestion));
                        break;
                    }
                    usersAnswer = scanner.nextLine().toUpperCase();
                }
            } else if (usersAnswer.equals("B")) {
                optionSelector.remove((Integer) 1);
                if (QuestionOptions.getOptions().get(currentQuestion)[1].equals(Answers.getAnswers().get(currentQuestion))) {
                    System.out.println("That is correct!");
                    break;
                } else {
                    System.out.println("That is not correct try again:");
                    questionPrinter(currentQuestion,optionSelector);
                    if (optionSelector.size() == 1) {
                        System.out.println("You have ran out of attempts, the answer is: " + Answers.getAnswers().get(currentQuestion));
                        break;
                    }
                    usersAnswer = scanner.nextLine().toUpperCase();
                }
            } else if (usersAnswer.equals("C")) {
                optionSelector.remove((Integer) 2);
                if (QuestionOptions.getOptions().get(currentQuestion)[2].equals(Answers.getAnswers().get(currentQuestion))) {
                    System.out.println("That is correct!");
                    break;
                } else {
                    System.out.println("That is not correct try again:");
                    questionPrinter(currentQuestion,optionSelector);
                    if (optionSelector.size() == 1) {
                        System.out.println("You have ran out of attempts, the answer is: " + Answers.getAnswers().get(currentQuestion));
                        break;
                    }
                    usersAnswer = scanner.nextLine().toUpperCase();
                }
            } else if (usersAnswer.equals("D")) {
                optionSelector.remove((Integer) 3);
                if (QuestionOptions.getOptions().get(currentQuestion)[3].equals(Answers.getAnswers().get(currentQuestion))) {
                    System.out.println("That is correct!");
                    break;
                } else {
                    System.out.println("That is not correct try again:");
                    questionPrinter(currentQuestion,optionSelector);
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

        System.out.println("----------------------------------------------");
        System.out.println("If your answer was this then you are correct:");

        // Getting the answers
        System.out.println(Answers.getAnswers().get(currentQuestion));

    }

    // Creating an ArrayList to hold the questions randomly grabbed
    public static ArrayList<String> questionRandomizer(int num_of_questions, String[] questionArray) {
        ArrayList<String> randomQuestions = new ArrayList<String>();
        for (int i = 0; i < num_of_questions; i++) {
            int randomIndex = (int) (Math.random() * questionArray.length);
            String randomElement = questionArray[randomIndex];
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

    public static ArrayList<String> subjectSetToArray() {
        ArrayList<String> subjects = new ArrayList<>();
        Set<String> questionSubjects = QuestionBank.getQuestionsBySubject().keySet();
        for(int i = 0; i < questionSubjects.toArray().length; i++) {
            subjects.add(questionSubjects.toArray()[i].toString());
        }
        return subjects;
    }

    public static ArrayList<String> subjectPrinter(ArrayList<String> subjects) {
        ArrayList<String> chosenSubjects = new ArrayList<>();
        while(true) {
            for (int i = 0; i < 4; i++) {
                System.out.println("****************************************************************");
            }
            System.out.println("----------------------------------------------");
            System.out.println("Select which subjects you would like in your test:");
            System.out.println("----------------------------------------------");
            for (int i = 0; i < subjects.size(); i++) {
                System.out.println(i + ": " + subjects.get(i));
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select the subject by its allocated number (eg: 1):");
            int selectedSubject = Integer.parseInt(scanner.nextLine());
            if(selectedSubject > subjects.size()) {
                System.out.println("Subject not found, please use select a number within range");
            } else {
                chosenSubjects.add(subjects.get(selectedSubject));
                subjects.remove(subjects.get(selectedSubject));
            }
            System.out.println("Would you like to add anymore subjects? (Y/N)");
            String continueChoice = scanner.nextLine();
            if (continueChoice.equalsIgnoreCase("N") || subjects.size() == 0) {
                break;
            }
        }
        return chosenSubjects;
    }

    public static ArrayList<String> questionRandomizer2(ArrayList<Integer> splitOfSubjects, ArrayList<String> subjects) {
        ArrayList<String> randomQuestions = new ArrayList<String>();
        int splitIndexer = 0;
        for(String subject : subjects) {
            String[] subjectQuestions = QuestionBank.getQuestionsBySubject().get(subject);
            for (int i = 0; i < splitOfSubjects.get(splitIndexer); i++) {                   // FAILURE HERE
                int randomIndex = (int) (Math.random() * subjectQuestions.length);
                String randomElement = subjectQuestions[randomIndex];
                randomQuestions.add(randomElement);
            }
            splitIndexer++;
        }
        return randomQuestions;
    }

}
