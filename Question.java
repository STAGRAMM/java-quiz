public class Question {
    private String questionText;
    private String[] options;
    private int correctAnswer;

    // Constructor
    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    // Getter methods
    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean isCorrect(int answer) {
        return answer == correctAnswer;
    }

    public String getCorrectOption() {
        return options[correctAnswer - 1];
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}