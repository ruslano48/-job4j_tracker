package ru.job4j.tracker.action;

import ru.job4j.tracker.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class ReplaceAction implements UserAction {

    private final Output output;

    public ReplaceAction(Output output) {

        this.output = output;
    }

    @Override
    public String name() {
        return "Изменить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Edit item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter new name: ");
        Item item = new Item(name);

        if (tracker.replace(id, item)) {
            output.println("Заявка успешно изменена.");
        } else {
            output.println("Ошибка: заявка с указанным ID не найдена.");
        }

        return true;
    }
}