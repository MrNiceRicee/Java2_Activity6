package com.example.peoplelist;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactList {

    List<Person> contactList;

    public ContactList(List<Person> ContactList) {
        contactList = ContactList;
    }

    public ContactList(){
        Random random = new Random();
        Randomizer rd = new Randomizer();
        this.contactList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int gender = random.nextInt();
            if ((gender%2)==0){
                Person newPerson = new Person(rd.MaleName(),random.nextInt(42)+18,random.nextInt(32));
                this.contactList.add(newPerson);
            }else {
                Person newPerson = new Person(rd.FemaleName(),random.nextInt(42)+18,random.nextInt(32));
                this.contactList.add(newPerson);
            }
        }
    }

    public List<Person> getContactList() {
        return contactList;
    }

    public void setContactList(List<Person> contactList) {
        this.contactList = contactList;
    }



}
