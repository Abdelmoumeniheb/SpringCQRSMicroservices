package com.example.project.query.Contoller;

import com.example.project.query.Entity.SubstanceEntity;
import com.example.project.query.Service.QuerySubstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/substances")
public class QuerySubstanceController {
    private final QuerySubstanceService QuerysubstanceService;

    @Autowired
    public QuerySubstanceController(QuerySubstanceService substanceService) {
        this.QuerysubstanceService = substanceService;
    }

    @GetMapping
    public ResponseEntity<List<SubstanceEntity>> getAllSubstances() {
        List<SubstanceEntity> substances = QuerysubstanceService.getAllSubstances();
        return new ResponseEntity<>(substances, HttpStatus.OK);
    }
    @GetMapping("/{idSubstance}")
    public ResponseEntity<SubstanceEntity> getSubstance(@PathVariable("idSubstance") String substanceId) {
        Optional<SubstanceEntity> substance= QuerysubstanceService.getSubstance(substanceId);
        return new ResponseEntity(substance, HttpStatus.OK);
    }
}
