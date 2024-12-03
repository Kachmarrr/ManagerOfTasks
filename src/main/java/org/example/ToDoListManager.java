package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import lombok.AllArgsConstructor;

//@AllArgsConstructor
public class ToDoListManager {

    private List<Task> tasks = new ArrayList<>(); //чому ми використовуємо list а не arrayList ? // зрозумів що потрібно було ініціалізувати

    ///зрозумів для чого взагалі тут hashMap: String - це назва категорії(ключ), List<Task> - це спикок до відповідної категорії
    private Map<String, List<Task>> tasksByCategory = new HashMap<>();

    private int currentId = 1;

    // не зрозумів звідки я взяв Task
    public void addTask(Task task) {
        //computeIfAbsent

        task.setId(currentId++);

        if (!tasksByCategory.containsKey(task.getCategory())) {
            tasksByCategory.put(task.getCategory(), new ArrayList<>());
        } else {
            tasksByCategory.get(task.getCategory()).add(task);
        }
        tasks.add(task);
    }

    public void editTask(int id, Task updatedTask) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setCategory(updatedTask.getCategory());
            }
            else {
                task.setCategory(updatedTask.getCategory());
            }
            System.out.println(task.getCategory());
        }
        System.out.println(updatedTask.getCategory());
        System.out.println(tasksByCategory.get(updatedTask.getCategory()));
    }

    public void removeTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                tasksByCategory.get(task.getCategory()).remove(task);
            }
            else {
                System.out.println(task.getCategory());
            }
        }
    }

    public void listTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
