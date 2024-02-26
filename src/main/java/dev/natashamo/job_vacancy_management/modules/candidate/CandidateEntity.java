package dev.natashamo.job_vacancy_management.modules.candidate;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CandidateEntity {
  private UUID id;
  @Length(min = 3)
  private String name;

  @NotBlank()
  @Pattern(regexp = "\\S+", message = "must not contain spaces")
  private String username;

  @Email()
  private String email;

  @Length(min = 10, max = 100)
  private String password;
  private String description;
  private String curriculum;
}
