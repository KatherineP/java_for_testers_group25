package com.example.tests.ContactTests;

public class ContactData implements Comparable<ContactData>{
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

        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public int compareTo(ContactData other) {
        return this.email.compareTo(other.email);
    }
}
