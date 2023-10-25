package com.example.project.command.config_kafka;

import java.util.Date;

public interface Event {
    String getType();
    default Date getCreatedDate(){
        return new Date();
    }
}
