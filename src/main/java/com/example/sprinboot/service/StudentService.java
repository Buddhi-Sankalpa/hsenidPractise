package com.example.sprinboot.service;

import com.example.sprinboot.Student;
import com.example.sprinboot.exception.BusinessException;
import com.example.sprinboot.exception.BusinessExceptionType;
import com.example.sprinboot.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<Object> getStudentById(String id) {
            Optional<Student> student = studentRepository.findById(id);
            if (student.isPresent()){
                return ResponseEntity.status(HttpStatus.OK).body(student);
            } else {
                throw (new BusinessException(BusinessExceptionType.RECORD_NOT_FOUND,
                                "No customer record is associated with the id: " + id));
            }
    }

    public ResponseEntity<Student> saveStudent(Student student) {
        try {
            Student savedStudent = studentRepository.save(student);
                return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public ResponseEntity<Object> deleteStudentById(String id){
        Optional<Student> deleteStudent = studentRepository.findById(id);
        if (deleteStudent.isPresent()){
            studentRepository.deleteById(id);
            return ResponseEntity.ok("deleted student : " + deleteStudent);
            }
        else {
            throw (new BusinessException(BusinessExceptionType.RECORD_NOT_FOUND,
                    "No customer record is associated with the id or contact: " + id));
        }

    }
}
