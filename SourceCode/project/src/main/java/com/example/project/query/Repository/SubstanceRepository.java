package com.example.project.query.Repository;

import com.example.project.query.Entity.SubstanceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("mongoSubstanceRepository")
public interface SubstanceRepository extends MongoRepository<SubstanceEntity, String> {

}
