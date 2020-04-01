package com.example.peoplelist;

import android.app.Application;

public class myApplication extends Application {

    private ContactList contactList = new ContactList();







    public ContactList getContactList() {
        return contactList;
    }

    public void setContactList(ContactList contactList) {
        this.contactList = contactList;
    }

}
