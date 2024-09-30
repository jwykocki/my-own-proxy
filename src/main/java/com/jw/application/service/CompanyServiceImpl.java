package com.jw.application.service;

import com.jw.application.dao.CompanyDao;
import com.jw.application.model.Company;
import com.jw.framework.MyTransactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyDao companyDao;

    @Override
    @MyTransactional
    public void createCompany(Company company) {
        log.info("SERVICE:   START - create company");
        companyDao.createCompany(company);
//        createNewCompany(company);
        log.info("SERVICE:   END - create company");
    }

    @MyTransactional
    public void createNewCompany(Company company) {
        companyDao.createCompany(company);
    }
}
