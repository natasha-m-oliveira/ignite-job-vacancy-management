package dev.natashamo.job_vacancy_management.modules.companies.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthCompanyDTO {
  @NotNull
  private String password;

  @NotNull
  private String username;
}
