package com.example.University.Event.Management.controller;

import com.example.University.Event.Management.model.Department;
import com.example.University.Event.Management.model.Student;
import com.example.University.Event.Management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping(value="/saveStudent")
    public ResponseEntity<String>addStudent(@RequestBody Student studentData){
        Student student=studentService.addStudent(studentData);
        return new ResponseEntity<>("Student added", HttpStatus.OK);

    }
    @GetMapping(value="/student")
    public List<Student> getStudent(){
       List<Student>studentList= studentService.getAllStudent();
       return studentList;
    }
    @GetMapping(value="/student/{studentId}")
    public ResponseEntity<String> getStudentById(@PathVariable Integer studentId){
        if(studentId!=null){
         String student=studentService.findById(studentId);
       return new ResponseEntity<>(student,HttpStatus.FOUND);
      }
else{
    return new ResponseEntity<>("please enter valid studentId",HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping(value="/deleteStudent/{studentId}")
    public ResponseEntity<String>deleteStudent(@PathVariable Integer studentId){
        boolean student=studentService.deleteStudnet(studentId);
        if(student){

            return new ResponseEntity<>("Student deleted with Id-> "+studentId,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("please enter valid studentId",HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping(value="/updateStudent/{studentId}/dept/{department}")
    public ResponseEntity<String>updateStudentDep(@PathVariable Integer studentId, @RequestBody Student department){
        boolean ans=studentService.updateDepartment(studentId,department);
        if(ans){
            return new ResponseEntity<>("Department updated",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("please enter valid studentId",HttpStatus.BAD_REQUEST);
        }
    }
}
