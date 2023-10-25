package com.example.command_Service.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class SubstanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ElementCollection
    private List<String> categories;
    private String label;
    private String unit;
    private String visibility;
    private Date creationDate;
    private String themes;
    public SubstanceEntity(Long id, List<String> categories, String label, String unit, String visibility, Date creationDate, String themes){
        this.id = id;
        this.categories = categories;
        this.label = label;
        this.unit = unit;
        this.visibility = visibility;
        this.creationDate=creationDate;
        this.themes=themes;
    }
    public SubstanceEntity(List<String> categories, String label, String unit, String visibility, Date creationDate, String themes){
        this.categories = categories;
        this.label = label;
        this.unit = unit;
        this.visibility = visibility;
        this.creationDate=creationDate;
        this.themes=themes;
    }
}