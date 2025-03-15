package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user, new ArrayList<>());

    }

    public void deleteUser(String passport) {
        User user = new User(passport, "Name");
        users.remove(user);
    }

    public void addAccount(String passport, Account account) {
        User user = new User(passport, "name");
        User foundUser = findByPassport(passport);
        if (foundUser != null) {
            List<Account> accounts = users.get(foundUser);

            for (Account acc : accounts) {
                if (acc.getRequisite().equals(account.getRequisite())) {
                    return;
                }
            }
            accounts.add(account);
        }
    }

    public User findByPassport(String passport) {
        User user = new User(passport, "Name");

        for (User userMap : users.keySet()) {
            if (userMap.equals(user)) {
                return userMap;
            }
        }

        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = new User(passport, "Name");
        User foundUser = findByPassport(passport);
        if (foundUser != null) {
            List<Account> accounts = users.get(foundUser);
            for (Account acc : accounts) {
                if (acc.getRequisite().equals(requisite)) {
                    return acc;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        User sourceUser = findByPassport(sourcePassport);
        User destinationUser = findByPassport(destinationPassport);
        Account sourceaccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationaccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceaccount != null
                && destinationaccount != null
                && sourceaccount.getBalance() >= amount) {
            sourceaccount.setBalance(sourceaccount.getBalance() - amount);
            destinationaccount.setBalance(destinationaccount.getBalance() + amount);
            return true;
        }
        return false;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}