package com.example.otteralexandria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AdminMenu extends AppCompatActivity {
    private LibraryDb db;
    private List<User> userList;
    private List<Book> bookList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.admin_menu);

        db = LibraryDb.getInstance(this);
        db.populateInitialData();


        Button CreateButton = (Button) findViewById(R.id.add_book_menu);
        CreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newBook();
            }
        });


        Button ManageButton = (Button) findViewById(R.id.view_logs_menu);
        ManageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewLogs();
            }
        });
    }


    public void newBook() {
        Intent intent = new Intent(this, AddBook.class);
        startActivity(intent);
    }

    public void viewLogs() {
        Intent intent = new Intent(this, ManageSystemActivity.class);
        startActivity(intent);
    }


}
