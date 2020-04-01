package com.example.peoplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class newPersonForm extends AppCompatActivity {

    Button btn_add, btn_cancel;
    EditText et_name, et_age, et_picture;

    int positionToEdit = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_person_form);

        btn_add = findViewById(R.id.btn_Add);
        btn_cancel = findViewById(R.id.btn_cancel);

        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_picture = findViewById(R.id.et_picture);

        //Listener for incoming data

        Bundle incomingIntent = getIntent().getExtras();

        if (incomingIntent!= null){
            String name = incomingIntent.getString("name");
            int age = incomingIntent.getInt("age");
            int picturenumber = incomingIntent.getInt("picturenumber");
            positionToEdit = incomingIntent.getInt("edited");

            //fill in the form
            et_name.setText(name);
            et_age.setText(Integer.toString(age));
            et_picture.setText(Integer.toString(picturenumber));
        }

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Declare variables
                String newName = et_name.getText().toString();
                String newAge = et_age.getText().toString();
                String newPicture = et_picture.getText().toString();

                //

                Log.d("mytag",newName + " " + newAge + " " + newPicture);

                Intent intent = new Intent(v.getContext(),MainActivity.class);
                intent.putExtra("name",newName);
                intent.putExtra("age", Integer.parseInt(newAge));
                intent.putExtra("picture", Integer.parseInt(newPicture));
                intent.putExtra("edited",positionToEdit);


                startActivity(intent);
            }
        });
    }
}
