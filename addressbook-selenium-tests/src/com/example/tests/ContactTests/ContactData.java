package com.example.tests.ContactTests;

public class ContactData implements Comparable<ContactData>{
    private String firstname;
    private String lastname;
    private String address;
    private String home;
    private String mobile;
    private String email;
    private String bday;
    private String bmonth;
    private String byear;
    private String group;

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



    @Override
    public String toString() {
        return "ContactData{" +
                "email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactData)) return false;

        ContactData that = (ContactData) o;

        if (!email.equals(that.email)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }


    @Override
    public int compareTo(ContactData other) {
        return this.email.toLowerCase().compareTo(other.email.toLowerCase());

    }

    public ContactData withFirstname (String firstname){
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastname (String lastname){
        this.lastname = lastname;
        return this;
    }
    public ContactData withAddress(String address){
        this.address = address;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withBday(String bday) {
        this.bday = bday;
        return this;
    }

    public ContactData withBmonth(String bmonth) {
        this.bmonth = bmonth;
        return  this;
    }

    public ContactData withByear(String byear) {
        this.byear = byear;
        return  this;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getGroup() {
        return group;
    }


    public String getByear() {
        return byear;
    }


    public String getBmonth() {
        return bmonth;
    }


    public String getBday() {
        return bday;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getHome() {
        return home;
    }


    public String getAddress() {
        return address;
    }

    public String getLastname() {
        return lastname;
    }

}
