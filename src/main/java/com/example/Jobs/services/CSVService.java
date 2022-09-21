package com.example.Jobs.services;

import com.example.Jobs.entities.Job;
import com.example.Jobs.helper.CSVHelper;
import com.example.Jobs.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
public class CSVService {
    @Autowired
    JobRepository repository;

    public void save(MultipartFile file) {
        try {
            List<Job> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("failed to store csv data: " + e.getMessage());
        }
    }

    public List<Job> getAllJobs() {
        return repository.findAll();
    }
}
