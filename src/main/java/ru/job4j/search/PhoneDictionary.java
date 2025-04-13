package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        var byName = (Predicate<Person>) person -> person.getName().contains(key);
        var bySurname = (Predicate<Person>) person -> person.getSurname().contains(key);
        var byPhone = (Predicate<Person>) person -> person.getPhone().contains(key);
        var byAddress = (Predicate<Person>) person -> person.getAddress().contains(key);
        var combine = byName
                .or(bySurname)
                .or(byPhone)
                .or(byAddress);

       var result = new ArrayList<Person>();

        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }

        return result;
    }
}
