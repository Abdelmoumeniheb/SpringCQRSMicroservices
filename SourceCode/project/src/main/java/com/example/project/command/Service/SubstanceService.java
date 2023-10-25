package com.example.project.command.Service;

import com.example.project.command.Entity.SubstanceEntity;
import com.example.project.command.Repository.SubstanceRepository;
import com.example.project.command.config_kafka.CreateEvent;
import com.example.project.command.config_kafka.DeleteEvent;
import com.example.project.command.config_kafka.EventHandler;
import com.example.project.command.config_kafka.UpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.NoSuchElementException;

@Service
public class SubstanceService {
    private final EventHandler eventHandler;
    private final SubstanceRepository substanceRepository;
    @Autowired
    public SubstanceService(SubstanceRepository substanceRepository, EventHandler eventHandler) {
        this.substanceRepository = substanceRepository;
        this.eventHandler = eventHandler;
    }
    public SubstanceEntity addNewSubstance(SubstanceEntity substance) {
        SubstanceEntity saveSubstance = substanceRepository.save(substance);
        System.out.println(saveSubstance);
        CreateEvent event = new CreateEvent(substance);
        eventHandler.publishEvent(event);
        return saveSubstance;
    }
    public void updateSubstance(Long substanceId, SubstanceEntity updatedSubstance) {
        SubstanceEntity existingSubstance = substanceRepository.findById(substanceId)
                .orElseThrow(() -> new NoSuchElementException("Substance with ID " + substanceId + " not found"));
        existingSubstance.setCategories(updatedSubstance.getCategories());
        existingSubstance.setLabel(updatedSubstance.getLabel());
        existingSubstance.setUnit(updatedSubstance.getUnit());
        existingSubstance.setVisibility(updatedSubstance.getVisibility());
        existingSubstance.setCreationDate(new Date());
        existingSubstance.setThemes(updatedSubstance.getThemes());

        substanceRepository.save(existingSubstance);
        UpdateEvent event =new UpdateEvent(existingSubstance);
        eventHandler.publishEvent(event);
    }
    public void deleteSubstance(Long studentId) {
        boolean exists = substanceRepository.existsById(studentId);
        if(!exists){
            throw  new IllegalStateException("student with id "+studentId+" does not exists");
        }
        substanceRepository.deleteById(studentId);
        DeleteEvent event = new DeleteEvent(studentId);
        eventHandler.publishEvent(event);
    }
}
