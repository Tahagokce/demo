package com.example.demo.repository;

import com.example.demo.entity.Lov;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LovRepository extends JpaRepository<Lov, Long> {
    List<Lov> findAllByGroupOrderByDisplayName(String group);
}
