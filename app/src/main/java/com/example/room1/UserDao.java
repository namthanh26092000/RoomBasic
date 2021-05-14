package com.example.room1;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE id IN (:id)")
    List<User> loadAllByIds(int[] id);

    @Query("SELECT * FROM user WHERE name LIKE :first")
    User findByName(String first);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}
