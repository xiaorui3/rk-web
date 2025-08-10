package com.example.rk.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 每日一题
 * 用的是Question实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyQuestion {
    /**
     * Multiple choice-选择题
     * Fill in the blanks-填空题
     * short answer questions-问答题
     */
    private final int MULTIPLE_CHOICES = 1;
    private final int FILL_IN_THE_BLANKS=2;
    private final int SHORT_ANSWER_QUESTIONS=3;
    //发布时间
    private LocalDateTime submitTime;
    private int questionType;
    // 选择题的属性
    private String QuestionMultipleChoiceTopic;//选择题题目
    private HashMap<Integer,String>  QuestionMultipleChoiceOption; // ABCD选项和选项本体
    private String QuestionMultipleChoiceCorrectAnswer; // 正确答案（存储数字，如"1,3"）

    // 将Map转为字符串（用于存储到数据库）
    public String getQuestionMultipleChoiceOptionAsString() {
        if (QuestionMultipleChoiceOption == null || QuestionMultipleChoiceOption.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, String> entry : QuestionMultipleChoiceOption.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("||");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }

    // 将字符串解析为Map（修正类型不一致问题）
    public void setQuestionMultipleChoiceOptionFromString(String optionStr) {
        if (optionStr == null || optionStr.isEmpty()) {
            this.QuestionMultipleChoiceOption = new HashMap<>(); // 改为HashMap
            return;
        }
        HashMap<Integer, String> options = new HashMap<>(); // 改为HashMap
        String[] pairs = optionStr.split("\\|\\|");
        for (String pair : pairs) {
            String[] keyValue = pair.split("=", 2);
            if (keyValue.length == 2) {
                try {
                    int key = Integer.parseInt(keyValue[0]);
                    options.put(key, keyValue[1]);
                } catch (NumberFormatException e) {
                }
            }
        }
        this.QuestionMultipleChoiceOption = options; // 类型匹配
    }


}
