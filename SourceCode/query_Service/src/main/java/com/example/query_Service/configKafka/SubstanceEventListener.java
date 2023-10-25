package com.example.query_Service.configKafka;

import com.example.query_Service.Entity.SubstanceEntity;
import com.example.query_Service.Repository.SubstanceRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class SubstanceEventListener {


    private static final Logger LOGGER = LoggerFactory.getLogger(
            SubstanceEventListener.class
    );
    private final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final SubstanceRepository substanceRepository;

    @Autowired
    public SubstanceEventListener(SubstanceRepository substanceRepositor){
        this.substanceRepository = substanceRepositor;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "query-service")
    void listener(String message){
        try{
            Map<String,String> subEvent = objectMapper.readValue(message,Map.class);
            if(subEvent.get("type").equals("CREATE")){
                CreateEvent createSubstanceEvent = objectMapper.readValue(message,CreateEvent.class);
                SubstanceEntity sub = createSubstanceEvent.getSubstance();
                substanceRepository.save(sub);
            } else if (subEvent.get("type").equals("UPDATE")) {
                UpdateEvent updateSubstanceEvent = objectMapper.readValue(message,UpdateEvent.class);
                SubstanceEntity sub = updateSubstanceEvent.getSubstance();
                System.out.println(sub);
                if(substanceRepository.findById(String.valueOf(sub.getId())).isPresent()){
                    String docId = substanceRepository.findById(String.valueOf(sub.getId())).get().getId();
                    SubstanceEntity saveSubstance = new SubstanceEntity(
                            docId,
                            sub.getCategories(),
                            sub.getLabel(),
                            sub.getUnit(),
                            sub.getVisibility(),
                            sub.getCreationDate(),
                            sub.getThemes()
                    );
                    substanceRepository.save(saveSubstance);
                }else{
                    System.out.println("User Doesnt Exist");
                }
            }else if (subEvent.get("type").equals("DELETE")) {
                DeleteEvent deleteSubsatnceEvent = objectMapper.readValue(message,DeleteEvent.class);
                substanceRepository.deleteById(String.valueOf(deleteSubsatnceEvent.getId()));
            }else{
                System.out.println("Unknown Event Type");
            }
        }catch(Exception e){
            LOGGER.error("Substance Listener Exception",e);
        }
    }
}
