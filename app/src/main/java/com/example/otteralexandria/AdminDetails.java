package com.example.otteralexandria;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.List;

public class AdminDetails extends AppCompatActivity {


    private LibraryDb db;
    private ListView userListView;
    private List<User> userList;
    private ArrayAdapter<User> userAdapter;
    private DialogFragment dialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_details);

        db = LibraryDb.getInstance(this);

        userList = db.user().getAll();
        userAdapter = new ArrayAdapter<>(this, R.layout.admin_details, userList);
        userListView.setAdapter(userAdapter);

        updateUI();


    }

    private void updateUI() {
        userList = db.user().getAll();
        if(userAdapter == null ) {
            userAdapter = new ArrayAdapter<>(this, R.layout.admin_details, userList);
            userListView.setAdapter(userAdapter);
        }
        else{
            userAdapter.clear();
            userAdapter.addAll(userList);
            userAdapter.notifyDataSetChanged();
        }

    }


}
