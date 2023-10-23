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
        return studentDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return studentDao.save(student);
    }

//    @Override
//    @Transactional
//    public Student overWrite(Student student) {
//        if (student.getId() != null) {
//            Student existingStudent = studentDao.findById(student.getId()).orElse(null);
//
//            if (existingStudent != null) {
//                existingStudent.updateForm(student);
//                return studentDao.save(existingStudent);
//            }
//        }
//        return studentDao.save(student);
//    }


    @Override
    public Page<Student> getStudents(String name, String surname, String studentId, Pageable pageReq) {
        return studentDao.getStudents(name, surname, studentId, pageReq);
    }

}
