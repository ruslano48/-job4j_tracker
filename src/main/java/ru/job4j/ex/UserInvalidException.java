package ru.job4j.ex;

public class UserInvalidException extends UserNotFoundException {
    UserInvalidException(String massege) {
        super(massege);
    }
}
