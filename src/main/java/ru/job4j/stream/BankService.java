package ru.job4j.stream;

import java.util.List;
import java.util.Map;

public class BankService {

    private final Map<User, List<Account>> users;

    public BankService(Map<User, List<Account>> users) {
        this.users = users;
    }

    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.passport().equals(passport))
                .findFirst()
                .orElse(null);

    }

    public Account findByRequisite(String passport, String requisite) {
        return users.keySet().stream()
                .filter(user -> user.passport().equals(passport))
                .findFirst()
                .map(users::get)
                .flatMap(accounts -> accounts.stream()
                        .filter(acc -> acc.requisite().equals(requisite))
                        .findFirst())
                .orElse(null);
    }
}
