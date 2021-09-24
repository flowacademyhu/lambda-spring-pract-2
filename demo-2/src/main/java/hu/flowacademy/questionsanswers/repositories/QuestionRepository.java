package hu.flowacademy.questionsanswers.repositories;

import hu.flowacademy.questionsanswers.models.QuestionModel;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class QuestionRepository {
    private final Map<Long, QuestionModel> questions = new HashMap<>();

    public QuestionModel save(QuestionModel questionModel) {
        var id = this.questions.size() + 1L;
        var question = questionModel.toBuilder().id(id).build();
        this.questions.put(id, question);
        return question;
    }

    public List<QuestionModel> findAll() {
        return new ArrayList<>(this.questions.values());
    }

    public Optional<QuestionModel> findRandom() {
        if (this.questions.isEmpty()) {
            return Optional.empty();
        }
        var randomIndex = new Random().nextInt(this.questions.size()); // 0-tól size-ig random szám
        var randomQuestion = new ArrayList<>(this.questions.values()).get(randomIndex);
        return Optional.of(randomQuestion);
    }

    public Optional<QuestionModel> findById(Long id) {
        return Optional.ofNullable(this.questions.get(id));
    }
}
