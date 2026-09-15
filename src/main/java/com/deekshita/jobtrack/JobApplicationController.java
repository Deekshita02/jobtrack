package com.deekshita.jobtrack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {

    @Autowired
    private JobApplicationRepository repository;

    // GET all applications
    @GetMapping
    public List<JobApplicationEntity> getAll() {
        return repository.findAll();
    }

    // GET applications filtered by status
    @GetMapping("/status/{status}")
    public List<JobApplicationEntity> getByStatus(@PathVariable String status) {
        return repository.findByStatus(status);
    }

    // GET one application by id
    @GetMapping("/{id}")
    public JobApplicationEntity getOne(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found with id " + id));
    }

    // CREATE a new application
    @PostMapping
    public JobApplicationEntity create(@RequestBody JobApplicationEntity application) {
        return repository.save(application);
    }

    // UPDATE an existing application
    @PutMapping("/{id}")
    public JobApplicationEntity update(@PathVariable Long id, @RequestBody JobApplicationEntity updated) {
        JobApplicationEntity existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found with id " + id));

        existing.setCompany(updated.getCompany());
        existing.setRole(updated.getRole());
        existing.setStatus(updated.getStatus());
        existing.setAppliedDate(updated.getAppliedDate());
        existing.setNotes(updated.getNotes());

        return repository.save(existing);
    }

    // DELETE an application
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}