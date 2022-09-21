package com.example.Jobs.entities;

import com.example.Jobs.utils.JobStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author - AvanishKishorPandey
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Job{
    @Id
    private UUID id = UUID.randomUUID();

    @Column(nullable = false)
    private String title;

    public Job(String title) {
        this.title=title;
    }

}
