package com.example.tests.ContactTests;

public class ContactData implements Comparable<ContactData>{
    private String firstname;
    private String ID;
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

    public ContactData(String firstname, String group, String byear, String bday, String email, String home, String lastname, String ID, String address, String mobile, String bmonth) {
        this.firstname = firstname;
        this.group = group;
        this.byear = byear;
        this.bday = bday;
        this.email = email;
        this.home = home;
        this.lastname = lastname;
        this.ID = ID;
        this.address = address;
        this.mobile = mobile;
        this.bmonth = bmonth;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", ID='" + ID + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactData)) return false;

        ContactData that = (ContactData) o;

        if (ID != null && that.ID != null) {
            if (!ID.equals(that.ID)) {
                return false;
            }
//            if (firstname != null && that.firstname != null && !firstname.equals(that.firstname)) return false;
//            if (lastname != null && that.lastname != null && !lastname.equals(that.lastname)) return false;
            if (!firstname.equals(that.firstname)) return false;
            if (!lastname.equals(that.lastname)) return false;


        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = firstname.hashCode();
        result = 31 * result + ID.hashCode();
        result = 31 * result + lastname.hashCode();
        return result;
    }

    public ContactData withFirstname (String firstname){
        this.firstname = firstname;
        return this;
    }

    public ContactData withID (String ID){
        this.ID = ID;
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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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




    @Override
    public int compareTo(ContactData other) {
        if (this.ID == null) return 1;
        if (other.ID == null) return -1;
        return Integer.valueOf(this.ID).compareTo(Integer.valueOf(other.ID));

    }
}