package com.example.query_Service.configKafka;

import com.example.query_Service.Entity.SubstanceEntity;

public class CreateEvent implements Event{
    private SubstanceEntity sub;

    public CreateEvent(SubstanceEntity sub) {
        this.sub = sub;
    }

    public CreateEvent() {
    }

    public void setSubstance(SubstanceEntity sub) {
        this.sub = sub;
    }

    public SubstanceEntity getSubstance() {
        return sub;
    }

    @Override
    public String getType() {
        return "CREATE";
    }
}
