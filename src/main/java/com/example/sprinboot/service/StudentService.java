package com.example.sprinboot.service;

import com.example.sprinboot.Student;
import com.example.sprinboot.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(String id){
        Optional<Student> byId = studentRepository.findById(id);
        if (byId.isPresent()){
            return byId;
        }
        else {
            throw new RuntimeException("Student not found");
        }
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public boolean deleteStudentById(String id){
        Optional<Student> byId = studentRepository.findById(id);

        if (byId.isPresent()){
            studentRepository.deleteById(id);
            return true;
        }
        else return false;
    }
}
