package com.example.project.command.Repository;

import com.example.project.command.Entity.SubstanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jpaSubstanceRepository")
public interface SubstanceRepository extends JpaRepository<SubstanceEntity,Long> {
}
