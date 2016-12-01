package ua.softgroup.sgMessenger.dataBase.models;


import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Vadim on 15.11.2016.
 **/
public class UserModel extends RealmObject {

    private String name;
    private String lastName;
    private String position;
    private String dateOfBirth;
    private String password;
    private RealmList<ContactModel> phones;
    private RealmList<ContactModel> emails;

    public UserModel() {}

    public UserModel(String name, String lastName, String position, String dateOfBirth, RealmList<ContactModel> phones, RealmList<ContactModel> emails) {
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", password='" + password + '\'' +
                ", phones=" + phones +
                ", emails=" + emails +
                '}';
    }
}







