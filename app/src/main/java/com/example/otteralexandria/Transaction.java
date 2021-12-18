package com.example.otteralexandria;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "transactionBank")

public class Transaction {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "message")
    private String message;

    public Transaction(String message){
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
