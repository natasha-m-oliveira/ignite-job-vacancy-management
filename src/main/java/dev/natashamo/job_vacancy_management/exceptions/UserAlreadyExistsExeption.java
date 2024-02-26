package dev.natashamo.job_vacancy_management.exceptions;

public class UserAlreadyExistsExeption extends RuntimeException {
  public UserAlreadyExistsExeption() {
    super("User already exists");
  }
}
