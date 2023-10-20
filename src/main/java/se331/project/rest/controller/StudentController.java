package se331.project.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.project.rest.entity.Student;
import se331.project.rest.service.StudentService;
import se331.project.rest.util.DiscodeMapper;

@Controller
@RequiredArgsConstructor
public class StudentController {
    final StudentService studentService;

    @GetMapping("students")
    public ResponseEntity<?> getEventLists (@RequestParam(value = "_limit",
            required = false) Integer perPage
            , @RequestParam(value = "_page", required = false) Integer page
            , @RequestParam(value = "title", required = false) String title
            , @RequestParam(value = "studentId", required = false) Long id
    ){

        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;

        Page<Student> pageOutput;
        if(id != null ) {
            pageOutput = studentService.getStudentByStudentId(id, PageRequest.of(page-1, perPage));
        }
        else if(title == null){
            pageOutput = studentService.getStudent(page-1, perPage);
        }
        else {
            pageOutput = studentService.getStudents(title, title, PageRequest.of(page-1,perPage));
        }

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));

        System.out.println(pageOutput);
        System.out.println(title);
        return new
                ResponseEntity<>(DiscodeMapper.INSTANCE.getStudentDTO (
                pageOutput.getContent()), responseHeader, HttpStatus.OK);
    }

    @GetMapping("students/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
        Student output = studentService.getStudentById(id);
        if (output != null) {
            return ResponseEntity.ok(DiscodeMapper.INSTANCE.getStudentDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/students")
    public ResponseEntity<?> addEvent (@RequestBody Student student) {
        Student output = studentService.save(student);
        return ResponseEntity.ok(DiscodeMapper.INSTANCE.getStudentDTO(output));
    }
}
