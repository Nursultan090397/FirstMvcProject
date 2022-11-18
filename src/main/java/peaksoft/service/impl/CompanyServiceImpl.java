package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Company;
import peaksoft.repository.CompanyRepository;
import peaksoft.service.CompanyService;


import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    public final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.getAllCompanies();
    }

    @Override
    public void saveCompany(Company company) {
        companyRepository.saveCompany(company);

    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.getCompanyById(id);
    }

    @Override
    public void updateCompany(Company company) {
        companyRepository.updateCompany(company);

    }

    @Override
    public void deleteCompany(Company company) {
        companyRepository.deleteCompany(company);

    }
}
