package ru.job4j.tracker;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemSortTest {

    @Test
    void whenSortByNameAsc() {
        LocalDateTime fixedTime = LocalDateTime.now();
        Item charlie = new Item(1, "Charlie", fixedTime);
        Item alpha = new Item(2, "Alpha", fixedTime);
        Item bravo = new Item(3, "Bravo", fixedTime);

        List<Item> items = Arrays.asList(charlie, alpha, bravo);
        List<Item> expected = Arrays.asList(alpha, bravo, charlie);

        Collections.sort(items, new ItemAscByName());
        assertEquals(expected, items);
    }

    @Test
    void whenSortByNameDesc() {
        LocalDateTime fixedTime = LocalDateTime.now();
        Item charlie = new Item(1, "Charlie", fixedTime);
        Item alpha = new Item(2, "Alpha", fixedTime);
        Item bravo = new Item(3, "Bravo", fixedTime);

        List<Item> items = Arrays.asList(charlie, alpha, bravo);
        List<Item> expected = Arrays.asList(charlie, bravo, alpha);

        Collections.sort(items, new ItemDescByName());
        assertEquals(expected, items);
    }
}