package com.example.query_Service.configKafka;

import java.util.Date;

public interface Event {
    String getType();
    default Date getCreatedDate(){
        return new Date();
    }
}
