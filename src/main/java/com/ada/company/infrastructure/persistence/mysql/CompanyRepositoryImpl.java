package com.ada.company.infrastructure.persistence.mysql;

import com.ada.company.application.mappers.CompanyMapper;
import com.ada.company.application.ports.out.CompanyRepository;
import com.ada.company.domain.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CompanyRepositoryImpl implements CompanyRepository {

    private final CompanyMapper companyMapper;
    private final CompanyJpa companyJpa;


    @Override
    public List<Company> findAll() {
        List<CompanyModel> companiesModel = companyJpa.findAll();
        return companyMapper.companyModelListToCompany(companiesModel);
    }

    @Override
    public Company findById(int id) {
        CompanyModel companyModel = companyJpa.findById(id).orElse(null);
        return companyMapper.companyModelToCompany(companyModel);
    }

    @Override
    public Company save(Company company) {
        CompanyModel companyModel = companyMapper.companyToCompanyModel(company);
        companyJpa.save(companyModel);
        return companyMapper.companyModelToCompany(companyModel);
    }

    @Override
    public void delete(int companyId) {
        companyJpa.deleteById(companyId);

    }
}
