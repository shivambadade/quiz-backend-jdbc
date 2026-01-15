package com.example.quizapp.controller;

import com.example.quizapp.service.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    private final QuizService service;

    public QuizController(QuizService service) {
        this.service = service;
    }

    @GetMapping("/questions")
    public Object questions() {
        return service.getQuestions();
    }

    @PostMapping("/submit")
    public Object submit(@RequestBody Map<Integer, String> answers) {
        return service.submit(answers);
    }
}
