package com.example.sprinboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Student {
    @Id
    private String id;
    private String name;
    private LocalDate dob;
    private double average;

    public Student(String name, LocalDate dob, double average) {
        this.name = name;
        this.dob = dob;
        this.average = average;
    }
}
