package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
//import lombok.AllArgsConstructor;

//@AllArgsConstructor
public class ToDoListManager {

    private List<Task> tasks = new ArrayList<>(); //чому ми використовуємо list а не arrayList ? // зрозумів що потрібно було ініціалізувати

    /// зрозумів для чого взагалі тут hashMap: String - це назва категорії(ключ), List<Task> - це спикок до відповідної категорії
    private Map<String, List<Task>> tasksByCategory = new HashMap<>();

    private int currentId = 1;


    public void printMenu() {
        System.out.println("menu: ");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Edit Task");
        System.out.println("4. Delete Task");
        System.out.println("5. Filter Tasks");
        System.out.println("6. Task completed!");
        System.out.println("7. Statistics Tasks");
    }

    public void printMenuList() {
        System.out.println("menu: ");
        System.out.println("1. sort tasks by category");
        System.out.println("2. sort tasks by priority");
        System.out.println("3. show all tasks");
    }

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
    // не розумію чому не працює метод, воно в прінті видає "id of task is not find."
    // хоча вони вручну додані завдання і ці id мусять бути додані, пробував змінювати типи даних з int на Integer,
    // все одно не працює, запитати чим відрізняється int та Integer.
    public void removeTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                tasks.remove(task);
                System.out.println("task is removed");
            } else {
                System.out.println("id of task is not find.");
                //чому ми break пишсемо тут в else
                break;
            }
        }
    }

    public void listTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void filterTasks(Predicate<Task> condition) {
        List<Task> filtered = tasks.stream()
                .filter(condition)
                .collect(Collectors.toList());

        System.out.println(tasks = filtered);
    }

    // в мене та сама роблема програма працює коректно, проте виводиться - "id of task is not found."
    public void taskIsCompleted(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setCompleted(true);
            } else {
                System.out.println("id of task is not found.");
                break;
            }
        }

    }
}
