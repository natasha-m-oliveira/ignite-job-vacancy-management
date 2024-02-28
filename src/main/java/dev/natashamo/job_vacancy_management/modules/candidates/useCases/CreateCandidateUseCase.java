package dev.natashamo.job_vacancy_management.modules.candidates.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.natashamo.job_vacancy_management.exceptions.UserAlreadyExistsExeption;
import dev.natashamo.job_vacancy_management.modules.candidates.CandidateEntity;
import dev.natashamo.job_vacancy_management.modules.candidates.CandidateRepository;

@Service
public class CreateCandidateUseCase {
  @Autowired
  private CandidateRepository candidateRepository;

  public CandidateEntity execute(CandidateEntity candidateEntity) {
    this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent((candidate) -> {
          throw new UserAlreadyExistsExeption();
        });

    return this.candidateRepository.save(candidateEntity);
  }
}
