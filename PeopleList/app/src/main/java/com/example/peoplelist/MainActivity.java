package com.example.peoplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    Button btn_add, btn_sortABC, btn_sortAGE;

    ListView lv_contactslist;

    PersonAdapter adapter;

    ContactList contactList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_add);
        btn_sortABC = findViewById(R.id.btn_sortabc);
        btn_sortAGE = findViewById(R.id.btn_sortage);
        lv_contactslist = findViewById(R.id.lv_contacts);

        contactList = ((myApplication) this.getApplication()).getContactList();

        adapter = new PersonAdapter(MainActivity.this, contactList);

        lv_contactslist.setAdapter(adapter);

        //listener for incoming messages

        Bundle incomingmessages = getIntent().getExtras();

        if (incomingmessages!= null) {
            //capture incoming data
            String name = incomingmessages.getString("name");
            int age = incomingmessages.getInt("age");
            int picture = incomingmessages.getInt("pictures");
            int positionEdited = incomingmessages.getInt("edited");




            //create new person object

            Person newPerson = new Person(name,age,picture);

            //add to list
            if (positionEdited > -1){
                contactList.getContactList().remove(positionEdited);
            }
            contactList.getContactList().add(newPerson);

            //update adapter

            adapter.notifyDataSetChanged();

        }
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( v.getContext(), newPersonForm.class);
                startActivity(intent);
            }
        });

        btn_sortABC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(contactList.getContactList());
                adapter.notifyDataSetChanged();
            }
        });

        btn_sortAGE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(contactList.getContactList(), new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.getAge() - o2.getAge();
                    }
                });
                adapter.notifyDataSetChanged();
            }
        });


        lv_contactslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editPerson(position);
            }
        });

    }

    public void editPerson(int position){
        Intent intent = new Intent(getApplicationContext(), newPersonForm.class);

        //get the contents of person at position

        Person editp = contactList.getContactList().get(position);
        intent.putExtra("edited",position);
        intent.putExtra("name", editp.getName());
        intent.putExtra("age", editp.getAge());
        intent.putExtra("picturenumber", editp.getPicNumber());

        startActivity(intent);
    }
}
