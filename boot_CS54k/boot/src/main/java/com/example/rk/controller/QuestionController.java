package com.example.rk.controller;

import com.example.rk.pojo.ApiResponse;
import com.example.rk.pojo.Question;
import com.example.rk.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
@Controller
// 注意：@Controller注解与@RestController重复，保留@RestController即可
public class QuestionController {
    @Autowired
    private QuestionService questionService;


    @PostMapping("/question/insert")
    public ResponseEntity<ApiResponse> insertQuestion(@RequestBody Question question) {
        System.out.println("*****************************************************");
        System.out.println("question:   " + question);
        ApiResponse response = questionService.handInsertRequest(question);
        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }

    /**
     * 更新题目
     * 采用PUT方法，符合RESTful规范（更新资源）
     */
    @PutMapping("/question/update")
    public ResponseEntity<ApiResponse> updateQuestion(@RequestBody Question question) {
        if (question.getId() == null) {
            return ResponseEntity.badRequest().body(ApiResponse.error("题目ID不能为空"));
        }
        int rows = questionService.updateQuestion(question);
        if (rows > 0) {
            return ResponseEntity.ok(ApiResponse.success("题目更新成功"));
        } else {
            return ResponseEntity.badRequest().body(ApiResponse.error("题目更新失败，可能不存在该题目"));
        }
    }

    /**
     * 根据ID删除题目
     * 采用DELETE方法，符合RESTful规范（删除资源）
     */
    @DeleteMapping("/question/delete/{id}")
    public ResponseEntity<ApiResponse> deleteQuestionById(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().body(ApiResponse.error("题目ID不能为空"));
        }
        int rows = questionService.deleteQuestionById(id);
        if (rows > 0) {
            return ResponseEntity.ok(ApiResponse.success("题目删除成功"));
        } else {
            return ResponseEntity.badRequest().body(ApiResponse.error("题目删除失败，可能不存在该题目"));
        }
    }

    /**
     * 查询所有题目
     * 采用GET方法，符合RESTful规范（查询资源）
     */
    @GetMapping("/question/all")
    public ResponseEntity<ApiResponse> selectAllQuestion() {
        List<Question> questions = questionService.selectAllQuestion();
        return ResponseEntity.ok(ApiResponse.success("查询成功").addData("questions", questions));
    }

    /**
     * 根据日期查询题目列表
     * 采用GET方法，通过请求参数传递日期
     */
    @GetMapping("/question/by-date")
    public ResponseEntity<ApiResponse> selectListDataQuestion(@RequestParam LocalDate createDate) {
        if (createDate == null) {
            return ResponseEntity.badRequest().body(ApiResponse.error("查询日期不能为空"));
        }
        List<Question> questions = questionService.selectListDataQuestion(createDate);
        return ResponseEntity.ok(ApiResponse.success("查询成功").addData("questions", questions));
    }

    /**
     * 根据ID查询单个题目
     * 采用GET方法，通过路径变量传递ID
     */
    @GetMapping("/question/{id}")
    public ResponseEntity<ApiResponse> selectQuestionById(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().body(ApiResponse.error("题目ID不能为空"));
        }
        Question question = questionService.questionMapperSelectById(id);
        if (question != null) {
            return ResponseEntity.ok(ApiResponse.success("查询成功").addData("question", question));
        } else {
            return ResponseEntity.badRequest().body(ApiResponse.error("查询失败，可能不存在该题目"));
        }
    }
}