package com.example.project.command.Contoller;

import com.example.project.command.Entity.SubstanceEntity;
import com.example.project.command.Service.SubstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/substances")
public class SubstanceController {
    private final SubstanceService substanceServices;
    @Autowired
    public SubstanceController(SubstanceService substanceservices) {
        this.substanceServices = substanceservices;
    }
    @PostMapping
    public void registerNewSubstance(@RequestBody SubstanceEntity substance){
        substanceServices.addNewSubstance(substance);
    }
    @PutMapping("/{substanceId}")
    public void updateSubstance(
            @PathVariable("substanceId") Long substanceId,
            @RequestBody SubstanceEntity updatedSubstance) {
        substanceServices.updateSubstance(substanceId, updatedSubstance);
    }
    @DeleteMapping("/{substanceId}")
    public void deleteSubstance(@PathVariable("substanceId") Long substanceId){
        substanceServices.deleteSubstance(substanceId);
    }
}
