package com.example.command_Service.Repository;

import com.example.command_Service.Entity.SubstanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubstanceRepository extends JpaRepository<SubstanceEntity,Long> {
}
