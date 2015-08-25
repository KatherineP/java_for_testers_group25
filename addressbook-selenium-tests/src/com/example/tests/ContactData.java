package com.example.tests;

public class ContactData {
    public String firstname;
    public String lastname;
    public String address;
    public String home;
    public String mobile;
    public String email;
    public String bday;
    public String bmonth;
    public String byear;
    public String group;

    public ContactData() {

    }

    public ContactData(String firstname, String lastname, String address, String home, String mobile, String email, String bday, String bmonth, String byear, String group) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.email = email;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.group = group;
    }


}
