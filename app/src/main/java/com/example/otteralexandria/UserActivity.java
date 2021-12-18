package com.example.otteralexandria;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import androidx.appcompat.app.AppCompatActivity;

public class UserActivity extends AppCompatActivity implements View.OnClickListener {

    private LibraryDb db;
    Button createButton;

    EditText userInput, passInput;
    String username = "", password = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity);

        createButton = (Button)findViewById(R.id.create_account_button);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "TEST", Toast.LENGTH_SHORT).show();

                userInput = findViewById(R.id.username_input);
                username = userInput.getText().toString();

                passInput = findViewById(R.id.password_input);
                password = passInput.getText().toString();



                if(username.equals("") || password.equals("")){
                    Toast.makeText(getApplicationContext(), "Please Enter Details", Toast.LENGTH_SHORT).show();
                }
                else if (db.user().usernameExists(username)){
                    Toast.makeText(getApplicationContext(),"Duplicate Username. Enter a new username and password to create account.", Toast.LENGTH_SHORT).show();
                }
                else {
                    db = LibraryDb.getInstance(getApplicationContext());
                    User temp = new User(username,password,"consumer");
                    db.user().addUser(temp);
                    Toast.makeText(getApplicationContext(), "Added New User", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }


    @Override
    public void onClick(View v) {

    }
}
