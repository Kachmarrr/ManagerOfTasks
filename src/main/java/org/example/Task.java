package org.example;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Task {

    private int id;
    @NonNull
    private String category;
    @NonNull
    private String description;
    @NonNull
    private int priority; // "High", "Medium", "Low"
    private boolean isCompleted;

    @Override //Перевизначений метод toString() для зручного виводу задач. можна було через lombok
    public String toString() {
        return "\nTask-> \nid: " + id + "\npriority: " + priority + "\ncategory: " + category  + "\ndescription:  " + description + "\nstatus:  " + isCompleted;
    }
}

