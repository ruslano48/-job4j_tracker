package ru.job4j.search;

public class Task {
    private String description;
    private int priority;

    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    String getDescription() {
    return description;
    }

    int getPriority() {
        return priority;
    }
}
