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
import com.ulbra.todolist.parcelable.Task;

import java.util.ArrayList;


public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    OnRemove handleRemove;
    ArrayList<Task> tasks;
    Context context;

    public TaskAdapter(Context context, ArrayList<Task> tasks, OnRemove onRemove) {
        this.context = context;
        this.tasks = tasks;
        this.handleRemove = onRemove;
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
        holder.btnDelete.setOnClickListener(v -> handleRemove.onRemove(position));
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle,textDescription, textDate;
        ImageButton btnDelete;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDescription);
            textDate = itemView.findViewById(R.id.textDate);

            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}
