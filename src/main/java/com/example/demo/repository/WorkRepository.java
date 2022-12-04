package com.example.demo.repository;

import com.example.demo.domain.WorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkRepository extends JpaRepository<WorkEntity, Long> {
    List<WorkEntity> findAllByResumeId(Long resumeId);
}
