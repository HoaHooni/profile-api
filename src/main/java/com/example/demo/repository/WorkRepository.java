package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.WorkEntity;
@Repository
public interface WorkRepository extends JpaRepository<WorkEntity, Long> {
	List<WorkEntity> findAllByResumeId(Long resumeId);
}
