package com.example.command_Service.config_kafka;

import com.example.command_Service.Entity.SubstanceEntity;

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
