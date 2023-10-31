package se331.project.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import se331.project.rest.entity.Advisor;
import se331.project.rest.entity.Student;

import java.util.Optional;

public interface StudentDao {
    Page<Student> getStudent(Pageable pageRequest);
    Optional<Student> getStudentById(Long id);
    Student save(Student Student);
    Page<Student> getStudents (String name, String surname, String studentId, Pageable pageRequest);
    Optional<Student> findById(Long id);

}