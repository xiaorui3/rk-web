package com.hd.alumni.repository;

import com.hd.alumni.entity.Application;
import com.hd.alumni.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    @EntityGraph(attributePaths = {"user", "reviewer"})
    Page<Application> findByUser(User user, Pageable pageable);

    Page<Application> findByStatus(Application.Status status, Pageable pageable);

    @EntityGraph(attributePaths = {"user", "reviewer"})
    Page<Application> findByUserAndStatus(User user, Application.Status status, Pageable pageable);
    
    List<Application> findByVisitDate(LocalDate visitDate);
    
    long countByStatus(Application.Status status);
    
    long countByUserAndStatus(User user, Application.Status status);

    @Query("SELECT DISTINCT a FROM Application a LEFT JOIN FETCH a.files")
    Page<Application> findAllWithFiles(Pageable pageable);

    @Query("SELECT DISTINCT a FROM Application a LEFT JOIN FETCH a.files WHERE a.status = :status")
    Page<Application> findByStatusWithFiles(@Param("status") Application.Status status, Pageable pageable);

    // 添加以下方法
    @Query("SELECT DISTINCT a FROM Application a " +
            "LEFT JOIN FETCH a.files " +
            "LEFT JOIN FETCH a.user " +  // 加载申请人信息
            "LEFT JOIN FETCH a.reviewer " +  // 加载审核人信息
            "ORDER BY a.submitDate DESC")
    Page<Application> findAllWithFilesAndUsers(Pageable pageable);

    @Query("SELECT DISTINCT a FROM Application a " +
            "LEFT JOIN FETCH a.files " +
            "LEFT JOIN FETCH a.user " +
            "LEFT JOIN FETCH a.reviewer " +
            "WHERE a.status = :status " +
            "ORDER BY a.submitDate DESC")
    Page<Application> findByStatusWithFilesAndUsers(
            @Param("status") Application.Status status,
            Pageable pageable);



}