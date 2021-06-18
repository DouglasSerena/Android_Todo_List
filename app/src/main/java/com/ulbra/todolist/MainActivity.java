package com.ulbra.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ulbra.todolist.R;
import com.ulbra.todolist.adapter.TaskAdapter;
import com.ulbra.todolist.models.Task;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ArrayList<Task> tasks = new ArrayList<Task>();

    FloatingActionButton btnAddTask;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        btnAddTask = findViewById(R.id.btnAdd);
        recyclerView = findViewById(R.id.recyclerView);

        btnAddTask.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), AddTaskActivity.class);
            startActivity(intent);
        });

        tasks.add(new Task("Manha", "preciso comer e tomar cafe", "2021-06-18", true));
        tasks.add(new Task("Manha", "preciso comer e tomar cafe", "2021-06-18", true));
        tasks.add(new Task("Manha", "preciso comer e tomar cafe", "2021-06-18", true));
        tasks.add(new Task("Manha", "preciso comer e tomar cafe", "2021-06-18", true));

        createRecycler();
    }

    public void createRecycler() {
        TaskAdapter taskAdapter = new TaskAdapter(getApplicationContext(), tasks);
        recyclerView.setAdapter(taskAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}