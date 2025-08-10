package com.example.rk.mapper;


import com.example.rk.pojo.DailyQuestion;
import com.example.handler.HashMapTypeHandler;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface DailyQuestionMapper {

    /**
     * 根据ID查询单个题目
     */
    @Select("SELECT " +
            "id, " +
            "question_content, " +
            "question_type, " +
            "question_multiple_choice_option, " +
            "correct_answer, " +
            "create_time, " +
            "update_time " +
            "FROM daily_question " +
            "WHERE id = #{id}")
    @Results(id = "dailyQuestionResultMap", value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "question_content", property = "questionContent"),
            @Result(column = "question_type", property = "questionType"),
            @Result(
                    column = "question_multiple_choice_option",
                    property = "questionMultipleChoiceOption",
                    typeHandler = HashMapTypeHandler.class
            ),
            @Result(column = "correct_answer", property = "correctAnswer"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    DailyQuestion selectById(Integer id);

    /**
     * 查询所有题目
     */
    @Select("SELECT * FROM daily_question ORDER BY create_time DESC")
    @ResultMap("dailyQuestionResultMap") // 复用上面定义的ResultMap
    List<DailyQuestion> selectAll();

    /**
     * 新增题目
     */
    @Insert("INSERT INTO daily_question (" +
            "question_content, " +
            "question_type, " +
            "question_multiple_choice_option, " +
            "correct_answer, " +
            "create_time, " +
            "update_time" +
            ") VALUES (" +
            "#{questionContent}, " +
            "#{questionType}, " +
            "#{questionMultipleChoiceOption, typeHandler=com.example.handler.HashMapTypeHandler}, " +
            "#{correctAnswer}, " +
            "#{createTime}, " +
            "#{updateTime}" +
            ")")
    @Options(useGeneratedKeys = true, keyProperty = "id") // 自动生成主键并回填
    int insert(DailyQuestion dailyQuestion);

    /**
     * 更新题目
     */
    @Update("UPDATE daily_question SET " +
            "question_content = #{questionContent}, " +
            "question_type = #{questionType}, " +
            "question_multiple_choice_option = #{questionMultipleChoiceOption, typeHandler=com.example.handler.HashMapTypeHandler}, " +
            "correct_answer = #{correctAnswer}, " +
            "update_time = #{updateTime} " +
            "WHERE id = #{id}")
    int update(DailyQuestion dailyQuestion);

    /**
     * 根据ID删除题目
     */
    @Delete("DELETE FROM daily_question WHERE id = #{id}")
    int deleteById(Integer id);
}
