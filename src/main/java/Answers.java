import java.util.HashMap;

public class Answers {
    public static void main(String[] args) {


    }

    public static HashMap<String, String> getAnswers() {
        HashMap<String, String> answers = new HashMap<String, String>();
        // K1 Answers
        answers.put("What is the capital of the UK?", "a) London");
        answers.put("Which is heavier a tonne of bricks or a tonne of feathers?", "c) Both weigh the same");
        answers.put("What is the capital of France?", "d) Paris");

        // K2 Answers
        answers.put("Which day of the week is named after the Norse god Tyr?", "c) Tuesday");
        answers.put("Which day of the week is named after the Norse god Odin?", "b) Wednesday");
        answers.put("Which day of the week is named after the Norse god Frigg?", "d) Friday");

//      1.1 What is Testing
        answers.put("Which one of the following answers describes a test condition?", "b) A testable aspect of a component or system identified as a basis for testing ");
        answers.put("Which of the following statements is a valid objective for testing?", "b) To validate whether the test object works as expected by the users and other stakeholders ");
        answers.put("Which of the following statements correctly describes the difference between testing and debugging?", "b) Dynamic testing shows failures caused by defects; debugging eliminates the defects, which are the source of failures ");
//      1.2 Why is testing necessary
        answers.put("Which one of the statements below describes the most common situation for a failure discovered during testing or in production?", "a) The product crashed when the user selected an option in a dialog box ");
        answers.put("In what way can testing be part of Quality Assurance?", "b) Testing reduces the risk of poor software quality ");
//      1.3 Testing principles
        answers.put("Mr. Test has been testing software applications on mobile devices for a period of 5 years. He has a wealth of experience in testing mobile applications and achieves better results in a shorter time than others. Over several months, Mr. Test did not modify the existing automated test cases and did not create any new test cases. This leads to fewer and fewer defects being found by executing the tests. What principle of testing did Mr. Test not observe?", "c) Repeating of same tests will not find new defects ");
//      1.4 Test activities, Testware and roles
        answers.put("Which of the following activities is part of the main activity \"test analysis\" in the test process?", "d) Evaluating the test basis for testability ");
        answers.put("Match the following test work products (1-4) with the right description (A-D).\n" +
                "1. Test suite \n" +
                "2. Test case \n" +
                "3. Test script \n" +
                "4. Test charter \n" +
                "\n" +
                "A. A set of test scripts to be executed in a specific test run \n" +
                "B. A set of instructions for the execution of a test \n" +
                "C. Contains expected results \n" +
                "D. Documentation of test activities in session-based exploratory testing \n", "a) 1A, 2C, 3B, 4D ");
//      1.5 Essential skills and good practices


//      2.1 Testing in the context of SDLC
        answers.put("Which one of the following is the BEST definition of an incremental development model?", "a) Defining requirements, designing software and testing are done in phases where in each phase a piece of the system is added ");
//      2.2 Test levels and types
        answers.put("Which of the following statements comparing component testing and system testing is TRUE?", "b) Test cases for component testing are usually derived from component specifications, design specifications, or data models, whereas test cases for system testing are usually derived from requirement specifications or use cases ");
//      2.3 Maintenance testing
        answers.put("How can white-box testing be applied during acceptance testing?", "c) To check if all work process flows have been covered ");
        answers.put("Which one of the following is TRUE?", "c) The purpose of regression testing is to detect unintended side effects, while the purpose of confirmation testing is to check if the original defect has been fixed ");
        answers.put("Which of the following should NOT be a trigger for maintenance testing?", "a) Decision to test the maintainability of the software ");

//      3.1 Static testing basics
        answers.put("Which of the following statements about static testing are MOST true?", "a) Static testing is a cheap way to detect and remove defects ");
//      3.2 Feedback and review process
        answers.put("Which of the following options are roles in a formal review?", "d) Author, Moderator, Review leader, Reviewer, Scribe ");
        answers.put("Which activities are carried out within the planning of a formal review?", "c) Definition and Verification of fulfillment of entry criteria for the review ");
        answers.put("Which of the review types below is the BEST option to choose when the review must follow a formal process based on rules and checklists?", "c) Inspection");
        answers.put("You will be invited to a review. The work product to be reviewed is a description of the in-house document creation process. The aim of the description is to present the work distribution between the different roles involved in the process in a way that can be clearly understood by everyone. \n" +
                "You will be invited to a checklist-based review. The checklist will also be sent to you. It includes the following points: \n" +
                "i. Is the person who performs the activity clearly identified for each activity? \n" +
                "ii. Are the entry criteria clearly defined for each activity? \n" +
                "iii. Are the exit criteria clearly defined for each activity? \n" +
                "iv. Are the supporting roles and their scope of work clearly defined for each activity? \n" +
                "\n" +
                "In the following we show an excerpt of the work result to be reviewed, for which you should use the checklist above: \n" +
                "\"After checking the customer documentation for completeness and correctness, the software architect creates the system specification. Once the software architect has completed the system specification, he invites testers and verifiers to the review. A checklist describes the scope of the review. Each invited reviewer creates review comments - if necessary - and concludes the review with an official review done-comment.\" \n" +
                "\n" +
                "Which of the following statements about your review is correct?\n", "d) Point i) of the checklist has been violated because it is not clear who is providing the checklist for the invitation to the review ");

//      4.1 Test techniques overview
        answers.put("What is checklist-based testing?", "c) An experience-based test technique whereby the experienced tester uses a list of items to be noted, checked, or remembered, or a set of rules or criteria against which a product must be verified ");
        answers.put("Which one of the following options is categorized as a black-box test technique?", "d) A technique based on formal requirements ");
//      4.2 Black-box test techniques
        answers.put("An employee’s bonus is to be calculated. It cannot be negative, but it can be calculated down to zero. The bonus is based on the length of employment: \n" +
                "- less than or equal to 2 years \n" +
                "- more than 2 years but less than 5 years \n" +
                "- 5 to 10 years inclusively \n" +
                "- longer than 10 years \n" +
                "\n" +
                "What is the minimum number of test cases required to cover all valid equivalence partitions for calculating the bonus?\n", "d) 4 ");
        answers.put("A speed control and reporting system has the following characteristics: \n" +
                "- If you drive 50 km/h or less, nothing will happen. \n" +
                "- If you drive faster than 50 km/h, but no more than 55 km/h, you will be warned. \n" +
                "- If you drive faster than 55 km/h but not more than 60 km/h, you will be fined. \n" +
                "- If you drive faster than 60 km/h, your driving license will be suspended. \n" +
                "- The speed in km/h is available to the system as an integer value. \n" +
                "\n" +
                "Which would be the most likely set of values (km/h) identified by applying the boundary value analysis, where only the values on the boundaries of the equivalence classes are selected?\n", "d) 50, 51, 55, 56, 60, 61 ");
        answers.put("A video application has the following requirement: The application shall allow playing a video on the following display resolution: \n" +
                "1. 640x480 \n" +
                "2. 1280x720 \n" +
                "3. 1600x1200 \n" +
                "4. 1920x1080 \n" +
                "\n" +
                "Which of the following list of test cases is a result of applying the equivalence partitioning test technique to test this requirement?\n", "c) Verify that the application can play a video on each of the display sizes in the requirement (4 test cases) ");
//      4.3 White box test techniques
        answers.put("The following statement refers to decision coverage: \n" +
                "“When the code contains only a single ‘if’ statement and no loops or CASE statements, and its execution is not nested within the test, any single test case we run will result in 50% decision coverage.” \n" +
                "Which of the following statement is correct?\n", "b) The statement is true. Any single test case would cause the outcome of the “if” statement to be either true or false ");
        answers.put("Which one of the following is the description of statement coverage?", "b) It is a metric, which is the percentage of statements in the source code that have been executed ");
        answers.put("Which statement about the relationship between statement coverage and decision coverage is true?", "a) 100% decision coverage also guarantees 100% statement coverage");
//      4.4 Experience-based test techniques
        answers.put("For which of the following situations is exploratory testing suitable?", "c) When testers are available who have enough knowledge of similar applications and technologies ");
//      4.5 Collaboration-based test approaches


//      5.1 Test planning
        answers.put("Which of the following statements BEST describes how tasks are divided between the test manager and the tester?", "b) The test manager plans, coordinates and controls the testing activities, while the tester automates the tests ");
//      5.2 Risk management
        answers.put("Which of the following can affect and be part of the (initial) test planning?", "a) Budget limitations ");
        answers.put("Which of the following lists contains only typical exit criteria from testing?", "a) Reliability measures, test coverage, schedule and status about fixing defect and remaining risks ");
        answers.put("The project develops a \"smart\" heating thermostat. The control algorithms of the thermostat were modeled as Matlab/Simulink models and run on the internet connected server. The thermostat uses the specifications of the server to trigger the heating valves. \n" +
                "The test manager has defined the following test strategy/approach in the test plan: \n" +
                "1. The acceptance test for the whole system is executed as an experience-based test. \n" +
                "2. The control algorithms on the server are checked against standard of the energy saving regulation. \n" +
                "3. The functional test of the thermostat is performed as risk-based testing. \n" +
                "4. The security tests of data / communication via the internet are executed together with external security experts. \n" +
                "\n" +
                "What four common types of test strategies/approaches did the test manager implement in the test plan?\n", "b) analytical, standard-compliant, consultative and reactive ");
        answers.put("Which one of the following is the characteristic of a metrics-based approach for test estimation?", "a) Budget which was used by a previous similar test project ");
//      5.3 Test monitoring, control, and completion
        answers.put("Which of the following metrics would be MOST useful to monitor during test execution?", "a) Percentage of executed test cases ");
        answers.put("Which one of the following is NOT included in a test summary report?", "a) Defining pass/fail criteria and objectives of testing ");
//      5.4 Configuration management

//      5.5 Defect management
        answers.put("You are testing a new version of software for a coffee machine. The machine can prepare different types of coffee based on four categories. i.e., coffee size, sugar, milk, and syrup. The criteria are as follows: \n" +
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
                "What valuable information was omitted in the above defect report? \n", "b) Identification of the tested software version");

//      6.1 Tool support for testing
        answers.put("Which one of the following is MOST likely to be a benefit of test execution tools?", "d) It is easy to run regression tests ");
        answers.put("Which one of the following test tools is mostly suitable for developers rather than testers?", "c) Defect management tools ");
//      6.2 Benefits and risk of test automation

        return answers;
    };

}
