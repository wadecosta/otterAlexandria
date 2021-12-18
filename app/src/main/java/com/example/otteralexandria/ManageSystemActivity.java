package com.example.otteralexandria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ManageSystemActivity extends AppCompatActivity implements View.OnClickListener {

    private LibraryDb db;
    Button manageActivity;

    EditText userInput, passInput;
    String username = "", password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_login);

        db = LibraryDb.getInstance(this);
        //db.populateInitialData();

        manageActivity = (Button)findViewById(R.id.login_button);

        manageActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "TEST", Toast.LENGTH_SHORT).show();

                userInput = findViewById(R.id.admin_user);
                username = userInput.getText().toString();

                passInput = findViewById(R.id.admin_password);
                password = passInput.getText().toString();



                if(username.equals("") || password.equals("")){
                    Toast.makeText(getApplicationContext(), "Please Enter Details", Toast.LENGTH_SHORT).show();
                }
                else if((username.equals("!admin2") && (password.equals("!admin2")))){
                    db = LibraryDb.getInstance(getApplicationContext());
                    User admin = new User("!admin2", "!admin2", "admin");
                    db.user().addUser(admin);
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                    adminDetails();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Invalid Login", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    public void adminDetails() {
        Intent intent = new Intent(this, AdminMenu.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {

    }
}
