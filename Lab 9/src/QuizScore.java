public class QuizScore implements Cloneable {
    private int score;

    public QuizScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public QuizScore clone() {
        try {
            return (QuizScore) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("CloneNotSupportedException should not be thrown", e);
        }
    }
}
