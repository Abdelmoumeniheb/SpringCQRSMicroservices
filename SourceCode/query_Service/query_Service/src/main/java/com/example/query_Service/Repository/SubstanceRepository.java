package com.example.query_Service.Repository;

import com.example.query_Service.Entity.SubstanceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubstanceRepository extends MongoRepository<SubstanceEntity, String> {

}