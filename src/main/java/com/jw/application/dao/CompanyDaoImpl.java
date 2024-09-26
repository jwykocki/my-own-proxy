package com.jw.application.dao;

import com.jw.application.model.Company;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompanyDaoImpl implements CompanyDao {

    @Override
    public void createCompany(Company company) {
        log.info("DAO:   START - create company");
        // --- creating company
        log.info("DAO:   END - create company");
    }
}
