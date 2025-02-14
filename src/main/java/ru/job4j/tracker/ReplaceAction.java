package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Изменить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter new name: ");
        Item item = new Item(name);

        if (tracker.replace(id, item)) {
            System.out.println("Заявка успешно изменена.");
        } else {
            System.out.println("Ошибка: заявка с указанным ID не найдена.");
        }

        return true;
    }
}