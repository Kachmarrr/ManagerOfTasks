package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
//import lombok.AllArgsConstructor;

//@AllArgsConstructor
public class ToDoListManager {

    private List<Task> tasks = new ArrayList<>(); //чому ми використовуємо list, а не arrayList ? // зрозумів що потрібно було ініціалізувати
    private Map<String, List<Task>> tasksByCategory = new HashMap<>();
    /// Зрозумів для чого взагалі тут hashMap: String - це назва категорії(ключ), List<Task> - це спикок до відповідної категорії

    private int currentId = 1;

    // не зрозумів звідки я взяв Task
    public void addTask(Task task) {

        task.setId(currentId++);
        //computeIfAbsent
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
                task.setDescription(updatedTask.getDescription());
                task.setPriority(updatedTask.getPriority());
                task.setCompleted(updatedTask.isCompleted());
                break;
            } else {
                System.out.println("id is not found (");
            }
        }
    }

    public void deleteTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                tasks.remove(task);
            } else {
                System.out.println("id of task is not find.");
                //чому ми break пишемо тут в else
                break;
            }
        }
    }

    public void listTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    // приймає список та значення по якому буде відбуватися фільтр
    public void filterTasks(Predicate<Task> filter) {

    }
}