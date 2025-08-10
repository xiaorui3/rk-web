package com.example.rk.service.impl;

import com.example.rk.mapper.QuestionMapper;
import com.example.rk.pojo.ApiResponse;
import com.example.rk.pojo.Question;
import com.example.rk.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper  questionService;


    @Override
    public Question questionMapperSelectById(Long id) {
        return questionService.selectById( id);
    }

    @Override
    public List<Question> selectAllQuestion() {
        return questionService.selectAll();
    }

    @Override
    public int insertQuestion(Question question) {
        return questionService.insert( question);
    }

    @Override
    public int updateQuestion(Question question) {
        return questionService.update( question);
    }

    @Override
    public int deleteQuestionById(Long id) {
        return questionService.deleteById(id);
    }

    @Override
    public List<Question> selectListDataQuestion(LocalDate createDate) {
        return questionService.listDataQuestion(createDate);
    }

    @Override
    public ApiResponse handInsertRequest(Question question) {
        Question q =new Question();
        q.setQuestionContent(question.getQuestionContent());
        q.setQuestionType(question.getQuestionType());
        q.setOptions(question.getOptions());
        q.setCorrectAnswers(question.getCorrectAnswers());
        q.setReferenceAnswer(question.getReferenceAnswer());
        q.setId(question.getId());
        q.setCreateTime(question.getCreateTime());
        q.setUpdateTime(question.getUpdateTime());
        // 1：选择题，2：填空题，3：问答题
        if(question.getQuestionType()==1){
            if(question.getOptions().size() <2){
                return ApiResponse.error("单选题选项数量不能小于2");
            }
            if(question.getCorrectAnswers().size() != 1){
                return ApiResponse.error("单选题答案数量必须为1");
            }
            if(question.getCorrectAnswers().get(0).length() != 1){
                return ApiResponse.error("单选题答案长度必须为1");
            }
            if(question.getOptions().get("A").length() > 20 || question.getOptions().get("B").length() > 20 || question.getOptions().get("C").length() > 20 || question.getOptions().get("D").length() > 20){
                return ApiResponse.error("单选题选项长度不能超过20");
            }
            if(question.getReferenceAnswer().length() > 20){
                return ApiResponse.error("单选题参考答案长度不能超过20");
            }

            questionService.insert( q);
            return ApiResponse.success("题目添加成功").addData("QuestionID", q.getId());
        }else if(question.getQuestionType()==2){ //填空题
            if(question.getOptions().isEmpty()){
                return ApiResponse.error("填空题选项数量不能小于1");
            }
            if(question.getCorrectAnswers().size() != question.getOptions().size()){
                return ApiResponse.error("填空题答案数量必须与选项数量一致");
            }
            for(int i = 0; i < question.getOptions().size(); i++){
                if(question.getOptions().get(i).length() > 1000){
                    return ApiResponse.error("填空题选项长度不能超过1000");
                }
                if(question.getCorrectAnswers().get(i).length() > 1000){
                    return ApiResponse.error("填空题答案长度不能超过100");
                }
            }
            questionService.insert( q);
            return ApiResponse.success("题目添加成功").addData("QuestionID", q.getId());

        } else if(question.getQuestionType()==3){
            if(!question.getOptions().isEmpty()){
                return ApiResponse.error("问答题不能有选项！");
            }
            if(question.getReferenceAnswer().length() > 1000){
                return ApiResponse.error("问答题参考答案长度不能超过1000");
            }
            questionService.insert( q);
            return ApiResponse.success("题目添加成功").addData("QuestionID", q.getId());

        }
        return ApiResponse.error("题目类型错误");
    }


}
