package com.example.rk.service;

import com.example.rk.mapper.QuestionMapper;
import com.example.rk.pojo.ApiResponse;
import com.example.rk.pojo.Question;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;


public interface QuestionService {
    Question questionMapperSelectById(Long id);

    List<Question> selectAllQuestion();

    int insertQuestion(Question question);
    int updateQuestion(Question question);
    int deleteQuestionById(Long id);

    List<Question> selectListDataQuestion(LocalDate createDate);

    ApiResponse handInsertRequest(Question  question);





}
