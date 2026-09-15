package com.deekshita.jobtrack;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplicationEntity, Long> {

    List<JobApplicationEntity> findByStatus(String status);

}