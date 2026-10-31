package com.example.demo.repository;

import com.example.demo.entity.RaspunsTest;
import com.example.demo.entity.RaspunsTestKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaspunsTestRepository extends JpaRepository<RaspunsTest, RaspunsTestKey> {
}
