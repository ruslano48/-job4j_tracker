package ru.job4j.collection;

import java.util.Objects;

public class Order {
    private String number;
    private String name;

    public Order(String number, String name) {
        this.name = name;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public String toString() {
    return "Order{"
            + "number='" + number + '\''
            + ", name='" + name + '\''
            + '}';
    }

    @Override
    public boolean equals(Object o) {
    if (this == o) {
        return true;
    }

    if (o == null || getClass() != o.getClass()) {
        return false;
    }
   Order order = (Order) o;
    return Objects.equals(number, order.number)
            && Objects.equals(name, order.name);
}

@Override
public int hashCode() {
    return Objects.hash(number, name);
    }
}