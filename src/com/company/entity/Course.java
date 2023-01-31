package com.company.entity;

import java.util.List;
import java.util.Random;

public class Course extends Activity {
    private String name; // numele cursului / materiei studiate
    private String nivel; // pentru ce clase e destinat
    private Schedule schedule; // fiecare curs are alocat un interval orar dintr-o zi a saptamanii

    public Course(String name, String nivel) {
        this.name = name;
        this.nivel = nivel;
    }

    public Course(String name, String nivel, String interval, String weekDay) {
        this.name = name;
        this.nivel = nivel;
        this.schedule = new Schedule(interval, weekDay);
    }

    public String getName() { return name; }
    public String getNivel() { return nivel; }
    public String getSchedule() { return schedule.getInterval() + schedule.getWeekDay(); }

    public void setName(String name) {this.name = name;}
    public void setNivel(String nivel) {this.nivel = nivel;}
    public void setSchedule(Schedule schedule) {this.schedule = schedule;}

    @Override
    public String toString() {
        return "Curs: " + name + ", nivel " + nivel + ", se desfasoara: " + schedule;
    }

    public int funLevel(){
        Random rand = new Random();
        int var = rand.nextInt(10);
        if (nivel=="avansat")
            return var*10;
        return var;
    }
}
