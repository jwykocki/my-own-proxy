package com.jw;

import com.jw.application.dao.CompanyDao;
import com.jw.application.dao.CompanyDaoImpl;
import com.jw.application.model.Company;
import com.jw.application.service.CompanyService;
import com.jw.application.service.CompanyServiceImpl;
import com.jw.framework.ProxyHandler;

import java.lang.reflect.Proxy;


public class Main {
    public static void main(String[] args) {

        CompanyDao companyDao = new CompanyDaoImpl();
        CompanyService companyService = new CompanyServiceImpl(companyDao);

        ProxyHandler proxyHandler = new ProxyHandler(companyService);
        CompanyService companyServiceProxy = (CompanyService) Proxy.newProxyInstance(companyService.getClass().getClassLoader(), companyService.getClass().getInterfaces(), proxyHandler);

        companyServiceProxy.createCompany(new Company());
    }
}