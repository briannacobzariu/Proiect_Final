package com.company.entity;

import java.util.List;

public class Classroom {
    private int id;
    private String utilization; // curs, activitati extra, sala de mese, sala de joaca etc
    private float capacity; // cati elevi pot desfasura activitati in ea

    private List<Student> students; // fiecare clasa are alocata o lista de elevi care isi desfasoara activitatile in ea
    private Schedule schedule; // intr-un anumit interval de timp
                                // adica de la ora la ora, in fiecare sala se pot schimba elevii prezenti


    public Classroom(int id, String utilization, float capacity) {
        this.id = id;
        this.utilization = utilization;
        this.capacity = capacity;
    }

    public int getId() { return id;}
    public void setId(int id) { this.id = id;}
    public String getUtilization() { return utilization;}
    public void setUtilization(String utilization) { this.utilization = utilization;}
    public float getCapacity() { return capacity;}
    public void setCapacity(float capacity) { this.capacity = capacity;}


    @Override
    public String toString() { return "Classroom: " + "id=" + id + ", utilization=" + utilization + ", capacity=" + capacity; }


}
