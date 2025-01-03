package ru.job4j.tracker;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] result = new Item[size];
        for (int i = 0; i < size; i++) {
            result[i] = items[i];
        }
        return result;
    }

    public Item[] findByName(String key) {
        Item[] temp = new Item[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                temp[count++] = items[i];
            }
        }
        Item[] result = new Item[count];
        System.arraycopy(temp, 0, result, 0, count);
        return result;
    }
}