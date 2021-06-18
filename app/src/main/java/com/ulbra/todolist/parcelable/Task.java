package com.ulbra.todolist.parcelable;


import android.os.Parcel;
import android.os.Parcelable;

public class Task implements Parcelable {
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

    public Task(String title, String description, String date) {
        createTask(title, description,date,false);
    }
    public Task(String title, String description, String date, boolean priority) {
        createTask(title, description,date,priority);
    }
    private void createTask(String title, String description, String date, boolean priority) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.priority = priority;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.date);
        dest.writeByte(this.priority ? (byte) 1 : (byte) 0);
    }

    public void readFromParcel(Parcel source) {
        this.title = source.readString();
        this.description = source.readString();
        this.date = source.readString();
        this.priority = source.readByte() != 0;
    }

    protected Task(Parcel in) {
        this.title = in.readString();
        this.description = in.readString();
        this.date = in.readString();
        this.priority = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Task> CREATOR = new Parcelable.Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel source) {
            return new Task(source);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };
}
