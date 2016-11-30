package jdroidcoder.ua.sgsocialnetwork.models;

/**
 * Created by Admin on 29.11.2016.
 */

public class UserModel {
    private String name;
    private String lastName;
    private int age;
    private ContactModel[] phones;
    private ContactModel[] emaels;

    public UserModel(String name, String lastName, int age, ContactModel[] phones, ContactModel[] emaels) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.phones = phones;
        this.emaels = emaels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ContactModel[] getPhones() {
        return phones;
    }

    public void setPhones(ContactModel[] phones) {
        this.phones = phones;
    }

    public ContactModel[] getEmaels() {
        return emaels;
    }

    public void setEmaels(ContactModel[] emaels) {
        this.emaels = emaels;
    }
}
