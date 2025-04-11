package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public List<Student> class10A(List<Student> students) {
        return collect(students, student -> student.getScore() >= 70
        && student.getScore() <= 100);
    }

    public  List<Student> class10B(List<Student> students) {
    return collect(students, student -> student.getScore() >= 50
    && student.getScore() < 70);

    }

    public List<Student> class10C(List<Student> students) {
        return collect(students, student -> student.getScore() > 0
        && student.getScore() < 50);
    }
}
