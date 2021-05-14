package com.example.room1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnAdd;
    private EditText editName;
    private RecyclerView recyclerView;
    private Adapter adapter;
    private List<User> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"personData")
                .allowMainThreadQueries()
                .build();
        UserDao userDao = db.userDao();
//        list= userDao.getAll();
        addControl();
        btnAdd= findViewById(R.id.btnAdd);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });
    }
    private void initUI(){
        btnAdd=findViewById(R.id.btnAdd);
        recyclerView=findViewById(R.id.rcv);
    }
    private void add(){
        String edit = editName.getText().toString().trim();
        if(TextUtils.isEmpty(edit)){
            return;
        }
        User user = new User(edit);
        AppDatabase.getInstance(this).userDao().insertAll(user);
        Toast.makeText(this,"Add Name",Toast.LENGTH_SHORT).show();
        editName.setText("");
    }
    private void addControl(){
        AppDatabase db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"personData")
                .allowMainThreadQueries()
                .build();
        UserDao userDao = db.userDao();
        adapter=new Adapter(this);
        adapter.setData(userDao.getAll());
        recyclerView= findViewById(R.id.rcv);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
    }
}