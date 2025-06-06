package com.ada.company.domain;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class Company {

    private Long idCompany;
    private String codeCompany;
    private String companyName;
    private String descriptionCompany;

    public String getCodeCompany() {
        return codeCompany;
    }

    public void setCodeCompany(String codeCompany) {
        this.codeCompany = codeCompany;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescriptionCompany() {
        return descriptionCompany;
    }

    public void setDescriptionCompany(String descriptionCompany) {
        this.descriptionCompany = descriptionCompany;
    }

    public Long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Long idCompany) {
        this.idCompany = idCompany;
    }
}
