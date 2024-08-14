package com.questions.QuestionsService.services;

import com.questions.QuestionsService.entities.Question;

import java.util.List;

public interface QuestionService {

    Question createQuestion(Question question);
    List<Question> get();

    Question getOne(Long id);

    List<Question> getQuestionOfQuiz(Long quizId);

}
