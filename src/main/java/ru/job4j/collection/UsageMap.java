package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("ruslano48@yandex.ru", "Ruslan Ostapenko");
        map.put("rodrom2014@yandex.ru", "Roman Rodichev");
        map.put("Lana2401@yandex.ru", "Ruslan Ostapenko");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }
}