package com.example.otteralexandria;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;;

@Database(entities = {User.class, Book.class, Transaction.class}, version = 2, exportSchema = false)
public abstract class LibraryDb extends RoomDatabase {

    private static LibraryDb sInstance;
    public abstract UserDao user();
    public abstract BookDao book();
    public abstract TransactionDao transaction();

    public static synchronized LibraryDb getInstance(Context context){
        if(sInstance == null){
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                    LibraryDb.class,
                    "library.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return sInstance;
    }

    public void populateInitialData() {
        if(user().count() == 0){
            runInTransaction(() -> {

                user().addUser(
                        new User("Billy", "Bob", "Customer"));
                user().addUser(
                        new User("James", "Dean", "Customer"));
            });
        }
    }




    public void seed() {
        if(book().count() == 0) {
            // ...
        }
        if(user().count() == 0) {
            // ...
        }
    }
}

