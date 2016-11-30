package jdroidcoder.ua.sgsocialnetwork.models;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Admin on 29.11.2016.
 */
public class UserModel extends RealmObject {
    private String name;
    private String lastName;
    private String position;
    private int age;
    private RealmList<ContactModel> phones;
    private RealmList<ContactModel> emails;

    public UserModel() {
    }

    public UserModel(String name, String lastName, String position, int age, RealmList<ContactModel> phones, RealmList<ContactModel> emails) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.phones = phones;
        this.emails = emails;
        this.position = position;
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

    public RealmList<ContactModel> getPhones() {
        return phones;
    }

    public void setPhones(RealmList<ContactModel> phones) {
        this.phones = phones;
    }

    public RealmList<ContactModel> getEmails() {
        return emails;
    }

    public void setEmails(RealmList<ContactModel> emails) {
        this.emails = emails;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", age=" + age +
                ", phones=" + phones +
                ", emails=" + emails +
                '}';
    }
}
