package ru.job4j.tracker;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "ExitAction";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Завершение программы ===");
        return false;
    }
}
