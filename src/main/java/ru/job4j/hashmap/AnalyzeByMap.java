package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        if (pupils == null || pupils.isEmpty()) {
            return 0D;
        }
        double totalScore = 0;
        int totalSubjects = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {

                totalScore += subject.score();
                totalSubjects++;
            }
        }
        return totalScore / totalSubjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();

        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            int totalScore = 0;
            for (Subject subject : subjects) {
                totalScore += subject.score();
            }
            double averageScore = (double) totalScore / subjects.size();
            result.add(new Label(pupil.name(), averageScore));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> sumMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumMap.merge(subject.name(), subject.score(), Integer::sum);
                countMap.merge(subject.name(), 1, Integer::sum);
            }
        }

        List<Label> result = new ArrayList<>();
        for (String subject : sumMap.keySet()) {
            double average = (double) sumMap.get(subject) / countMap.get(subject);
            result.add(new Label(subject, average));
        }

        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> studentScores = new ArrayList<>();

        for (Pupil pupil : pupils) {
            int totalScore = 0;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            studentScores.add(new Label(pupil.name(), totalScore));
        }

        studentScores.sort(Comparator.naturalOrder());

        return studentScores.isEmpty() ? null : studentScores.get(studentScores.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new HashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectScores.merge(subject.name(), subject.score(), Integer::sum);
            }
        }

        return subjectScores.entrySet().stream()
                .map(entry -> new Label(entry.getKey(), entry.getValue()))
                .max(Comparator.naturalOrder())
                .orElse(null);
    }
}
