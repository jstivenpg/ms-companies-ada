package com.ada.company.infrastructure.web.dtos;

import java.io.Serializable;

public record CompanyDto(
        Long idCompany,
        String codeCompany,
        String companyName,
        String descriptionCompany
) implements Serializable {
}
