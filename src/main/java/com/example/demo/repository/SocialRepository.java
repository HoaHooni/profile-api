package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.SocialEntity;

@Repository
public interface SocialRepository extends JpaRepository<SocialEntity, Long>{
	List<SocialEntity> findByUserId(Long id);
	
	boolean existsByUserId(Long id);
}
