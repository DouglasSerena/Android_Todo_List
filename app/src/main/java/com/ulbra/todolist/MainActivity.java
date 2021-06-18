package com.ulbra.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ulbra.todolist.adapter.TaskAdapter;
import com.ulbra.todolist.parcelable.Task;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ArrayList<Task> tasks;

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
            intent.putParcelableArrayListExtra("tasks", tasks);
            startActivity(intent);
        });

        getTasks();
        addNewTask();

        tasks.add(new Task("dawdaw", "dawdawdawdawdawdaw daw daw daw d", "213213123"));
        tasks.add(new Task("dawdaw", "dawdawdawdawdawdaw daw daw daw d", "213213123"));
        tasks.add(new Task("dawdaw", "dawdawdawdawdawdaw daw daw daw d", "213213123"));
        tasks.add(new Task("dawdaw", "dawdawdawdawdawdaw daw daw daw d", "213213123"));
        tasks.add(new Task("dawdaw", "dawdawdawdawdawdaw daw daw daw d", "213213123"));

        createRecycler();
    }

    public void createRecycler() {
        TaskAdapter taskAdapter = new TaskAdapter(getApplicationContext(), tasks, this::remove);
        recyclerView.setAdapter(taskAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    void remove(int position) {
        tasks.remove(position);
        this.createRecycler();
    }

    public void getTasks() {
        ArrayList<Task> tasks = getIntent().getParcelableArrayListExtra("tasks");
        if(tasks != null) {
            this.tasks = tasks;
        } else {
            this.tasks = new ArrayList<>();
        }
    }

    public void addNewTask() {
        Task task = getIntent().getParcelableExtra("newTask");
        if (task != null) {
            tasks.add(task);
        }
    }
}