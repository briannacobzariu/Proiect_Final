package com.company.service;
import com.company.entity.Course;
import com.company.entity.Student;
import com.company.entity.Teacher;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteToCSVService {
    private static WriteToCSVService instance;

    private WriteToCSVService() {}

    public static WriteToCSVService getInstance() {
        if(instance == null) {
            instance = new WriteToCSVService();
        }
        return instance;
    }

    public <T> void writeToCSV(T object, String path) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path, true))) {
            String line = "";
            if (object instanceof Course){
                Course course = (Course) object;
                line += "\n" + course.getName() + "," + course.getNivel() + "," + course.getSchedule() + "\n";
                out.write(line);
            }
            else if (object instanceof Student){
                Student student = (Student) object;
                line += "\n" + student.getCNP() + "," + student.getName() + "," + student.getGrade() + "," + student.getEntryDate() + "\n";
                out.write(line);
            }
            else if (object instanceof Teacher){
                Teacher teacher = (Teacher) object;
                line += "\n" + teacher.getName() + "," + teacher.getDepartament() + "," + teacher.getSalary() + "\n";
                out.write(line);
            }
            else throw new Exception("Tipul obiectelor care trebuie scrise nu exista.");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
