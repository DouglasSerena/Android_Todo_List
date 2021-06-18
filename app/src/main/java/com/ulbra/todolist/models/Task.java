package com.ulbra.todolist.models;

public class Task {
    String title, description, date;
    boolean priority;

    public String getDate() {
        return date;
    }
    public String getDescription() {
        return description;
    }
    public String getTitle() {
        return title;
    }
    public boolean isPriority() {
        return priority;
    }

    public Task(String title, String description, String date, boolean priority) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.priority = priority;
    }
}
