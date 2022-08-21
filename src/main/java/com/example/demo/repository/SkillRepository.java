package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.SkillEntity;
@Repository
public interface SkillRepository extends JpaRepository<SkillEntity, Long>{
	List<SkillEntity> findAllByResumeId(Long resumeId);

}
