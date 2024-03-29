package dev.natashamo.job_vacancy_management.modules.companies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.natashamo.job_vacancy_management.modules.companies.entities.JobEntity;
import dev.natashamo.job_vacancy_management.modules.companies.useCases.CreateJobUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/jobs")
public class JobController {
  @Autowired
  private CreateJobUseCase createJobUseCase;

  @PostMapping()
  public ResponseEntity<Object> create(@Valid @RequestBody JobEntity jobEntity) {
    try {
      var job = this.createJobUseCase.execute(jobEntity);

      return ResponseEntity.status(201).body(job);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
