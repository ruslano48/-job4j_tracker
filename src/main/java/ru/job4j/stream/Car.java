package ru.job4j.stream;

import java.time.LocalDate;

public class Car {
    private String brand;

    private String model;

    private LocalDate created;

    private double volume;

    private String color;

    @Override
    public String toString() {
        return "Car{"
                + "brand='" + brand + '\''
                + ", model='" + model + '\''
                + ", created=" + created
                + ", volume=" + volume
                + ", color='" + color + '\''
                + '}';
    }

    static class Builder {
        private String brand;
        private String model;
        private LocalDate created;
        private double volume;
        private String color;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;

        }

        Builder buildCreated(LocalDate created) {
            this.created = created;
            return this;

        }

        Builder buildVolume(double volume) {
            this.volume = volume;
            return this;

        }

        Builder buildColor(String color) {
            this.color = color;
            return this;

        }

        Car build() {
            Car car = new Car();
            car.brand = this.brand;
            car.model = this.model;
            car.created = this.created;
            car.volume = this.volume;
            car.color = this.color;
            return car;
        }

        public static void main(String[] args) {
            Car car = new Builder()
                    .buildBrand("Toyota")
                    .buildModel("Camry")
                    .buildCreated(LocalDate.of(2021, 6, 1))
                    .buildVolume(2.5)
                    .buildColor("Red")
                    .build();
            System.out.println(car);
            Car car2 = new Builder()
                    .buildBrand("BMW")
                    .buildVolume(3.0)
                    .build();

            System.out.println(car);
            System.out.println(car2);
        }
    }
}
