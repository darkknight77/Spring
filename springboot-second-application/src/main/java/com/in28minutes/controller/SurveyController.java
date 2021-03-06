package com.in28minutes.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.model.Question;
import com.in28minutes.service.SurveyService;

@RestController
public class SurveyController {
    
	@Autowired
	private SurveyService surveyService;
	
	@GetMapping("/surveys/{surveyId}/questions")
	private List<Question> retrieveQuestionsForSurvey(@PathVariable String surveyId) {
		// TODO Auto-generated method stub

		return surveyService.retrieveQuestions(surveyId);
		
	}
	

	@GetMapping("/surveys/{surveyId}/questions/{questionId}")
	private Question retrieveDetailsForQuestion(@PathVariable String surveyId,@PathVariable String questionId) {
		// TODO Auto-generated method stub

		return surveyService.retrieveQuestion(surveyId,questionId);
		
	}
	

	@PostMapping("/surveys/{surveyId}/questions")
 private ResponseEntity<?> add(@PathVariable String surveyId, @RequestBody Question question) {

        Question createdTodo = surveyService.addQuestion(surveyId, question);

        if (createdTodo == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(location).build();

    }	
}
