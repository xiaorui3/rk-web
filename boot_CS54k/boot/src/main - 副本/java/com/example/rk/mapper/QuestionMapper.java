package com.example.rk.mapper;


import com.example.rk.util.HashMapTypeHandler;
import com.example.rk.util.ListTypeHandler;
import com.example.rk.pojo.Question;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

public interface QuestionMapper {

    /**
     * 根据ID查询题目（通用查询，自动适配题型）
     */
    @Select("SELECT * FROM question WHERE id = #{id}")
    @Results(id = "questionResultMap", value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "question_content", property = "questionContent"),
            @Result(column = "question_type", property = "questionType"),
            @Result(
                    column = "options",
                    property = "options",
                    typeHandler = HashMapTypeHandler.class
            ),
            @Result(
                    column = "correct_answers",
                    property = "correctAnswers",
                    typeHandler = ListTypeHandler.class
            ),
            @Result(column = "reference_answer", property = "referenceAnswer"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    Question selectById(Long id);

    /**
     * 按题型查询题目
     * @param type 1：选择题，2：填空题，3：问答题
     */
    @Select("SELECT * FROM question WHERE question_type = #{type} ORDER BY create_time DESC")
    @ResultMap("questionResultMap")
    List<Question> selectByType(Integer type);

    /**
     * 查询所有题目
     */
    @Select("SELECT * FROM question ORDER BY create_time DESC")
    @ResultMap("questionResultMap")
    List<Question> selectAll();

    /**
     * 新增题目（通用方法，根据题型自动处理字段）
     */
    @Insert("INSERT INTO question (" +
            "question_content, " +
            "question_type, " +
            "options, " +
            "correct_answers, " +
            "reference_answer, " +
            "create_time, " +
            "update_time" +
            ") VALUES (" +
            "#{questionContent}, " +
            "#{questionType}, " +
            "#{options, typeHandler=com.example.handler.HashMapTypeHandler}, " +
            "#{correctAnswers, typeHandler=com.example.handler.ListTypeHandler}, " +
            "#{referenceAnswer}, " +
            "#{createTime}, " +
            "#{updateTime}" +
            ")")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Question question);

    /**
     * 更新题目
     */
    @Update("UPDATE question SET " +
            "question_content = #{questionContent}, " +
            "question_type = #{questionType}, " +
            "options = #{options, typeHandler=com.example.handler.HashMapTypeHandler}, " +
            "correct_answers = #{correctAnswers, typeHandler=com.example.handler.ListTypeHandler}, " +
            "reference_answer = #{referenceAnswer}, " +
            "update_time = #{updateTime} " +
            "WHERE id = #{id}")
    int update(Question question);

    /**
     * 根据ID删除题目
     */
    @Delete("DELETE FROM question WHERE id = #{id}")
    int deleteById(Long id);

    /**
     * 按添加日期查询题目
     * @param createDate 题目添加日期
     * @return 该日期添加的所有题目
     */
    @Select("SELECT * FROM question WHERE DATE(create_time) = #{createDate} ORDER BY create_time DESC")
    @ResultMap("questionResultMap")
    List<Question> listDataQuestion(LocalDate createDate);
}
