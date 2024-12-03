package org.example;// запитати що це
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ToDoListManager manager = new ToDoListManager();

        Task Task1 = new Task(1, "buy bread", "products", 1, false);
        manager.addTask(Task1);

        Task Task2 = new Task(2, "do homework", "school", 2, false);
        manager.addTask(Task2);

        Task Task3 = new Task(3, "buy coca cola", "products", 2, false);
        manager.addTask(Task3);

        System.out.println("enter id");
        int id = scanner.nextInt();

        System.out.print("Введіть опис завдання: ");
        String description = scanner.nextLine();

        System.out.print("Введіть категорію завдання: ");
        String category = scanner.nextLine();

        System.out.print("Введіть пріоритет завдання (1 - Високий, 2 - Середній, 3 - Низький): ");
        int priority = scanner.nextInt();


        System.out.print("Чи завершене завдання? (true/false): ");
        boolean isCompleted = scanner.nextBoolean();

        // Додати завдання
        manager.addTask(id, description, category, priority, isCompleted);

        manager.listTasks();

    }
}