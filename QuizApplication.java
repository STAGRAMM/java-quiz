import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizApplication {
    private List<Question> questions;
    private int score;
    private Scanner scanner;

    public QuizApplication() {
        this.questions = new ArrayList<>();
        this.score = 0;
        this.scanner = new Scanner(System.in);
        initializeQuestions();
    }

    private void initializeQuestions() {
        // Question 1
        questions.add(new Question(
            "Which keyword is used to declare a class in Java??",
            new String[]{"1. class", "2. define", "3. struct", "4. object"},
            1
        ));

        // Question 2
        questions.add(new Question(
            "Which programming language is known as the 'write once, run anywhere' language?",
            new String[]{"1. Python", "2. Java", "3. C++", "4. JavaScript"},
            2
        ));

        // Question 3
        questions.add(new Question(
            "What is the result of 5 + 3 * 2?",
            new String[]{"1. 16", "2. 11", "3. 10", "4. 13"},
            2
        ));

        // Question 4
        questions.add(new Question(
            "Which of these is NOT a primitive data type in Java?",
            new String[]{"1. int", "2. String", "3. boolean", "4. double"},
            2
        ));

        // Question 5
        questions.add(new Question(
            "What does OOP stand for?",
            new String[]{"1. Object-Oriented Programming", "2. Object-Optimized Process", 
                        "3. Operational Object Protocol", "4. Object-Oriented Protocol"},
            1
        ));
    }

    public void startQuiz() {
        System.out.println(" Welcome to the Java Quiz Application! ");
        System.out.println("===========================================");
        System.out.println("You will be presented with " + questions.size() + " questions.");
        System.out.println("Enter the number of your choice (1-4) for each question.\n");

        // Display and process each question
        for (int i = 0; i < questions.size(); i++) {
            Question currentQuestion = questions.get(i);
            displayQuestion(i + 1, currentQuestion);
            
            int userAnswer = getUserAnswer();
            checkAnswer(currentQuestion, userAnswer);
            System.out.println();
        }

        displayResults();
    }

    private void displayQuestion(int questionNumber, Question question) {
        System.out.println("Question " + questionNumber + ": " + question.getQuestionText());
        for (String option : question.getOptions()) {
            System.out.println(option);
        }
        System.out.print("Your answer: ");
    }

    private int getUserAnswer() {
        while (true) {
            try {
                int answer = scanner.nextInt();
                if (answer >= 1 && answer <= 4) {
                    return answer;
                } else {
                    System.out.print("Please enter a number between 1 and 4: ");
                }
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a number (1-4): ");
                scanner.next(); // Clear invalid input
            }
        }
    }

    private void checkAnswer(Question question, int userAnswer) {
        if (question.isCorrect(userAnswer)) {
            System.out.println(" Correct!");
            score++;
        } else {
            System.out.println(" Incorrect! The correct answer was: " + question.getCorrectOption());
        }
    }

    private void displayResults() {
        System.out.println(" Quiz Results ");
        System.out.println("===================");
        System.out.println("Total Questions: " + questions.size());
        System.out.println("Correct Answers: " + score);
        System.out.println("Wrong Answers: " + (questions.size() - score));
        
        double percentage = (double) score / questions.size() * 100;
        System.out.printf("Score: %.1f%%\n", percentage);

        // Performance feedback
        if (percentage >= 80) {
            System.out.println(" Excellent! You're a Java master! 🎉");
        } else if (percentage >= 60) {
            System.out.println(" Good job! Keep practicing!");
        } else if (percentage >= 40) {
            System.out.println(" Not bad! Review the basics and try again.");
        } else {
            System.out.println(" Don't give up! Practice makes perfect!");
        }
        
        scanner.close();
    }

    public static void main(String[] args) {
        QuizApplication quiz = new QuizApplication();
        quiz.startQuiz();
    }

}
