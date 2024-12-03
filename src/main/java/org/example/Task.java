package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Task {

    private int id;
    private String description;
    private String category;
    private int priority; // "High", "Medium", "Low"
    private boolean isCompleted;

    @Override //Перевизначений метод toString() для зручного виводу задач. можна було через lombok
    public String toString() {
        return "\nTask-> \nid: " + id + "\npriority: " + priority + "\ndescription:  " + description + "\nstatus:  " + isCompleted;
    }
}

