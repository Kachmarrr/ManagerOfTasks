package org.example;// запитати що це
import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ToDoListManager manager = new ToDoListManager();

        Task task1 = new Task("products", "buy bread", 1);
        manager.addTask(task1);
        Task task2 = new Task("school", "do PE", 2);
        manager.addTask(task2);
        Task task3 = new Task("products", "buy Coca cola", 3);
        manager.addTask(task3);
        Task task4 = new Task("school", "do math", 1);
        manager.addTask(task4);
        Task task5 = new Task("school", "do society", 2);
        manager.addTask(task5);
        Task task6 = new Task("products", "by water", 3);
        manager.addTask(task6);

        boolean run = true;
        manager.printMenu();
        while (run) {
            System.out.println("Please enter your choice: ");
            Integer choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Please enter the category of the task: ");
                    String category = scanner.nextLine();
                    System.out.println("Please enter the description of the task: ");
                    String description = scanner.nextLine();
                    System.out.println("Please enter the priority of the task\n(1 - High, 2 - Medium, 3 - Low): ");
                    Integer priority = scanner.nextInt();
                    manager.addTask(new Task(category, description, priority));
                }
                case 2 -> {
                    manager.printMenuList();
                    System.out.println("Please enter your choice: ");
                    Integer choiceList = scanner.nextInt();
                    scanner.nextLine();

                    switch (choiceList) {
                        case 1 -> {
                            System.out.println("Please enter the category of the task: ");
                            String category = scanner.nextLine();
                            manager.filterTasks(task -> task.getCategory().equals(category));
                        }
                        case 2 -> {
                            System.out.println("Please enter the prioryty of the task:\n(1 - High, 2 - Medium, 3 - Low): ");
                            Integer priority = scanner.nextInt();
                            manager.filterTasks(task -> task.getPriority() == priority);
                        }
                        case 3 -> {
                            manager.listTasks();
                        }
                    }
                }
                case 3 -> {
                    scanner.nextLine();
                    System.out.println("Please enter the id of the task: ");
                    Integer id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Please enter the category of the task: ");
                    String category = scanner.nextLine();
                    System.out.println("Please enter the description of the task: ");
                    String description = scanner.nextLine();
                    System.out.println("Please enter the priority of the task\n(1 - High, 2 - Medium, 3 - Low): ");
                    Integer priority = scanner.nextInt();
                    manager.editTask(id, new Task(category, description, priority));
                }
                case 4 -> {
                    System.out.println("Please enter the id of the task: ");
                    Integer id = scanner.nextInt();
                    manager.removeTask(id);
                }




            }


        }
    }
}