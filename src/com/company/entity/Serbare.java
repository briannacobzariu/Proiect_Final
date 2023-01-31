package com.company.entity;

import java.util.Arrays;

public class Serbare extends Activity {
    private Student[] students;
    private String location;
    private Schedule schedule;
    private String tematica; // iarna/vara/8 martie/paste etc

    public Serbare(Student[] students, String location, Schedule schedule, String tematica) {
        this.students = students;
        this.location = location;
        this.schedule = schedule;
        this.tematica = tematica;
    }

    @Override
    public String toString() {
        return "\n   Va invitam la serbarea cu tematica '" + tematica + "', de la locatia '" + location +
                "', program: " + schedule + ", la care vor participa elevii:" + Arrays.toString(students);
    }

    public int funLevel(){
        return students.length * 10;
    }
}
