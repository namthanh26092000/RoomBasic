package com.example.room1;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

        public static final String DATABASE_NAME ="user.db";
        public static AppDatabase instance;
        public static synchronized AppDatabase getInstance(Context context){
                if(instance==null){
                        instance= Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,DATABASE_NAME)
                                .allowMainThreadQueries()
                                .build();
                }
                return instance;

        }
        public abstract UserDao userDao();
}
