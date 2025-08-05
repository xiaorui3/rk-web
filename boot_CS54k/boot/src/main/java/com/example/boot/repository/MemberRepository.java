package com.example.boot.repository;

import com.example.boot.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    @Modifying
    @Query("UPDATE Member m SET m.status = :status WHERE m.id IN :ids")
    void updateStatusByIds(@Param("ids") List<Integer> ids,
                           @Param("status") Member.AttendanceStatus status);
    @Query("SELECT m FROM Member m WHERE m.status = 'CHECKED_IN'")
    List<Member> findCheckedInMembers();

    @Query("SELECT m FROM Member m WHERE m.status = 'CHECKED_OUT'")
    List<Member> findCheckedOutMembers();

    List<Member> findByNameContainingIgnoreCaseOrPositionContainingIgnoreCase(String name, String position);

    @Modifying
    @Query("UPDATE Member m SET m.status = 'CHECKED_IN', m.lastCheckinTime = CURRENT_TIMESTAMP WHERE m.id IN :ids")
    void checkInMembers(@Param("ids") List<Integer> ids);

    @Modifying
    @Query("UPDATE Member m SET m.status = 'CHECKED_OUT', m.lastCheckoutTime = CURRENT_TIMESTAMP WHERE m.id IN :ids")
    void checkOutMembers(@Param("ids") List<Integer> ids);
}