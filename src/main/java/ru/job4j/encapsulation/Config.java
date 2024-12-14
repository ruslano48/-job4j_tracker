package ru.job4j.encapsulation;

import java.util.Arrays;
import java.util.Objects;

public class Config {
    private String name;
    private int position;
    public String[] properties;

    public Config(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println(position);
    }

    private String getProperty(String key) {
        return search(key);
    }

    public String search(String key) {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Config config = (Config) o;
        return position == config.position
                && Objects.equals(name, config.name)
                && Objects.deepEquals(properties, config.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, Arrays.hashCode(properties));
    }
}