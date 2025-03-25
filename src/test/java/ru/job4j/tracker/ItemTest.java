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
        List<Item> items = Arrays.asList(
                new Item(1, "Charlie"),
                new Item(2, "Alpha"),
                new Item(3, "Bravo")
        );

        List<Item> expected = Arrays.asList(
                new Item(2, "Alpha"),
                new Item(3, "Bravo"),
                new Item(1, "Charlie")
        );

        Collections.sort(items, new ItemAscByName());
        assertEquals(expected.toString(), items.toString());
    }

    @Test
    void whenSortByNameDesc() {
        LocalDateTime fixedTime = LocalDateTime.now();
        List<Item> items = Arrays.asList(
                new Item(1, "Charlie"),
                new Item(2, "Alpha"),
                new Item(3, "Bravo")
        );

        List<Item> expected = Arrays.asList(
                new Item(1, "Charlie"),
                new Item(3, "Bravo"),
                new Item(2, "Alpha")
        );

        Collections.sort(items, new ItemDescByName());
        assertEquals(expected, items);
    }
}
