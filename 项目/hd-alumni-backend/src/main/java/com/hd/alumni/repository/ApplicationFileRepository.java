package com.hd.alumni.repository;

import com.hd.alumni.entity.Application;
import com.hd.alumni.entity.ApplicationFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationFileRepository extends JpaRepository<ApplicationFile, Long> {
    
    List<ApplicationFile> findByApplication(Application application);
    
    void deleteByApplication(Application application);
}