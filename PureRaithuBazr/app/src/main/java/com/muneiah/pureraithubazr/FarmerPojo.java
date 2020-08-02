package com.muneiah.pureraithubazr;

import java.io.Serializable;

public class FarmerPojo implements Serializable
{
    String name;
    String email;
    String mobile;
    String password;
    String confirmpassword;

    public FarmerPojo(String name, String email, String mobile, String password, String confirmpassword) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.confirmpassword = confirmpassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
}
