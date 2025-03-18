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
        List<Label> result = new ArrayList<>();
        Map<String, List<Integer>> subjectScores = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String subjectName = subject.name();
                int score = subject.score();
                if (!subjectScores.containsKey(subjectName)) {
                    subjectScores.put(subjectName, new ArrayList<>());
                }

                subjectScores.get(subjectName).add(score);
            }
        }
        for (Map.Entry<String, List<Integer>> entry : subjectScores.entrySet()) {
            String subjectName = entry.getKey();
            List<Integer> scores = entry.getValue();

            double averageScore = scores.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0.0);

            result.add(new Label(subjectName, averageScore));
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
        Map<String, List<Integer>> subjectScores = new HashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String subjectName = subject.name();
                int score = subject.score();

                subjectScores.computeIfAbsent(subjectName, k -> new ArrayList<>())
                        .add(score);
            }
        }

        List<Label> labels = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : subjectScores.entrySet()) {
            String subject = entry.getKey();
            int total = entry.getValue().stream().mapToInt(Integer::intValue).sum();
            labels.add(new Label(subject, total));
        }

        labels.sort(Comparator.naturalOrder());
        return labels.isEmpty() ? null : labels.get(labels.size() - 1);
    }
}
