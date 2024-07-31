package com.syllabiFinder.syllabusFinder.controller;

import com.syllabiFinder.syllabusFinder.model.Exam;
import com.syllabiFinder.syllabusFinder.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
//public class ExamController {
//
//    @Autowired
//    private ExamRepository examRepository;
//
//    @GetMapping("/search")
//    public List<Exam> searchExams(@RequestParam String query) {
//        return examRepository.findByNameContainingIgnoreCase(query);
//    }
//
//    @GetMapping("/popular-exams")
//    public List<Exam> getPopularExams() {
//        // Replace this with your logic to fetch popular exams
//        return examRepository.findAll(); // Example logic, replace with actual popular exams logic
//    }
//}
import java.util.List;

@RestController
public class ExamController {

    @Autowired
    private ExamRepository examRepository;

    @GetMapping("/api/exams")
    public List<Exam> getExams(@RequestParam(required = false, defaultValue = "") String q) {
        if (q.isEmpty()) {
            return examRepository.findAll();
        } else {
            return examRepository.findByNameContainingIgnoreCase(q);
        }
    }

    @GetMapping("/api/popular-exams")
    public List<Exam> getPopularExams() {
        return examRepository.findAll(); // Example logic, replace with actual popular exams logic
    }
}