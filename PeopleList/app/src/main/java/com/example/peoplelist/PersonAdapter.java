package com.example.peoplelist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonAdapter extends BaseAdapter {

    Activity mActivity;
    ContactList contactList;

    public PersonAdapter(Activity mActivity, ContactList contactList) {
        this.mActivity = mActivity;
        this.contactList = contactList;
    }

    @Override
    public int getCount() {
        return contactList.getContactList().size();
    }

    @Override
    public Person getItem(int position) {
        return contactList.getContactList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View onePersonLine;

        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        onePersonLine = inflater.inflate(R.layout.person_one_line,parent,false);

        TextView tv_name = onePersonLine.findViewById(R.id.tv_personame);
        TextView tv_age = onePersonLine.findViewById(R.id.tv_age);
        ImageView iv_profilepic = onePersonLine.findViewById(R.id.iv_profilepic);

        Person person = this.getItem(position);

        tv_name.setText(person.getName());
        tv_age.setText(Integer.toString(person.getAge()));

        int icon_resourece_numbers[] = {
                R.drawable.profile1,
                R.drawable.profile2,
                R.drawable.profile3,
                R.drawable.profile4,
                R.drawable.profile5,
                R.drawable.profile6,
                R.drawable.profile7,
                R.drawable.profile8,
                R.drawable.profile9,
                R.drawable.profile10,
                R.drawable.profile11,
                R.drawable.profile12,
                R.drawable.profile13,
                R.drawable.profile14,
                R.drawable.profile15,
                R.drawable.profile16,
                R.drawable.profile17,
                R.drawable.profile18,
                R.drawable.profile19,
                R.drawable.profile20,
                R.drawable.profile21,
                R.drawable.profile22,
                R.drawable.profile23,
                R.drawable.profile24,
                R.drawable.profile25,
                R.drawable.profile26,
                R.drawable.profile27,
                R.drawable.profile28,
                R.drawable.profile29,
                R.drawable.profile30,
                R.drawable.profile31,
                R.drawable.profile32
        };

        iv_profilepic.setImageResource(icon_resourece_numbers[person.getPicNumber()]);


        return onePersonLine;
    }
}
