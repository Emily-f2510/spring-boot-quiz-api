package com.example.demo.service;

import com.example.demo.repository.CerinteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CerinteService {

    private final CerinteRepository repo;

    public CerinteService(CerinteRepository repo) {
        this.repo = repo;
    }

    public List<Object[]> c3a() { return repo.cerinta_3a(); }
    public List<Object[]> c3b() { return repo.cerinta_3b(); }


    public List<Object[]> c4a() { return repo.cerinta_4a(); }
    public List<Object[]> c4b() { return repo.cerinta_4b(); }


    public List<Object[]> c5a() { return repo.cerinta_5a(); }
    public List<Object[]> c5b() { return repo.cerinta_5b(); }


    public List<Object[]> c6a() { return repo.cerinta_6a(); }
    public List<Object[]> c6b() { return repo.cerinta_6b(); }
}
