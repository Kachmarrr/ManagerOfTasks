package org.example;// запитати що це
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ToDoListManager manager = new ToDoListManager();

        Task task1 = new Task("products", "buy bread", 2);
        manager.addTask(task1);

        Task task2 = new Task("school", "do homework", 1);
        manager.addTask(task2);

        Task task3 = new Task("products", "buy Coca cola", 2);
        manager.addTask(task3);






    }
}