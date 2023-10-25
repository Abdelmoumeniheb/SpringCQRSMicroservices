package com.example.query_Service.configKafka;

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
