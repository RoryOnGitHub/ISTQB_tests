import java.util.HashMap;
public class QuestionBank {
    public static void main(String[] args) {

    }
    // General trivia
    static String[] k1_questions = {
            "What is the capital of the UK?",
            "Which is heavier a tonne of bricks or a tonne of feathers?",
            "What is the capital of France?"
    };
    // Norse Mythology
    static String[] k2_questions = {
            "Which day of the week is named after the Norse god Tyr?",
            "Which day of the week is named after the Norse god Odin?",
            "Which day of the week is named after the Norse god Frigg?"
    };
    // 1.1 What is Testing
    static String[] q1_1 = {
        "Which one of the following answers describes a test condition?",
        "Which of the following statements is a valid objective for testing?",
        "Which of the following statements correctly describes the difference between testing and debugging?"
    };
    // 1.2 Why is testing necessary
    static String[] q1_2 = {
        "Which one of the statements below describes the most common situation for a failure discovered during testing or in production?",
        "In what way can testing be part of Quality Assurance?"
    };
    // 1.3 Testing principles
    static String[] q1_3 = {
        "Mr. Test has been testing software applications on mobile devices for a period of 5 years. He has a wealth of experience in testing mobile applications and achieves better results in a shorter time than others. Over several months, Mr. Test did not modify the existing automated test cases and did not create any new test cases. This leads to fewer and fewer defects being found by executing the tests. What principle of testing did Mr. Test not observe?",

    };
    // 1.4 Test activities, Testware and roles
    static String[] q1_4 = {
        "Which of the following activities is part of the main activity \"test analysis\" in the test process?",
        "Match the following test work products (1-4) with the right description (A-D).\n" +
                "1. Test suite \n" +
                "2. Test case \n" +
                "3. Test script \n" +
                "4. Test charter \n" +
                "\n" +
                "A. A set of test scripts to be executed in a specific test run \n" +
                "B. A set of instructions for the execution of a test \n" +
                "C. Contains expected results \n" +
                "D. Documentation of test activities in session-based exploratory testing \n",
    };
    // 1.5 Essential skills and good practices
    static String[] q1_5 = {

    };

    // 2.1 Testing in the context of SDLC
    static String[] q2_1 = {
        "Which one of the following is the BEST definition of an incremental development model?",
    };
    // 2.2 Test levels and types
    static String[] q2_2 = {
        "Which of the following statements comparing component testing and system testing is TRUE?",
    };
    // 2.3 Maintenance testing
    static String[] q2_3 = {
        "How can white-box testing be applied during acceptance testing?",
        "Which one of the following is TRUE?",
        "Which of the following should NOT be a trigger for maintenance testing?",
    };

    // 3.1 Static testing basics
    static String[] q3_1 = {
        "Which of the following statements about static testing are MOST true?",
    };
    // 3.2 Feedback and review process
    static String[] q3_2 = {
        "Which of the following options are roles in a formal review?",
        "Which activities are carried out within the planning of a formal review?",
        "Which of the review types below is the BEST option to choose when the review must follow a formal process based on rules and checklists?",
        "You will be invited to a review. The work product to be reviewed is a description of the in-house document creation process. The aim of the description is to present the work distribution between the different roles involved in the process in a way that can be clearly understood by everyone. \n" +
                "You will be invited to a checklist-based review. The checklist will also be sent to you. It includes the following points: \n" +
                "i. Is the person who performs the activity clearly identified for each activity? \n" +
                "ii. Are the entry criteria clearly defined for each activity? \n" +
                "iii. Are the exit criteria clearly defined for each activity? \n" +
                "iv. Are the supporting roles and their scope of work clearly defined for each activity? \n" +
                "\n" +
                "In the following we show an excerpt of the work result to be reviewed, for which you should use the checklist above: \n" +
                "\"After checking the customer documentation for completeness and correctness, the software architect creates the system specification. Once the software architect has completed the system specification, he invites testers and verifiers to the review. A checklist describes the scope of the review. Each invited reviewer creates review comments - if necessary - and concludes the review with an official review done-comment.\" \n" +
                "\n" +
        "Which of the following statements about your review is correct?\n",

    };

    // 4.1 Test techniques overview
    static String[] q4_1 = {
        "What is checklist-based testing?",
        "Which one of the following options is categorized as a black-box test technique?",
    };
    // 4.2 Black-box test techniques
    static String[] q4_2 = {
        "An employee’s bonus is to be calculated. It cannot be negative, but it can be calculated down to zero. The bonus is based on the length of employment: \n" +
                "- less than or equal to 2 years \n" +
                "- more than 2 years but less than 5 years \n" +
                "- 5 to 10 years inclusively \n" +
                "- longer than 10 years \n" +
                "\n" +
        "What is the minimum number of test cases required to cover all valid equivalence partitions for calculating the bonus?\n",
        "A speed control and reporting system has the following characteristics: \n" +
                "- If you drive 50 km/h or less, nothing will happen. \n" +
                "- If you drive faster than 50 km/h, but no more than 55 km/h, you will be warned. \n" +
                "- If you drive faster than 55 km/h but not more than 60 km/h, you will be fined. \n" +
                "- If you drive faster than 60 km/h, your driving license will be suspended. \n" +
                "- The speed in km/h is available to the system as an integer value. \n" +
                "\n" +
        "Which would be the most likely set of values (km/h) identified by applying the boundary value analysis, where only the values on the boundaries of the equivalence classes are selected?\n",
        "A video application has the following requirement: The application shall allow playing a video on the following display resolution: \n" +
                "1. 640x480 \n" +
                "2. 1280x720 \n" +
                "3. 1600x1200 \n" +
                "4. 1920x1080 \n" +
                "\n" +
        "Which of the following list of test cases is a result of applying the equivalence partitioning test technique to test this requirement?\n",
    };
    // 4.3 White box test techniques
    static String[] q4_3 = {
        "The following statement refers to decision coverage: \n" +
                "'When the code contains only a single ‘if’ statement and no loops or CASE statements, and its execution is not nested within the test, any single test case we run will result in 50% decision coverage.' \n" +
                "Which of the following statement is correct?\n",
                "Which one of the following is the description of statement coverage?",
                "Which statement about the relationship between statement coverage and decision coverage is true?",
    };
    // 4.4 Experience-based test techniques
    static String[] q4_4 = {
        "For which of the following situations is exploratory testing suitable?",
    };
    // 4.5 Collaboration-based test approaches
    static String[] q4_5 = {

    };

    // 5.1 Test planning
    static String[] q5_1 = {
        "Which of the following statements BEST describes how tasks are divided between the test manager and the tester?",
    };
    // 5.2 Risk management
    static String[] q5_2 = {
        "Which of the following can affect and be part of the (initial) test planning?",
        "Which of the following lists contains only typical exit criteria from testing?",
        "The project develops a \"smart\" heating thermostat. The control algorithms of the thermostat were modeled as Matlab/Simulink models and run on the internet connected server. The thermostat uses the specifications of the server to trigger the heating valves. \n" +
                "The test manager has defined the following test strategy/approach in the test plan: \n" +
                "1. The acceptance test for the whole system is executed as an experience-based test. \n" +
                "2. The control algorithms on the server are checked against standard of the energy saving regulation. \n" +
                "3. The functional test of the thermostat is performed as risk-based testing. \n" +
                "4. The security tests of data / communication via the internet are executed together with external security experts. \n" +
                "\n" +
        "What four common types of test strategies/approaches did the test manager implement in the test plan?\n",
        "Which one of the following is the characteristic of a metrics-based approach for test estimation?"
    };
    // 5.3 Test monitoring, control, and completion
    static String[] q5_3 = {
        "Which of the following metrics would be MOST useful to monitor during test execution?",
        "Which one of the following is NOT included in a test summary report?",
    };
    // 5.4 Configuration management
    static String[] q5_4 = {

    };
    // 5.5 Defect management
    static String[] q5_5 = {
        "You are testing a new version of software for a coffee machine. The machine can prepare different types of coffee based on four categories. i.e., coffee size, sugar, milk, and syrup. The criteria are as follows: \n" +
                "- Coffee size (small, medium, large) \n" +
                "- Sugar (none, 1 unit, 2 units, 3 units, 4 units) \n" +
                "- Milk (yes or no) \n" +
                "- Coffee flavor syrup (no syrup, caramel, hazelnut, vanilla) \n" +
                "\n" +
                "Now you are writing a defect report with the following information: \n" +
                "- Title: Low coffee temperature. \n" +
                "- Short summary: When you select coffee with milk, the time for preparing coffee is too long and the temperature of the beverage is too low (less than 40 °C). \n" +
                "- Expected result: The temperature of coffee should be standard (about 75 °C). \n" +
                "- Degree of risk: Medium \n" +
                "- Priority: Normal \n" +
                "\n" +
        "What valuable information was omitted in the above defect report? \n",
    };

    // 6.1 Tool support for testing
    static String[] q6_1 = {
        "Which one of the following is MOST likely to be a benefit of test execution tools?",
        "Which one of the following test tools is mostly suitable for developers rather than testers?",
    };
    // 6.2 Benefits and risk of test automation
    static String[] q6_2 = {

    };

    public static HashMap<String, String[]> getQuestionsBySubject() {
        HashMap<String, String[]> subjects = new HashMap<String, String[]>();
        subjects.put("General trivia", getK1_questions());
        subjects.put("Norse Mythology", getK2_questions());

        subjects.put("1.1 What is Testing", getQ1_1_questions());
        subjects.put("1.2 Why is testing necessary", getQ1_2_questions());
        subjects.put("1.3 Testing principles", getQ1_3_questions());
        subjects.put("1.4 Test activities, Testware and roles", getQ1_4_questions());

        subjects.put("2.1 Testing in the context of SDLC", getQ2_1_questions());
        subjects.put("2.2 Test levels and types", getQ2_2_questions());
        subjects.put("2.3 Maintenance testing", getQ2_3_questions());

        subjects.put("3.1 Static testing basics", getQ3_1_questions());
        subjects.put("3.2 Feedback and review process", getQ3_2_questions());

        subjects.put("4.1 Test techniques overview", getQ4_1_questions());
        subjects.put("4.2 Black-box test techniques", getQ4_2_questions());
        subjects.put("4.3 White box test techniques", getQ4_3_questions());
        subjects.put("4.4 Experience-based test techniques", getQ4_4_questions());

        subjects.put("5.1 Test planning", getQ5_1_questions());
        subjects.put("5.2 Risk management", getQ5_2_questions());
        subjects.put("5.3 Test monitoring, control, and completion", getQ5_3_questions());
        subjects.put("5.5 Defect management", getQ5_5_questions());

        subjects.put("6.1 Tool support for testing", getQ6_1_questions());

        return subjects;
    }

    // Using a getter to return the array to another class
    public static String[] getK1_questions() {
        return k1_questions.clone();
    }
    public static String[] getK2_questions() {
        return k2_questions.clone();
    }
    public static String[] getQ1_1_questions() {
        return q1_1.clone();
    }
    public static String[] getQ1_2_questions() {
        return q1_2.clone();
    }
    public static String[] getQ1_3_questions() {
        return q1_3.clone();
    }
    public static String[] getQ1_4_questions() {
        return q1_4.clone();
    }

    public static String[] getQ2_1_questions() { return q2_1.clone(); }
    public static String[] getQ2_2_questions() {
        return q2_2.clone();
    }
    public static String[] getQ2_3_questions() {
        return q2_3.clone();
    }

    public static String[] getQ3_1_questions() {
        return q3_1.clone();
    }
    public static String[] getQ3_2_questions() {
        return q3_2.clone();
    }

    public static String[] getQ4_1_questions() {
        return q4_1.clone();
    }
    public static String[] getQ4_2_questions() {
        return q4_2.clone();
    }
    public static String[] getQ4_3_questions() {
        return q4_3.clone();
    }
    public static String[] getQ4_4_questions() {
        return q4_4.clone();
    }

    public static String[] getQ5_1_questions() {
        return q5_1.clone();
    }
    public static String[] getQ5_2_questions() {
        return q5_2.clone();
    }
    public static String[] getQ5_3_questions() {
        return q5_3.clone();
    }
    public static String[] getQ5_5_questions() {
        return q5_5.clone();
    }

    public static String[] getQ6_1_questions() {
        return q6_1.clone();
    }


}
