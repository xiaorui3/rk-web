package com.example.rk.controller;

import com.example.rk.pojo.ApiResponse;
import com.example.rk.pojo.Question;
import com.example.rk.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;


    @PostMapping("/question/insert")
    public ResponseEntity<ApiResponse> insertQuestion(@RequestBody Question question) {
        System.out.println("*****************************************************");
        System.out.println("question:   "+question);
        ApiResponse response = questionService.handInsertRequest(question);
        if (response.isSuccess()){
            return ResponseEntity.ok(response);
        }else{
            return ResponseEntity.badRequest().body(response);
        }
    }
    public int updateQuestion(Question question) {
        return questionService.updateQuestion(question);
    }
    public int deleteQuestionById(Long id) {
        return questionService.deleteQuestionById(id);
    }
    public List<Question> selectAllQuestion() {
        return questionService.selectAllQuestion();
    }
    public List<Question> selectListDataQuestion(LocalDate createDate) {
        return questionService.selectListDataQuestion(createDate);
    }
    public Question selectQuestionById(Long id) {
        return questionService.questionMapperSelectById(id);
    }


}
