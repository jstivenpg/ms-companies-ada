package com.ada.company.domain;

import com.ada.company.Utils.Constants.ResponseCode;
import com.ada.company.application.mappers.CompanyMapper;
import com.ada.company.application.ports.in.CompanyService;
import com.ada.company.application.ports.out.CompanyRepository;
import com.ada.company.infrastructure.web.dtos.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyUseCase implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public List<CompanyDto> getAllCompanies() {
        List<Company> companiesEntity = companyRepository.findAll();
        return companyMapper.companyListToDto(companiesEntity);
    }

    @Override
    public CompanyDto getCompanyById(Long id) throws Exception {
        Company companyEntity = companyRepository.findById(id);
        if( companyEntity == null) {
            throw new Exception(String.valueOf(ResponseCode.COMPANY_NOT_FOUND));
        }
        return companyMapper.companyToDto(companyEntity);
    }

    @Override
    public CompanyDto createCompany(CompanyDto company) throws Exception {
        Company companyEntity = companyMapper.dtoToCompany(company);
        return saveCompany(companyEntity);
    }

    @Override
    public CompanyDto updateCompany(Long idCompany, CompanyDto company) throws Exception {
        Company companyEntity = companyRepository.findById(idCompany);
        companyEntity.setIdCompany(idCompany);
        companyEntity.setCodeCompany(company.codeCompany());
        companyEntity.setCompanyName(company.companyName());
        companyEntity.setDescriptionCompany(company.descriptionCompany());
        return saveCompany(companyEntity);
    }

    @Override
    public void deleteCompany(Long idCompany) throws Exception {
        try {
            companyRepository.delete(idCompany);
        } catch ( Exception e ) {
            throw new Exception(String.valueOf(ResponseCode.COMPANY_NOT_DELETED));
        }
    }

    private CompanyDto saveCompany(Company company) throws Exception {
        try {
            return companyMapper.companyToDto(companyRepository.save(company));
        } catch (Exception e) {
            throw new Exception(String.valueOf(ResponseCode.UNEXPECTED_ERROR), e);
        }
    }
}
