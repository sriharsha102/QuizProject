package com.questions.QuestionsService.services.implemtation;

import com.questions.QuestionsService.entities.Question;
import com.questions.QuestionsService.repository.QuestionRepository;
import com.questions.QuestionsService.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuestionImplementation implements QuestionService {
    private QuestionRepository questionRepository;

    QuestionImplementation(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepository.findAll();
    }

    @Override
    public Question getOne(Long id) {
        return questionRepository.findById(id).orElseThrow(()-> new RuntimeException());
    }

    @Override
    public List<Question> getQuestionOfQuiz(Long quizId) {
       return questionRepository.findByQuizId(quizId);
    }
}

