package dev.natashamo.job_vacancy_management.modules.companies.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.natashamo.job_vacancy_management.modules.companies.entities.JobEntity;
import dev.natashamo.job_vacancy_management.modules.companies.repositories.JobRepository;

@Service
public class CreateJobUseCase {
  @Autowired
  private JobRepository jobRepository;

  public JobEntity execute(JobEntity jobEntity) {
    return this.jobRepository.save(jobEntity);
  }
}
