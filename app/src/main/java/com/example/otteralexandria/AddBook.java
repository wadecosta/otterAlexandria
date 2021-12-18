package com.example.otteralexandria;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddBook extends AppCompatActivity implements View.OnClickListener {

    private LibraryDb db;
    Button createButton;

    EditText titleInput, authorInput, genreInput;
    String title = "", author = "", genre = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_book);

        createButton = (Button)findViewById(R.id.create_account_button);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                titleInput = findViewById(R.id.title_input);
                title = titleInput.getText().toString();

                authorInput = findViewById(R.id.author_input);
                author = authorInput.getText().toString();

                genreInput = findViewById(R.id.genre_input);
                genre = genreInput.getText().toString();

                if(title.equals("") || author.equals("") || genre.equals("")){
                    Toast.makeText(getApplicationContext(), "Please Enter Details", Toast.LENGTH_SHORT).show();
                }
                else {
                    db = LibraryDb.getInstance(getApplicationContext());
                    Book temp = new Book(author,title,genre,0, "0");
                    db.book().addBook(temp);
                }


            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
