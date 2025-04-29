package com.ada.company.application.mappers;

import com.ada.company.domain.Company;
import com.ada.company.infrastructure.persistence.mysql.CompanyModel;
import com.ada.company.infrastructure.web.dtos.CompanyDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.ERROR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface CompanyMapper {

    Company dtoToCompany(CompanyDto companydto);
    CompanyDto companyToDto(Company company);
    List<CompanyDto> companyListToDto(List<Company> company);

    Company companyModelToCompany(CompanyModel companyModel);
    List<Company> companyModelListToCompany(List<CompanyModel> companyModel);
    CompanyModel companyToCompanyModel(Company company);

}
