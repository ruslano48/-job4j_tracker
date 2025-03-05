package ru.job4j.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    void whenNoPersonMatchesKeyThenReturnEmptyList() {
        PhoneDictionary phoneBook = new PhoneDictionary();
        phoneBook.add(new Person("John", "Doe", "123456", "Some Address"));
        phoneBook.add(new Person("Jane", "Smith", "654321", "Another Address"));
        ArrayList<Person> result = phoneBook.find("NonExistentKey");
        assertThat(result).isEmpty();
    }
}