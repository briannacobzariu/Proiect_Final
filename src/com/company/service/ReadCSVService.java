package com.company.service;
import com.company.entity.Course;
import com.company.entity.Student;
import com.company.entity.Teacher;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVService {
    private static ReadCSVService instance;

    private ReadCSVService() {
    }

    public static ReadCSVService getInstance() {
        if (instance == null) {
            instance = new ReadCSVService();
        }
        return instance;
    }

    public <T> List<T> readCSV(String path, String objectName) {
        List<T> date = new ArrayList<>();
        List<String[]> rows = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            String line = in.readLine(); // prima linie care contine denumirile coloanelor; o ignoram
            while ((line = in.readLine()) != null) {
                String[] obj = line.split(",");
                for (int i = 0; i < obj.length; i++)
                    obj[i] = obj[i].trim();
                rows.add(obj);
            }
            if (objectName.equalsIgnoreCase("Course")) {
                for (var object : rows){
                    Course course = new Course(object[0], object[1], object[2], object[3]);
                    date.add((T) course);
                }
            }
            else if (objectName.equalsIgnoreCase("Student")){
                for (var object : rows){
                    Student student = new Student(object[0], object[1], Integer.parseInt(object[2]), object[3]);
                    date.add((T) student);
                }
            }
            else if (objectName.equalsIgnoreCase("Teacher")){
                for (var object : rows){
                    List<Course> courses = new ArrayList<>();
                    Teacher teacher = new Teacher(object[0], object[1], Integer.parseInt(object[2]));
                    date.add((T) teacher);
                }
            }
            else throw new Exception("Tipul obiectelor care trebuie citite nu exista.");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return date;
    }
}
