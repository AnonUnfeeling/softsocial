package jdroidcoder.ua.sgsocialnetwork.models;

/**
 * Created by Admin on 29.11.2016.
 */
public class ContactModel {
    private String contact;
    private String identificate;

    public ContactModel(String contact, String identificate) {
        this.contact = contact;

        this.identificate = identificate;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getIdentificate() {
        return identificate;
    }

    public void setIdentificate(String identificate) {
        this.identificate = identificate;
    }
}
