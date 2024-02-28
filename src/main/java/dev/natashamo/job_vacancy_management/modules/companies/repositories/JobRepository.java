package dev.natashamo.job_vacancy_management.modules.companies.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.natashamo.job_vacancy_management.modules.companies.entities.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {

}
