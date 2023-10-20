package se331.project.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se331.project.rest.dao.StudentDao;
import se331.project.rest.entity.Student;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    final StudentDao studentDao;

    @Override
    public List<Student> getAllStudent() {
        return studentDao.getStudent(Pageable.unpaged()).getContent();
    }

    @Override
    public Page<Student> getStudent(Integer pageSize, Integer page) {
        return studentDao.getStudent(PageRequest.of(pageSize, page));
    }

    @Override
    public Student getStudentById(Long id) {
        return studentDao.getStudentById(id).orElse(null);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Page<Student> getStudents(String name, String surname, Pageable pageReq) {
        return studentDao.getStudents(name, surname, pageReq);
    }

    @Override
    public Page<Student> getStudentByStudentId(Long id, Pageable pageReq) {
        return studentDao.getStudentByStudentId(id, pageReq);
    }


//    @Override
//    public Page<Student> getStudents(String name, Long id, String advisorName, Pageable pageReq) {
//        return null;
//    }
}