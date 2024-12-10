package org.example;// запитати що це

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ToDoListManager manager = new ToDoListManager();

        Task task1 = new Task("products", "buy bread", 1, true);
        manager.addTask(task1);
        Task task2 = new Task("school", "do PE", 2, false);
        manager.addTask(task2);
        Task task3 = new Task("products", "buy Coca cola", 3, true);
        manager.addTask(task3);
        Task task4 = new Task("school", "do math", 1, false);
        manager.addTask(task4);
        Task task5 = new Task("school", "do society", 2, true);
        manager.addTask(task5);
        Task task6 = new Task("products", "by water", 3, false);
        manager.addTask(task6);

        boolean run = true;
        manager.printMenu();
        while (run) {
            System.out.println("Please enter your choice: ");
            Integer choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> { // rev 0.9
                    System.out.println("Please enter the category of the task: ");
                    String category = scanner.nextLine();
                    System.out.println("Please enter the description of the task: ");
                    String description = scanner.nextLine();
                    System.out.println("Please enter the priority of the task\n(1 - High, 2 - Medium, 3 - Low): ");
                    Integer priority = scanner.nextInt();
                    manager.addTask(new Task(category, description, priority, false));
                }
                case 2 -> { //rev 0.9
                    manager.printMenuList();
                    System.out.println("Please enter your choice: ");
                    Integer choiceList = scanner.nextInt();
                    scanner.nextLine();

                    switch (choiceList) {
                        case 1 -> {
                            System.out.println("Please enter the category of the tasks: ");
                            String category = scanner.nextLine();
                            manager.filterTasks(task -> task.getCategory().equals(category));
                        }
                        case 2 -> {
                            System.out.println("Please enter the prioryty of the tasks:\n(1 - High, 2 - Medium, 3 - Low): ");
                            Integer priority = scanner.nextInt();
                            manager.filterTasks(task -> task.getPriority() == priority);
                        }
                        case 3 -> {
                            System.out.println("Please enter the status of the tasks: ");
                            Boolean status = scanner.nextBoolean();
                            manager.filterTasks(task -> task.isStatus() == status);
                        }
                        case 4 -> {
                            manager.listTasks();
                        }
                    }
                }
                case 3 -> { // rev 0.9
                    System.out.println("Please enter the id of the task: ");
                    Integer id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Please enter the category of the task: ");
                    String category = scanner.nextLine();
                    System.out.println("Please enter the description of the task: ");
                    String description = scanner.nextLine();
                    System.out.println("Please enter the priority of the task\n(1 - High, 2 - Medium, 3 - Low): ");
                    Integer priority = scanner.nextInt();
                    System.out.println("Please enter the status of the task: ");
                    Boolean status = scanner.nextBoolean();
                    manager.editTask(id, new Task(category, description, priority, status));
                }
                case 4 -> { // rev 0.9
                    System.out.println("Please enter the id of the task: ");
                    Integer id = scanner.nextInt();
                    manager.removeTask(id);
                }
                case 5 -> { //rev 0.9
                    System.out.println("this program filter task by your standards. ");
                    System.out.println("Enter the category of the tasks: ");
                    String category = scanner.nextLine();
                    System.out.println("Please enter the priority of the tasks: ");
                    Integer priority = scanner.nextInt();
                    System.out.println("Please enter the status of the tasks: ");
                    Boolean status = scanner.nextBoolean();
                    // тут в мене виникла проблема я не міг зрозуміти чому в мене фільтри робляться окремо,
                    // цю проблему можна було вирішити по різному, але я вибрав && - запитати, щоб розказали за це;
                    manager.filterTasks(task -> task.getCategory().equals(category) && task.getPriority() == priority && task.isStatus() == status);
                }
                case 6 -> { // rev 0.9
                    System.out.println("Please enter the id of the tasks: ");
                    Integer id = scanner.nextInt();
                    manager.taskIsCompleted(id);
                }








                
            }
        }
    }
}