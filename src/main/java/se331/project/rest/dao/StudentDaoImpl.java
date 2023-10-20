package se331.project.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.project.rest.entity.Student;
import se331.project.rest.repository.StudentRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class StudentDaoImpl implements StudentDao{
    final StudentRepository studentRepository;

    @Override
    public Page<Student> getStudent(Pageable pageRequest) {
        return studentRepository.findAll(pageRequest);
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Page<Student> getStudents(String name, String surname, Pageable pageRequest) {
        return studentRepository.findByNameContainingIgnoreCaseOrSurnameContainingIgnoreCase
                (name, surname, pageRequest);
    }

    @Override
    public Page<Student> getStudentByStudentId(Long id, Pageable pageReq) {
        return studentRepository.findByStudentIdContainingIgnoreCase(id, pageReq);
    }
}
