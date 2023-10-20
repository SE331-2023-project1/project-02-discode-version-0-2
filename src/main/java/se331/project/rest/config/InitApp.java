package se331.project.rest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se331.project.rest.entity.Advisor;
import se331.project.rest.entity.Student;
import se331.project.rest.repository.AdvisorRepository;
import se331.project.rest.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    final StudentRepository studentRepository;
    final AdvisorRepository advisorRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Advisor a1 , a2, a3;
        a1 = advisorRepository.save(Advisor.builder()
                .id(1L)
                .name("Jan")
                .surname("Toe")
                .email("Jan_Toe@gmail.com")
                .studentList(new ArrayList<>())
                .build());


        Student tempStudent;
        tempStudent = studentRepository.save(Student.builder()
                .id(1L)
                .studentId(642115001L)
                .name("KORNKANOK")
                .surname("KANCHANA")
                .advisor(a1)
                .build());
        tempStudent.setAdvisor(a1);
        a1.getStudentList().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .id(2L)
                .studentId(642115002L)
                .name("KRITTAYOCH")
                .surname("JONGCHAISITTIKUL")
                .advisor(a1)
                .build());
        tempStudent.setAdvisor(a1);
        a1.getStudentList().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .id(3L)
                .studentId(642115003L)
                .name("KAN")
                .surname("KATPARK")
//                .advisorId()
                .build());

        tempStudent = studentRepository.save(Student.builder()
                .id(4L)
                .studentId(642115004L)
                .name("KITDANAI")
                .surname("PALEE")
//                .advisorId()
                .build());

        tempStudent = studentRepository.save(Student.builder()
                .id(5L)
                .studentId(642115005L)
                .name("KITTIPAT")
                .surname("TACHAMANOKUL")
//                .advisorId()
                .build());
        tempStudent = studentRepository.save(Student.builder()
                .id(6L)
                .studentId(642115006L)
                .name("JAKKAPHAT")
                .surname("PLOYLAKE")
//                .advisorId()
                .build());

        tempStudent = studentRepository.save(Student.builder()
                .id(7L)
                .studentId(642115008L)
                .name("JIRAPAT")
                .surname("NAMWONG")
//                .advisorId()
                .build());

        tempStudent = studentRepository.save(Student.builder()
                .id(8L)
                .studentId(642115009L)
                .name("JULALUCK")
                .surname("KYETAATPARK")
//                .advisorId()
                .build());

        tempStudent = studentRepository.save(Student.builder()
                .id(9L)
                .studentId(642115011L)
                .name("YANWARUT")
                .surname("SUKSAWAT")
//                .advisorId()
                .build());

        tempStudent = studentRepository.save(Student.builder()
                .id(10L)
                .studentId(642115015L)
                .name("YADA")
                .surname("LAKHONJUN")
//                .advisorId()
                .build());

        tempStudent = studentRepository.save(Student.builder()
                .id(11L)
                .studentId(642115016L)
                .name("DANAIKRIT")
                .surname("JAIWONG")
//                .advisorId()
                .build());

        tempStudent = studentRepository.save(Student.builder()
                .id(12L)
                .studentId(642115017L)
                .name("DUSIT")
                .surname("CHUNVISET")
//                .advisorId()
                .build());

        tempStudent = studentRepository.save(Student.builder()
                .id(13L)
                .studentId(642115019L)
                .name("TANINWAT")
                .surname("PHUTTICHAIWARANGKUL")
//                .advisorId()
                .build());

        tempStudent = studentRepository.save(Student.builder()
                .id(14L)
                .studentId(642115020L)
                .name("THIWAKON")
                .surname("SAKUNCHAO")
//                .advisorId()
                .build());

        tempStudent = studentRepository.save(Student.builder()
                .id(15L)
                .studentId(642115021L)
                .name("TANAKORN")
                .surname("WALEECHAROENPONG")
//                .advisorId()
                .build());

        tempStudent = studentRepository.save(Student.builder()
                .id(16L)
                .studentId(642115022L)
                .name("TANAPONG")
                .surname("YAMKAMOL")
//                .advisorId()
                .build());




    }


}
