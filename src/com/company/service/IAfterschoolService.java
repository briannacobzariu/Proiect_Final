package com.company.service;

import com.company.entity.*;

public interface IAfterschoolService {
    AuditService audit = AuditService.getInstance();
     void addTeacher(Teacher newTeacher) ;
     void addStudent(Student newStudent);
     void addCourse(Course newCourse) ;
     void changeTeacher(Teacher oldTeacher, Teacher newTeacher);
     void changeInterval(Schedule oldSch, String newInterval);
     void addToSchedule(Schedule newSchedule);
     void getOrar(Schedule schedule);
     void upgradeYear();
     void deleteStudent(Student student) ;
     void deleteEmployee(Employee employee) ;
     void deleteCourse(Course course);
     void payMonthlyFee(Student s, String in);

}
