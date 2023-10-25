package com.example.query_Service.Controller;

import com.example.query_Service.Entity.SubstanceEntity;
import com.example.query_Service.Service.SubstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/substances")
public class SubstanceController {
    private final SubstanceService substanceService;

    @Autowired
    public SubstanceController(SubstanceService substanceService) {
        this.substanceService = substanceService;
    }

    @GetMapping
    public ResponseEntity<List<SubstanceEntity>> getAllSubstances() {
        List<SubstanceEntity> substances = substanceService.getAllSubstances();
        return new ResponseEntity<>(substances, HttpStatus.OK);
    }
    @GetMapping("/{idSubstance}")
    public ResponseEntity<SubstanceEntity> getSubstance(@PathVariable("idSubstance") String substanceId) {
        Optional<SubstanceEntity> substance= substanceService.getSubstance(substanceId);
        return new ResponseEntity(substance, HttpStatus.OK);
    }
}