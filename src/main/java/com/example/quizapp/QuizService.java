package com.example.quizapp.service;

import com.example.quizapp.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizService {

	private final QuizRepository repo;

	public QuizService(QuizRepository repo) {
		this.repo = repo;
	}

	public List<Map<String, Object>> getQuestions() {
		return repo.findAll().stream().map(q -> {
			Map<String, Object> m = new HashMap<>();
			m.put("id", q.getId());
			m.put("question", q.getQuestion());
			m.put("options", List.of(
					q.getOptionA(),
					q.getOptionB(),
					q.getOptionC(),
					q.getOptionD()));
			return m;
		}).toList();
	}

	public Map<String, Integer> submit(Map<Integer, String> answers) {
		int score = 0;
		for (var e : answers.entrySet()) {
			if (repo.findById(e.getKey()).getCorrectOption()
					.equalsIgnoreCase(e.getValue())) {
				score++;
			}
		}
		return Map.of("score", score, "total", answers.size());
	}
}
