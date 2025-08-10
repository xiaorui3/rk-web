// src/main/java/com/example/boot/mapper/ClubMemberMapper.java
package com.example.rk.mapper;

import com.example.rk.pojo.ClubMember;
import com.example.rk.pojo.JoinRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ClubMemberMapper {

    @Insert("INSERT INTO club_members (name, student_id, major, phone, email, interest, experience, submit_time) " +
            "VALUES (#{name}, #{studentId}, #{major}, #{phone}, #{email}, #{interest}, #{experience}, #{submitTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(ClubMember clubMember);

    @Insert("SELECT COUNT(*) FROM club_members WHERE student_id = #{studentId}")
    int countByStudentId(String studentId);

    @Select("select * from rkst.club_members where student_id=#{STU_Id}")
    JoinRequest selectOneIdJR(String STU_Id);
}