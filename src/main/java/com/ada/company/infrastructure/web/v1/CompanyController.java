package com.ada.company.infrastructure.web.v1;

import com.ada.company.application.ports.in.CompanyService;
import com.ada.company.infrastructure.web.dtos.CompanyDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;


    @Operation(summary = "getAllCompanies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Companies List.")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CompanyDto> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @Operation(summary = "getCompanyById")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "CompanyId was found.")
    })
    @GetMapping("/{companyId}")
    @ResponseStatus(HttpStatus.OK)
    public CompanyDto getCompanyById(@PathVariable Long companyId) throws Exception {
        return companyService.getCompanyById(companyId);
    }

    @Operation(summary = "createCompany")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Company was created.")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyDto createCompany(@RequestBody CompanyDto companyDto) throws Exception {
        return companyService.createCompany(companyDto);
    }

    @Operation(summary = "updateCompany")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Company was updated.")
    })
    @PutMapping("/{companyId}")
    @ResponseStatus(HttpStatus.OK)
    public CompanyDto updateCompany(@PathVariable Long companyId, CompanyDto companyDto) throws Exception {
        return companyService.updateCompany(companyId, companyDto);
    }

    @Operation(summary = "deleteCompany")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Company was deleted.")
    })
    @DeleteMapping("/{companyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long companyId) throws Exception {
        companyService.deleteCompany(companyId);
    }
}
