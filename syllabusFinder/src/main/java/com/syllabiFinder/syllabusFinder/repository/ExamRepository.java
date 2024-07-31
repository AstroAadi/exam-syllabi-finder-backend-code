package com.syllabiFinder.syllabusFinder.repository;

import com.syllabiFinder.syllabusFinder.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> findByNameContainingIgnoreCase(String name);
}

