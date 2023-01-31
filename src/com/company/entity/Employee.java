package com.company.entity;


public class Employee implements interefete.Salary {

    private String name;
    private String departament; // profesor (poate fi lista [prof romana, prof engleza...]), [ingrijitor, bucatar], soferi
    protected int salary;

    public Employee() {}

    public Employee(String name, String departament, int salary) {
        this.name = name;
        this.departament = departament;
        this.salary = salary;
    }


    public String getName() {
        return name;
    }
    public String getDepartament() {
        return departament;
    }
    public int getSalary() {
        return salary;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDepartament(String departament) {
        this.departament = departament;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }


    @Override
    public void crestereSalariala(int x) {
        salary += x*salary/100;
    }


    @Override
    public String toString() {
        return "\nEmployee: " + name + ", departament: " + departament + ", salary: " + salary ;
    }


}
