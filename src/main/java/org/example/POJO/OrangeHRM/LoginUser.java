package org.example.POJO.OrangeHRM;

import io.cucumber.java.ParameterType;

public class LoginUser {


    private String validEmail;
    private String validPassword;
    private String invalidEmail;
    private String invalidPassword;

    public LoginUser(String validEmail, String validPassword, String invalidEmail, String invalidPassword) {
        this.validEmail = validEmail;
        this.validPassword = validPassword;
        this.invalidEmail = invalidEmail;
        this.invalidPassword = invalidPassword;
    }

    public String getValidEmail() {
        return validEmail;
    }

    public void setValidEmail(String validEmail) {
        this.validEmail = validEmail;
    }

    public String getValidPassword() {
        return validPassword;
    }

    public void setValidPassword(String validPassword) {
        this.validPassword = validPassword;
    }

    public String getInvalidEmail() {
        return invalidEmail;
    }

    public void setInvalidEmail(String invalidEmail) {
        this.invalidEmail = invalidEmail;
    }

    public String getInvalidPassword() {
        return invalidPassword;
    }

    public void setInvalidPassword(String invalidPassword) {
        this.invalidPassword = invalidPassword;
    }




}
