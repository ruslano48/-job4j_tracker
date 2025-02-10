package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("Автобус двигается по маршруту.");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Колличество пассажиров" + count);
    }

    @Override
    public int refuel(int fuel) {
        int cost = fuel * 100;
        System.out.println("Автобус заправлен " + fuel + "литров. Стоимость заправки: " + cost);
        return cost;
    }
}
