package com.example.project.query.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "substances")
public class SubstanceEntity {
    @Id
    private String id;
    private List<String> categories;
    private String label;
    private String unit;
    private String visibility;
    private Date creationDate;
    private String themes;

    public SubstanceEntity(List<String> categories, String label, String unit, String visibility, Date creationDate, String themes) {
        this.categories = categories;
        this.label = label;
        this.unit = unit;
        this.visibility = visibility;
        this.creationDate = creationDate;
        this.themes = themes;
    }
    public SubstanceEntity(String id,List<String> categories, String label, String unit, String visibility, Date creationDate, String themes) {
        this.id=id;
        this.categories = categories;
        this.label = label;
        this.unit = unit;
        this.visibility = visibility;
        this.creationDate = creationDate;
        this.themes = themes;
    }
}