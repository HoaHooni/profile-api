package com.example.demo.repository;

import com.example.demo.domain.SocialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocialRepository extends JpaRepository<SocialEntity, Long> {
    List<SocialEntity> findByUserId(Long id);

    boolean existsByUserId(Long id);
}
