package com.example.otteralexandria;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bookBank")

public class Book {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "author")
    private String author;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "genre")
    private String genre;

    @ColumnInfo(name = "checkOut")
    private int checkOut = 0;

    @ColumnInfo(name = "reservationNumber")
    private String reservationNumber;

    public Book(String author, String title, String genre, int checkOut, String reservationNumber){
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.checkOut = checkOut;
        this.reservationNumber = reservationNumber;
    }



    @Override
    public String toString() {
        return this.title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(int checkOut) {
        this.checkOut = checkOut;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }
}
