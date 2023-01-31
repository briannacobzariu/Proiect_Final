package com.company.comparator;
import com.company.entity.Student;

import java.util.Comparator;

public class GradeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getGrade() - o2.getGrade();
    }

    @Override
    public Comparator<Student> reversed() {
        return Comparator.super.reversed();
    }
}
