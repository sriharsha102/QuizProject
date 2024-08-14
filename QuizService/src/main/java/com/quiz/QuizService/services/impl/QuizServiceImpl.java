package com.quiz.QuizService.services.impl;

import com.quiz.QuizService.entities.Quiz;
import com.quiz.QuizService.repositories.QuizRepository;
import com.quiz.QuizService.services.Quizservice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class QuizServiceImpl implements Quizservice {

    private QuizRepository quizRepository;

    private QuestionClient questionClient;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }


    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {

        List<Quiz> quizzes =quizRepository.findAll();
        List<Quiz> newQuizList= quizzes.stream().map(quiz -> {quiz.setQuestions(questionClient.getQuestionQuiz(quiz.getId()));return quiz;}).collect(Collectors.toList());
        return newQuizList;
    }

    @Override
    public Quiz get(Long id) {
       Quiz quiz= quizRepository.findById(id).orElseThrow(()->new RuntimeException("quiz not found"));
       quiz.setQuestions(questionClient.getQuestionQuiz(quiz.getId()));
       return quiz;
    }



}