package com.example.inventmanege.models;

public class Worker {
    private int idworker;
    private String login;
    private String password;
    private String fullName;
    private int idrole;
    private int IdCompany;
    private String CompanyName;

    public Worker() {
    }

    public int getIdCompany() {
        return IdCompany;
    }

    public void setIdCompany(int idCompany) {
        IdCompany = idCompany;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public int getIdworker() {
        return idworker;
    }

    public void setIdworker(int idworker) {
        this.idworker = idworker;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getIdrole() {
        return idrole;
    }

    public void setIdrole(int idrole) {
        this.idrole = idrole;
    }

    public Worker(int idworker, String login, String password, String fullName, int idrole) {
        this.idworker = idworker;
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        this.idrole = idrole;
    }
}
