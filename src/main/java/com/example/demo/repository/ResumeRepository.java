package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.ResumeEntity;
@Repository
public interface ResumeRepository extends JpaRepository<ResumeEntity, Long>{

}
