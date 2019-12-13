package com.example.workshopdsc;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RiddleAdapter riddleAdapter;
    private RiddleDictionary riddleDictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        getSupportActionBar().setTitle("Welcome, " + username + "!");

        riddleDictionary = RiddleDictionary.getInstance();
        recyclerView = findViewById(R.id.recyclerView);
        riddleAdapter = new RiddleAdapter();
        riddleAdapter.insertNewRiddles(riddleDictionary.getRiddles());

        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerView.setAdapter(riddleAdapter);
    }
}
