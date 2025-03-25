package ru.job4j.collection;

import java.util.Comparator;

public class Job implements Comparable<Job> {
    private String name;
    private int priority;

    public Job(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Job{"
                + "name='" + name + '\''
                + ", priority="
                + priority
                + '}';
    }

    @Override
    public int compareTo(Job another) {
        return Integer.compare(priority, another.priority);
    }

    public static class JobNameComparator implements Comparator<Job> {
        @Override
        public int compare(Job first, Job second) {
            int nameCompare = first.getName().compareTo(second.getName());
            if (nameCompare == 0) {
                return Integer.compare(first.getPriority(), second.getPriority());
            }
            return nameCompare;
        }
    }

    public static class JobPriorityComparator implements Comparator<Job> {
        @Override
        public int compare(Job first, Job second) {
            int priorityCompare = Integer.compare(first.getPriority(), second.getPriority());
            if (priorityCompare == 0) {
                return first.getName().compareTo(second.getName());
            }
            return priorityCompare;
        }
    }

    public static class JobNameDescComparator implements Comparator<Job> {
        @Override
        public int compare(Job first, Job second) {
            int nameCompare = second.getName().compareTo(first.getName());
            if (nameCompare == 0) {
                return Integer.compare(first.getPriority(), second.getPriority());
            }
            return nameCompare;
        }
    }

    public static class JobPriorityDescComparator implements Comparator<Job> {
        @Override
        public int compare(Job first, Job second) {
            int priorityCompare = Integer.compare(second.getPriority(), first.getPriority());
            if (priorityCompare == 0) {
                return first.getName().compareTo(second.getName());
            }
            return priorityCompare;
        }
    }
}
