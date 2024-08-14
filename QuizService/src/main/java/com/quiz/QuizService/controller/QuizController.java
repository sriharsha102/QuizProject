package com.quiz.QuizService.controller;


import com.quiz.QuizService.entities.Quiz;
import com.quiz.QuizService.services.Quizservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

   private Quizservice quizservice;

  QuizController(Quizservice quizservice){
       this.quizservice=quizservice;
   }

 @GetMapping
public List<Quiz> getAll(){
    return quizservice.get();
}


@PostMapping("/create")
public  Quiz create(@RequestBody Quiz quiz){
      return  quizservice.add(quiz);
}

@GetMapping("/{id}")
public  Quiz getOne(@PathVariable Long id){
      return quizservice.get(id);
}




}
