package com.company.entity;
import java.util.List;
import java.util.Objects;

public class Student {

    private String CNP;
    private String name;
    private int grade;
    private String entryDate;
    private double feesPaid; // int sau bool ?

    private List<Schedule> orar;

    public Student(String CNP, String name, int grade, String entryDate) {
        this.CNP = CNP;
        this.name = name;
        this.grade = grade;
        this.entryDate = entryDate;
    }

    public Student(){
        feesPaid = 0;
        orar = null;
    }

    public String getCNP() { return CNP;}
    public String getName() { return name;}
    public int getGrade() { return grade;}
    public String getEntryDate() { return entryDate;}
    public double getFeesPaid() { return feesPaid; }
    public List<Schedule> getOrar() { return orar;}
    public void setCNP(String CNP) { this.CNP = CNP;}
    public void setName(String name) { this.name = name;}
    public void setGrade(int grade) { this.grade = grade;}
    public void setEntryDate(String entryDate) { this.entryDate = entryDate;}
    public void setFeesPaid(double feesPaid) { this.feesPaid = feesPaid;}
    public void setOrar(List<Schedule> orar) { this.orar = orar;}

    @Override
    public String toString() {
        return "\nStudent: " +
                "CNP:'" + CNP + '\'' +
                ", name:'" + name + '\'' +
                ", grade:" + grade +
                ", entryDate:'" + entryDate + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return grade == student.grade && feesPaid == student.feesPaid && CNP.equals(student.CNP) && name.equals(student.name) && entryDate.equals(student.entryDate) && orar.equals(student.orar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CNP, name, grade, entryDate, feesPaid, orar);
    }


}
