package com.company.service;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class AuditService {
    public static AuditService instance = null;
    private AuditService() {}

    public static AuditService getInstance(){
        if (instance == null){
            instance = new AuditService();
        }
        return instance;
    }

    public void write(String action){
        try {
            FileWriter fileWriter = new FileWriter("data/audit.csv", true); // append:true => scrie la sfarsitul fisierului, nu la inceput
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            fileWriter.write(action + ", " + timestamp.toString() + "\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Fisierul nu a putut fi deschis.");
        }
    }
}
