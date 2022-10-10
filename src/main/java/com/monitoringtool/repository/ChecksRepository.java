package com.monitoringtool.repository;

import com.monitoringtool.model.Checks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChecksRepository extends JpaRepository<Checks, Long>{
}
