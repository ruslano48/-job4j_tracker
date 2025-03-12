package ru.job4j.search;

public class Task {
    private String description;
    private int priority;
    private String number;

    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
        this.number = number;
    }

  public   String getDescription() {
        return description;
    }

   public int getPriority() {
        return priority;
    }

    public String getNumber() {

        return number;
    }
}
