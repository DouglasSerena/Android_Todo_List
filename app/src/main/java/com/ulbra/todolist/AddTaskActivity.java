package com.ulbra.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.ulbra.todolist.parcelable.Task;
import com.ulbra.todolist.form.EditTextControl;
import com.ulbra.todolist.form.FormControl;

import java.util.Objects;

public class AddTaskActivity extends AppCompatActivity {
    EditText editTitle, editDescription, editDate;

    CheckBox checkPriority;
    Button btnBack, btnAdd;

    EditTextControl titleControl, descriptionControl, dateControl;
    FormControl formControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        Objects.requireNonNull(getSupportActionBar()).hide();

        editTitle = findViewById(R.id.editTitle);
        editDescription = findViewById(R.id.editDescription);
        editDate = findViewById(R.id.editDate);
        checkPriority = findViewById(R.id.checkPriority);

        btnAdd = findViewById(R.id.btnAdd);
        btnBack = findViewById(R.id.btnBack);

        float scale = getResources().getDisplayMetrics().density;

        EditTextControl titleControl = new EditTextControl(editTitle, findViewById(R.id.textErrorTitle), scale);
        titleControl.setRequired(true, getString(R.string.error_required));
        titleControl.setMaxLength(20, getString(R.string.error_max_length));

        EditTextControl descriptionControl = new EditTextControl(editDescription, findViewById(R.id.textErrorDescription), scale);
        descriptionControl.setRequired(true, getString(R.string.error_required));
        descriptionControl.setMaxLength(100, getString(R.string.error_max_length));

        EditTextControl dateControl = new EditTextControl(editDate, findViewById(R.id.textErrorDate), scale);
        dateControl.setRequired(true, getString(R.string.error_required));
        dateControl.setMaxLength(10, getString(R.string.error_max_length));

        formControl = new FormControl(titleControl, descriptionControl, dateControl);

        this.setEvents();
    }

    private void setEvents() {
        btnAdd.setOnClickListener(v -> onAddTask());
        btnBack.setOnClickListener(v -> onBack());
        formControl.onStatus((status) ->  btnAdd.setEnabled(status.equals("VALID")));
    }

    private void onAddTask() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        Task newTask = new Task(
                editTitle.getText().toString(),
                editDescription.getText().toString(),
                editDate.getText().toString(),
                checkPriority.isChecked()
        );
        intent.putExtra("newTask", newTask);
        intent.putParcelableArrayListExtra("tasks", getIntent().getParcelableArrayListExtra("tasks"));
        startActivity(intent);
    }

    private void onBack() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putParcelableArrayListExtra("tasks", getIntent().getParcelableArrayListExtra("tasks"));
        startActivity(intent);
    }
}