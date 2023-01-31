package com.company.entity;
import java.util.ArrayList;
import java.util.Arrays;

public class Excursie extends Activity {
        private Student[] participants;
        private String location;
        private Schedule schedule;
        private ArrayList<Employee> coordinators;

        public Excursie(Student[] participants, String location, Schedule schedule, ArrayList<Employee> coordinators) {
            this.participants = participants;
            this.location = location;
            this.schedule = schedule;
            this.coordinators = coordinators;
        }

        public Student[] getParticipants() { return participants;}
        public void setParticipants(Student[] participants) { this.participants = participants;}
        public String getLocation() { return location;}
        public void setLocation(String location) { this.location = location;}
        public Schedule getSchedule() { return schedule;}
        public void setSchedule(Schedule schedule) { this.schedule = schedule;}
        public ArrayList<Employee> getCoordinators() { return coordinators;}
        public void setCoordinators(ArrayList<Employee> coordinators) {this.coordinators = coordinators;}


        @Override
        public String toString() {
            String str = "\n\nExcursie:\n\t participants: ";
            for (Student s : participants){ str += s.getName() + ", "; }
            str += "\n\t location: " + location + ",\n\t schedule: " + schedule + ",\n\t coordinators: ";
            for (Employee emp : coordinators){ str += emp.getName() + "; "; }
            return str;
        }

        @Override
        public int funLevel() {
            return 0;
        }

}
