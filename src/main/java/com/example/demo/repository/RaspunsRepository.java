package com.example.demo.repository;

import com.example.demo.entity.Raspuns;
import com.example.demo.entity.RaspunsKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaspunsRepository extends JpaRepository<Raspuns, RaspunsKey> {
}
