package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс реализует сервис для управления пользователями и их банковскими счетами.
 * Он позволяет добавлять, удалять пользователей, а также осуществлять переводы между счетами.
 *
 * @author RUSLAN OSTAPENKO
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей банка и их счетов,
     * где ключ-пользователь, значение - список его счетов.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет нового пользователя в банковскую систему.
     * Если пользователь уже существует, то он не будет добавлен повторно.
     */
    public void addUser(User user) {
        users.put(user, new ArrayList<>());

    }

    /**
     * Удаляет пользователя по его паспорту
     */

    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));

    }

    /**
     * Добавляет новый банковский счет пользователя по его паспорту
     */

    public void addAccount(String passport, Account account) {
        User foundUser = findByPassport(passport);
        if (foundUser != null) {
            List<Account> accounts = users.get(foundUser);

            if (!accounts.contains(account)) {

                accounts.add(account);
            }
        }
    }

    /**
     * Поиск пользователя по паспорту
     */

    public User findByPassport(String passport) {

        for (User userMap : users.keySet()) {

            if (userMap.getPassport().equals(passport)) {
                return userMap;
            }
        }

        return null;
    }

    /**
     * Ищет пользователя по банковскому счету и паспорту
     */

    public Account findByRequisite(String passport, String requisite) {
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

    /**
     * Осуществляет перевод денег
     */

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
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

    /**
     * Получает список счетов пользователя
     */

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
