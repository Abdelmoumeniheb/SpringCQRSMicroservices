package com.example.project.query.config_kafka;

public class DeleteEvent implements Event{
    private Long id;

    public DeleteEvent(Long id) {
        this.id = id;
    }
    public DeleteEvent(){

    }
    public Long getId() {
        return id;
    }

    @Override
    public String getType() {
        return "DELETE";
    }
}