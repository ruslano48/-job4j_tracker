package ru.job4j.collection;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.*;

class JobTest {

    @Test
    void whenSortByNameAscending() {
        List<Job> jobs = new ArrayList<>(List.of(
                new Job("Developer", 2),
                new Job("Analyst", 3),
                new Job("Manager", 1)
        ));
        jobs.sort(new Job.JobNameComparator());
        assertEquals("Analyst", jobs.get(0).getName());
        assertEquals("Developer", jobs.get(1).getName());
        assertEquals("Manager", jobs.get(2).getName());
    }

    @Test
    void whenSortByPriorityAscending() {
        List<Job> jobs = new ArrayList<>(List.of(
                new Job("Developer", 2),
                new Job("Analyst", 3),
                new Job("Manager", 1)
        ));
        jobs.sort(new Job.JobPriorityComparator());
        assertEquals(1, jobs.get(0).getPriority());
        assertEquals(2, jobs.get(1).getPriority());
        assertEquals(3, jobs.get(2).getPriority());
    }

    @Test
    void whenSortByNameDescending() {
        List<Job> jobs = new ArrayList<>(List.of(
                new Job("Developer", 2),
                new Job("Analyst", 3),
                new Job("Manager", 1)
        ));
        jobs.sort(new Job.JobNameDescComparator());
        assertEquals("Manager", jobs.get(0).getName());
        assertEquals("Developer", jobs.get(1).getName());
        assertEquals("Analyst", jobs.get(2).getName());
    }

    @Test
    void whenSortByPriorityDescending() {
        List<Job> jobs = new ArrayList<>(List.of(
                new Job("Developer", 2),
                new Job("Analyst", 3),
                new Job("Manager", 1)
        ));
        jobs.sort(new Job.JobPriorityDescComparator());
        assertEquals(3, jobs.get(0).getPriority());
        assertEquals(2, jobs.get(1).getPriority());
        assertEquals(1, jobs.get(2).getPriority());
    }

    @Test
    void whenSortByNameThenPriority() {
        List<Job> jobs = new ArrayList<>(List.of(
                new Job("Developer", 3),
                new Job("Developer", 1),
                new Job("Analyst", 2)
        ));
        jobs.sort(new Job.JobNameComparator().thenComparing(new Job.JobPriorityComparator()));
        assertEquals("Analyst", jobs.get(0).getName());
        assertEquals("Developer", jobs.get(1).getName());
        assertEquals(1, jobs.get(1).getPriority());
        assertEquals("Developer", jobs.get(2).getName());
        assertEquals(3, jobs.get(2).getPriority());
    }

    @Test
    void whenSortByPriorityThenName() {
        List<Job> jobs = new ArrayList<>(List.of(
                new Job("Developer", 2),
                new Job("Analyst", 2),
                new Job("Manager", 1)
        ));
        jobs.sort(new Job.JobPriorityComparator().thenComparing(new Job.JobNameComparator()));
        assertEquals(1, jobs.get(0).getPriority());
        assertEquals("Manager", jobs.get(0).getName());
        assertEquals(2, jobs.get(1).getPriority());
        assertEquals("Analyst", jobs.get(1).getName());
        assertEquals(2, jobs.get(2).getPriority());
        assertEquals("Developer", jobs.get(2).getName());
    }
}
