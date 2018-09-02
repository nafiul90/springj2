package com.nafiul.demo.controller;

import com.nafiul.demo.model.Address;
import com.nafiul.demo.model.Name;
import com.nafiul.demo.model.Phone;
import com.nafiul.demo.model.Student;
import com.nafiul.demo.repositorys.AddressRepo;
import com.nafiul.demo.repositorys.PhoneRepo;
import com.nafiul.demo.repositorys.StudentRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {


    private StudentRepo studentRepo;
    private AddressRepo addressRepo;
    private PhoneRepo phoneRepo;

    public StudentController(StudentRepo studentRepo, AddressRepo addressRepo, PhoneRepo phoneRepo) {
        this.studentRepo = studentRepo;
        this.addressRepo = addressRepo;
        this.phoneRepo = phoneRepo;
    }

    @PostMapping("addStudent")
    @ResponseBody
    public Student addStudent(@RequestBody Student student){
        studentRepo.save(student);
        return student;

    }

    @GetMapping("students")
    @ResponseBody
    public Iterable<Student> getAllStudent(){
        return studentRepo.findAll();
    }

    @GetMapping("student/{id}")
    @ResponseBody
    public Optional<Student> getStudent(@PathVariable int id){
        return studentRepo.findById(id);
    }
}
