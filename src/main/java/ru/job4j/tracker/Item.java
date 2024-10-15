package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Item {
    private int id;
    private String name;
    private LocalDateTime created;

    public Item() {
        this.created = LocalDateTime.now();
    }

        public LocalDateTime getCreated() {
        return created;
    }

    public Item(String name) {
        this.name = name;
        this.created = LocalDateTime.now();
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
        this.created = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}