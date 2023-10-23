package se331.project.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.project.rest.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAll();
    Page<Student> findByNameContainingIgnoreCaseOrSurnameContainingIgnoreCaseOrStudentIdIsContainingIgnoreCase(String name, String surname, String number, Pageable pageReq);

}
