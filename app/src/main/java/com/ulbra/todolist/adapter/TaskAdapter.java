package com.ulbra.todolist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ulbra.todolist.R;
import com.ulbra.todolist.models.Task;

import java.util.ArrayList;


public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    ArrayList<Task> tasks;
    Context context;

    public TaskAdapter(Context context, ArrayList<Task> tasks) {
        this.context = context;
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_task_item, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.TaskViewHolder holder, int position) {
        holder.textTitle.setText(tasks.get(position).getTitle());
        holder.textDescription.setText(tasks.get(position).getDescription());
        holder.textDate.setText(tasks.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle,textDescription, textDate;
        Button btnDelete;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDescription);
            textDate = itemView.findViewById(R.id.textDate);

            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}