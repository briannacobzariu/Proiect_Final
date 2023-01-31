package com.company;

import com.company.config.DatabaseConfiguration;
import com.company.repository.CourseRepository;
import com.company.repository.ScheduleRepository;
import com.company.repository.StudentRepository;
import com.company.repository.TeacherRepository;
import com.company.service.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        StudentRepository studentRepository = new StudentRepository();
        studentRepository.createTable();
        studentRepository.addStudent("6110921298888", "Maria", 3);
        studentRepository.displayStudents();
        studentRepository.updateStudentGrade("6110921298888", 4);
        studentRepository.displayStudents();
        studentRepository.deleteStudent("6110921298888");
        studentRepository.displayStudents();


        TeacherRepository teacherRepository = new TeacherRepository();
        teacherRepository.createTable();
        teacherRepository.addTeacher("Pana Tatiana", "profesor", 3900);
        teacherRepository.addTeacher("Gherasim Luminita", "profesor", 4200);
        teacherRepository.displayTeachers();
        teacherRepository.updateTeacherSalary("Gherasim Luminita", 5700);
        teacherRepository.displayTeachers();
        teacherRepository.deleteTeacher("Pana Tatiana");
        teacherRepository.displayTeachers();


        CourseRepository courseRepository = new CourseRepository();
        courseRepository.createTable();
        courseRepository.addCourse("Dansuri", "incepator");
        courseRepository.addCourse("Tenis", "incepator");
        courseRepository.displayCourses();
        courseRepository.updateCourseLevel(1, "avansat");
        courseRepository.displayCourses();
        courseRepository.deleteCourse("Tenis", "incepator");
        courseRepository.displayCourses();


        ScheduleRepository scheduleRepository = new ScheduleRepository();
        scheduleRepository.createTable();
        scheduleRepository.addSchedule("15-16", "joi");
        scheduleRepository.addSchedule("11-12", "miercuri");
        scheduleRepository.displaySchedules();
        scheduleRepository.updateScheduleInterval("joi", "15-16", "16-17");
        scheduleRepository.displaySchedules();
        scheduleRepository.deleteSchedule(2);
        scheduleRepository.displaySchedules();


        com.company.service.ReadCSVService in = com.company.service.ReadCSVService.getInstance();
        com.company.service.AfterschoolService afterschool = new com.company.service.AfterschoolService();

        List<com.company.entity.Student> students = in.readCSV("data/student.csv", "Student");
        com.company.entity.Student elev1 = students.get(0);
        List<com.company.entity.Teacher> teachers = in.readCSV("data/teacher.csv", "Teacher");
        com.company.entity.Teacher prof1 = teachers.get(0);

        com.company.entity.Student student1 = new com.company.entity.Student("5121212121212", "Mircea Matei", 3, "21.09.2011");
        com.company.entity.Teacher teacher1 = new com.company.entity.Teacher("Lorena Mihai", "profesor", 2900);
        com.company.entity.Teacher teacher2 = new com.company.entity.Teacher("Silviu Anastase", "profesor", 3100);
        com.company.entity.Course curs1 = new com.company.entity.Course("franceza", "incepator");
        com.company.entity.Schedule schedule1 = new com.company.entity.Schedule("15-16", "Joi");

        afterschool.addStudent(student1);
        afterschool.addTeacher(teacher1);
        afterschool.addCourse(curs1);
        afterschool.addToSchedule(schedule1);
        afterschool.changeTeacher(prof1, teacher2);
        afterschool.changeInterval(schedule1, "15-17");
        afterschool.upgradeYear();
        afterschool.deleteCourse(curs1);
        afterschool.deleteEmployee(teacher1);
        afterschool.deleteStudent(elev1);
        afterschool.payMonthlyFee(student1, "1200");

        com.company.service.WriteToCSVService write = com.company.service.WriteToCSVService.getInstance();
        write.writeToCSV(student1, "data/student.csv");

        DatabaseConfiguration.closeDatabaseConfiguration();
    }
}
