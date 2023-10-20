package se331.project.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.project.rest.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    Page<Student> getStudent(Integer pageSize, Integer page);
    Student getStudentById (Long id);

    Student save(Student student);
    Page<Student> getStudents (String name, String surname, Pageable pageReq);
    Page<Student> getStudentByStudentId(Long id, Pageable pageReq);
}
