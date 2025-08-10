package com.example.rk.pojo;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Data
public class Question {
    private Long id;
    private String questionContent; // 题干内容
    private Integer questionType; // 1：选择题，2：填空题，3：问答题

    // 选择题专用：选项（键为选项序号，值为选项内容）
    private HashMap<String, String> options;

    // 选择题/填空题专用：正确答案（多个答案用列表）
    private List<String> correctAnswers;

    // 问答题专用：参考答案（可包含代码）
    private String referenceAnswer;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
