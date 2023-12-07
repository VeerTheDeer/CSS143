import java.util.ArrayList;

public class QuizTracker implements Cloneable {
    private ArrayList<QuizScore> scores;

    public QuizTracker() {
        this.scores = new ArrayList<>();
    }

    public ArrayList<QuizScore> getScores() {
        return scores;
    }

    public void add(QuizScore quizScore) {
        scores.add(quizScore.clone());
    }

    @Override
    public QuizTracker clone() {
        try {
            QuizTracker clonedTracker = (QuizTracker) super.clone();
            clonedTracker.scores = new ArrayList<>();
            for (QuizScore score : scores) {
                clonedTracker.scores.add(score.clone());
            }
            return clonedTracker;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning failed: " + e.getMessage(), e);
        }
    }
}
