package dev.natashamo.job_vacancy_management.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.natashamo.job_vacancy_management.exceptions.UserAlreadyExistsExeption;
import dev.natashamo.job_vacancy_management.modules.company.entities.CompanyEntity;
import dev.natashamo.job_vacancy_management.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {
  @Autowired
  private CompanyRepository companyRepository;

  public CompanyEntity execute(CompanyEntity companyEntity) {
    this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
        .ifPresent((company) -> {
          throw new UserAlreadyExistsExeption();
        });

    return this.companyRepository.save(companyEntity);
  }
}
