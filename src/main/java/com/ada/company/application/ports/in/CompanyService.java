package com.ada.company.application.ports.in;

import com.ada.company.infrastructure.web.dtos.CompanyDto;

import java.util.List;

public interface CompanyService {
    List<CompanyDto> getAllCompanies();
    CompanyDto getCompanyById(int id) throws Exception;
    CompanyDto createCompany(CompanyDto company) throws Exception;
    CompanyDto updateCompany(int id, CompanyDto company) throws Exception;
    void deleteCompany(int id) throws Exception;
}
