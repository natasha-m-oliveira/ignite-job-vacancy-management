package dev.natashamo.job_vacancy_management.exceptions;

public class CandidateAlreadyExistsExeption extends RuntimeException {
  public CandidateAlreadyExistsExeption() {
    super("Candidate already exists");
  }
}
