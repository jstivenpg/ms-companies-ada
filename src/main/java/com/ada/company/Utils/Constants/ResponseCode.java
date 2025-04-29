package com.ada.company.Utils.Constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {

    COMPANY_NOT_FOUND (404,"Company not found"),
    COMPANY_NOT_DELETED (400,"Company not deleted"),
    UNEXPECTED_ERROR (500,"Unexpected error");

    private final int httpStatus;
    private final String message;
}
