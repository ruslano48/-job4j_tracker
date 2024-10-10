package ru.job4j.oop;

public class Cat {

    private String food;

    private String name;

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void eat(String food) {
        this.food = food;
    }

    public void show() {
        System.out.println("Котик " + this.name + " ел " + this.food);
    }

    public static void main(String[] args) {

        Cat peppy = new Cat();

        peppy.giveNick("Peppy");

        peppy.eat("рыбу");

        peppy.show();
    }
}