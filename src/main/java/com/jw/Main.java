package com.jw;

import com.jw.application.dao.CompanyDao;
import com.jw.application.dao.CompanyDaoImpl;
import com.jw.application.model.Company;
import com.jw.application.service.CompanyService;
import com.jw.application.service.CompanyServiceImpl;


public class Main {
    public static void main(String[] args) {

        CompanyDao companyDao = new CompanyDaoImpl();
        CompanyService companyService = new CompanyServiceImpl(companyDao);


        companyService.createCompany(new Company());
    }
}