package com.example.query_Service.Service;

import com.example.query_Service.Entity.SubstanceEntity;
import com.example.query_Service.Repository.SubstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubstanceService {
    private final SubstanceRepository substanceRepository;

    @Autowired
    public SubstanceService(SubstanceRepository substanceRepository) {
        this.substanceRepository = substanceRepository;
    }

    public List<SubstanceEntity> getAllSubstances() {
        return substanceRepository.findAll();
    }
    public Optional<SubstanceEntity> getSubstance(String substanceId){
        return substanceRepository.findById(substanceId);
    }
}
