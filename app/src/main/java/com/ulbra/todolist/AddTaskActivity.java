package com.ulbra.todolist;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class AddTaskActivity extends AppCompatActivity {
    EditText editTitle, editDescription, editDate;
    CheckBox checkPriority;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        Objects.requireNonNull(getSupportActionBar()).hide();

        editTitle = findViewById(R.id.editTitle);
        editDescription = findViewById(R.id.editDescription);
        editDate = findViewById(R.id.editDate);
        checkPriority = findViewById(R.id.checkPriority);
    }
}