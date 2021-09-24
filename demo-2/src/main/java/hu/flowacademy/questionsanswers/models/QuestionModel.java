package hu.flowacademy.questionsanswers.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder(toBuilder = true)
@Data
public class QuestionModel {
    private final Long id;
    private final String category;
    private final String question;
    private final List<String> answers;
    private final String correctAnswer;
}
