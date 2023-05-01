package com.example.University.Event.Management.service;

import com.example.University.Event.Management.dao.StudentRepository;
import com.example.University.Event.Management.model.Department;
import com.example.University.Event.Management.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student addStudent(Student studentData) {
        return studentRepository.save(studentData);
    }


    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }


    public String findById(Integer studentId) {
        if (studentRepository.findById(studentId).isPresent()) {
            Student student = studentRepository.findById(studentId).get();
            return student.toString();
        } else {
            return "please enter valid studentId";
        }
    }

    public boolean deleteStudnet(Integer studentId) {
        if(studentRepository.findById(studentId).isPresent()){
            studentRepository.deleteById(studentId);
            return true;

        }
else{
            return false;
        }
    }

    public boolean updateDepartment(Integer studentId, Student department) {
        if(studentRepository.findById(studentId).isPresent()){
            Student student=studentRepository.findById(studentId).get();
            student.setDepartment(department.getDepartment());
            return true;

        }
        else{
            return false;
        }

    }
}
