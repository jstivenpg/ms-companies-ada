package com.ada.company.application.ports.in;

import com.ada.company.infrastructure.web.dtos.CompanyDto;

import java.util.List;

public interface CompanyService {
    List<CompanyDto> getAllCompanies();
    CompanyDto getCompanyById(Long idCompany) throws Exception;
    CompanyDto createCompany(CompanyDto company) throws Exception;
    CompanyDto updateCompany(Long idCompany, CompanyDto company) throws Exception;
    void deleteCompany(Long idCompany) throws Exception;
}
