package com.ada.company.infrastructure.persistence.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyJpa extends JpaRepository<CompanyModel, Integer> {
}
