package ru.job4j.tracker;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class StartUI {
    public static void main(String[] args) {
        Item item = new Item("New Item");  // Создаем объект Item

        // Получаем дату создания
        LocalDateTime createdDate = item.getCreated();

        // Задаем паттерн форматирования
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

        // Форматируем дату и выводим ее в консоль
        String formattedDate = createdDate.format(formatter);
        System.out.println("Item created on: " + formattedDate);
    }
}