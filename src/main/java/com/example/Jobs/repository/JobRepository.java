package com.example.Jobs.repository;

import com.example.Jobs.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Repository
public interface JobRepository extends JpaRepository<Job, UUID>, JpaSpecificationExecutor<Job> {
//    Optional<Job> findByProfileId(@NonNull String profileId);

    default Job findOneByIDElseThrow(@NonNull final UUID jobID) {
        return this.findById(jobID)
                .orElseThrow(() -> new EntityNotFoundException("Not Found"));
    }
}