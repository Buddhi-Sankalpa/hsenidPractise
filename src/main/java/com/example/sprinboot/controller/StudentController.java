package com.example.sprinboot.controller;

import com.example.sprinboot.Student;
import com.example.sprinboot.exception.BusinessException;
import com.example.sprinboot.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v2/students")
public class StudentController {
    private final StudentService studentService;
    private final Logger logger = LoggerFactory.getLogger(StudentController.class);
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        logger.info("Receiving all students");
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable String id) {
        logger.info("Retrieving student with ID: {}", id);
        try {
            return studentService.getStudentById(id);
        } catch (BusinessException businessException) {
            logger.error("Error retrieving student: {}", businessException.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(businessException.getMessage());
        } catch (Exception e) {
            logger.error("Internal server error: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        try {
            logger.info("Saved a student");
            return studentService.saveStudent(student);
        } catch (Exception e){
            logger.error("Failed to save {}", student);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable String id){
        try {
            logger.info("Deleting student with id {}", id);
            return studentService.deleteStudentById(id);
        } catch (BusinessException businessException){
            logger.error("Failed to delete the student with id: {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(businessException.getMessage());
        } catch (Exception e) {
            logger.error("Failed to delete the student with id: {}", id);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

