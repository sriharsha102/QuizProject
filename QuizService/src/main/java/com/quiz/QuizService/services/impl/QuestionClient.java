package com.quiz.QuizService.services.impl;


import com.quiz.QuizService.entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="QUESTIONSSERVICE")
public interface QuestionClient {


    @GetMapping("/question/quiz/{quizId}")
    List<Question> getQuestionQuiz(@PathVariable Long quizId) ;

}
