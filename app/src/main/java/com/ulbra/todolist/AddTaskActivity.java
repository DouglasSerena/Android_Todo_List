package com.ulbra.todolist;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class AddTaskActivity extends AppCompatActivity {
    EditText editDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        Objects.requireNonNull(getSupportActionBar()).hide();

        editDate = findViewById(R.id.editDate);
    }

}