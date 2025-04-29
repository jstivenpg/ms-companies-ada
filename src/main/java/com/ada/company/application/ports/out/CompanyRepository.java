package com.ada.company.application.ports.out;

import com.ada.company.domain.Company;

import java.util.List;

public interface CompanyRepository {
    List<Company> findAll();
    Company findById(Long idCompany);
    Company save(Company company);
    void delete(Long idCompany);
}
