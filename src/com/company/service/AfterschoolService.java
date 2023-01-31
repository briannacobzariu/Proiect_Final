package com.company.service;
import com.company.entity.*;
import com.company.repository.CourseRepository;
import com.company.repository.ScheduleRepository;
import com.company.repository.StudentRepository;
import com.company.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

public class AfterschoolService implements IAfterschoolService{    // clasa serviciu care expune operatiile sistemului

    private List<Student> students = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>(); // list = to access the elements frequently by using the index
    private List<Course> courses = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Schedule> schedules = new ArrayList<>();

    private static StudentRepository studentRepository;
    private static TeacherRepository teacherRepository;
    private static CourseRepository courseRepository;
    private static ScheduleRepository scheduleRepository;

    public AfterschoolService() {
        studentRepository = new StudentRepository();
        teacherRepository = new TeacherRepository();
        courseRepository = new CourseRepository();
        scheduleRepository = new ScheduleRepository();
    }

    public AfterschoolService(List<Student> students, List<Employee> employees, List<Course> courses) {
        this.students = students;
        this.employees = employees;
        this.courses = courses;
    }

    public List<Student> getStudent() { return students; }
    public List<Employee> getEmployees(){ return employees; }
    public List<Teacher> getTeachers(){ return teachers; }
    public List<Course> getCourses() { return courses; }
    public List<Schedule> getSchedules() { return schedules; }
    public void setStudent(List<Student> students) { this.students = students; }
    public void setTeacher(List<Teacher> teachers) { this.teachers = teachers; }
    public void setCourses(List<Course> courses) { this.courses = courses; }
    public void setSchedules(List<Schedule> schedules) { this.schedules = schedules; }


    // actiuni / interogari pe obiectele create
    @Override
    public void addTeacher (Teacher newTeacher){
        teachers.add(newTeacher);
        teacherRepository.addTeacher(newTeacher.getName(), newTeacher.getDepartament(), newTeacher.getSalary());
        audit.write("Add Teacher");
    }

    @Override
    public void addStudent (Student newStudent) {
        students.add(newStudent);
        studentRepository.addStudent(newStudent.getCNP(), newStudent.getName(), newStudent.getGrade());
        audit.write("Add Student");
    }

    @Override
    public void addCourse (Course newCourse) {
        courses.add(newCourse);
        courseRepository.addCourse(newCourse.getName(), newCourse.getNivel());
        audit.write("Add Course");
    }

    @Override
    public void changeTeacher (Teacher oldTeacher, Teacher newTeacher) { // pt profi cu acelasi departament si aceleasi cursuri
        oldTeacher.setName(newTeacher.getName());
        oldTeacher.setDepartament(newTeacher.getDepartament());
        oldTeacher.setSalary(newTeacher.getSalary());
        teacherRepository.updateTeacherName(oldTeacher.getName(), newTeacher.getName());
        teacherRepository.updateTeacherDepartment(oldTeacher.getName(), newTeacher.getDepartament());
        teacherRepository.updateTeacherSalary(oldTeacher.getName(), newTeacher.getSalary());
        audit.write("Change Teacher");
    }

    @Override
    public void changeInterval (Schedule oldSch, String newInterval) { // doar intervalul orar
        oldSch.setInterval(newInterval);
        scheduleRepository.updateScheduleInterval(oldSch.getWeekDay(), oldSch.getInterval(), newInterval);
        audit.write("Change Interval");
    }

    @Override
    public void addToSchedule (Schedule newSchedule){
        schedules.add(newSchedule);
        scheduleRepository.addSchedule(newSchedule.getInterval(), newSchedule.getWeekDay());
        audit.write("Add Schedule");
    }

    @Override
    public void getOrar(Schedule schedule) {  // afiseaza orar complex: ce cursuri are fiecare student, pe intervale orare
        System.out.println("\n-----------------------------");
        for (Student stud : students){
            System.out.println("Elevul " + stud.getName() + " are ore ");
            if (stud != null && stud.getOrar()!=null)
                for (Schedule sch : stud.getOrar()){
                    System.out.println("\t" + sch.getWeekDay() + ", intre " + sch.getInterval());
                }
        }
        System.out.println("-----------------------------");
        audit.write("Get Schedule");
    }

    @Override
    // in september or when requested, the grade of the students must be upgraded
    public void upgradeYear(){
        System.out.println("\nYear upgraded.");
        for (Student s : students){
            s.setGrade(s.getGrade() + 1);
            studentRepository.updateStudentGrade(s.getCNP(), s.getGrade()+1);
        }
        audit.write("Upgrade Year");
    }

    @Override
    public void deleteStudent (Student student) {  // daca a depasit ciclul primar de studii, este sters din Afterschool
        System.out.println(student.toString() + " deleted from afterschool.");
        // if (student.getGrade() > 4)
        students.remove(student);
        studentRepository.deleteStudent(student.getCNP());
        audit.write("Delete Student");
    }

    @Override
    public void deleteEmployee (Employee employee) {
        System.out.println("\nEmployee " + employee.getDepartament() + " " + employee.getName() + " deleted from afterschool.");
        employees.remove(employee);
        if (employee.getDepartament().equals("profesor"))
            teacherRepository.deleteTeacher(employee.getName());
        audit.write("Delete Employee");
    }

    @Override
    public void deleteCourse (Course course) {
        System.out.println("\nCourse " + course.getName() + ", " + course.getNivel() + " deleted.");
        courses.remove(course);
        courseRepository.deleteCourse(course.getName(), course.getNivel());
        audit.write("Delete Course");
    }

    @Override
    public void payMonthlyFee(Student s, String fee){
        s.setFeesPaid(s.getFeesPaid() + Double.parseDouble(fee));
        audit.write("Pay Monthly Fee");
    }

    @Override
    public String toString() {
        return "\nAfterschool Java" + "\n   Studenti inscrisi:" + students +  "\n\n   Angajati:" + employees; }


}
