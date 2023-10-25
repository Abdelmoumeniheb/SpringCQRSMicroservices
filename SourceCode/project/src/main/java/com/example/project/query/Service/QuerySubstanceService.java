package com.example.project.query.Service;

import com.example.project.query.Entity.SubstanceEntity;
import com.example.project.query.Repository.SubstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuerySubstanceService {
    private final SubstanceRepository substanceRepository;

    @Autowired
    public QuerySubstanceService(SubstanceRepository substanceRepository) {
        this.substanceRepository = substanceRepository;
    }

    public List<SubstanceEntity> getAllSubstances() {
        return substanceRepository.findAll();
    }
    public Optional<SubstanceEntity> getSubstance(String substanceId){
        return substanceRepository.findById(substanceId);
    }
}