package com.example.query_Service.configKafka;

import com.example.query_Service.Entity.SubstanceEntity;

public class UpdateEvent implements Event{
    private SubstanceEntity sub;

    public UpdateEvent(SubstanceEntity sub) {
        this.sub = sub;
    }

    public UpdateEvent() {
    }

    public void setSubstance(SubstanceEntity sub) {
        this.sub = sub;
    }

    public SubstanceEntity getSubstance() {
        return sub;
    }

    @Override
    public String getType() {
        return "UPDATE";
    }
}
