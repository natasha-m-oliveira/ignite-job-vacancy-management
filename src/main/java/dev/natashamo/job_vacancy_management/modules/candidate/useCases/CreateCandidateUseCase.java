package dev.natashamo.job_vacancy_management.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.natashamo.job_vacancy_management.exceptions.CandidateAlreadyExistsExeption;
import dev.natashamo.job_vacancy_management.modules.candidate.CandidateEntity;
import dev.natashamo.job_vacancy_management.modules.candidate.CandidateRepository;

@Service
public class CreateCandidateUseCase {
  @Autowired
  private CandidateRepository candidateRepository;

  public CandidateEntity execute(CandidateEntity candidateEntity) {
    this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent((candidate) -> {
          throw new CandidateAlreadyExistsExeption();
        });

    return this.candidateRepository.save(candidateEntity);
  }
}
