package com.example.otteralexandria;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Login extends AppCompatActivity {

    private LibraryDb db;
    Button login;

    EditText userInput, passInput;
    String username = "", password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        db = LibraryDb.getInstance(this);

        login = (Button)findViewById(R.id.login_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userInput = findViewById(R.id.username_input);
                username = userInput.getText().toString();

                passInput = findViewById(R.id.password_input);
                password = passInput.getText().toString();

            }
        });


    }
}
