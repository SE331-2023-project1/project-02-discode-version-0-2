package se331.project.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.project.rest.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    Page<Student> getStudent(Integer page, Integer perPage);
    Student getStudentById (Long id);

    Student save(Student student);
    Page<Student> getStudents (String name, String surname, String studentId,Pageable pageReq);
//    Student overWrite(Student student);
}
