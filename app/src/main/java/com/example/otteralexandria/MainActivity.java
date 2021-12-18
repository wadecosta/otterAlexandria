package com.example.otteralexandria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LibraryDb db;
    private List<User> userList;
    private List<Book> bookList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        db = LibraryDb.getInstance(this);
        db.populateInitialData();


        Button CreateButton = (Button) findViewById(R.id.account_menu);
        CreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newAccount();
            }
        });


        Button ManageButton = (Button) findViewById(R.id.manage_system_menu);
        ManageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageSystem();
            }
        });


        Button HoldButton = (Button)findViewById(R.id.place_hold_menu);
        HoldButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }



    public void newAccount() {
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }

    public void manageSystem() {
        Intent intent = new Intent(this, ManageSystemActivity.class);
        startActivity(intent);
    }

    public void login() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }





}