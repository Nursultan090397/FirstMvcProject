package peaksoft.service;

import peaksoft.model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();

    void saveCompany(Company company);

    Company getCompanyById(Long id);

    void updateCompany(Company company);

    void removeCompany(Company company);
}