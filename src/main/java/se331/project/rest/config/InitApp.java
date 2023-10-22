package se331.project.rest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se331.project.rest.entity.Advisor;
import se331.project.rest.entity.HistoryComment;
import se331.project.rest.entity.Student;
import se331.project.rest.repository.AdvisorRepository;
import se331.project.rest.repository.StudentRepository;
import se331.project.rest.security.user.Role;
import se331.project.rest.security.user.User;
import se331.project.rest.security.user.UserRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    final StudentRepository studentRepository;
    final AdvisorRepository advisorRepository;
    final UserRepository userRepository;

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

        a2 = advisorRepository.save(Advisor.builder()
                .id(1L)
                .name("Eve")
                .surname("Apic")
                .email("Eve_Apic@gmail.com")
                .studentList(new ArrayList<>())
                .build());

        a3 = advisorRepository.save(Advisor.builder()
                .id(1L)
                .name("Ball")
                .surname("Parin")
                .email("Ball_Parin@gmail.com")
                .studentList(new ArrayList<>())
                .build());

        HistoryComment hist1, hist2 ,his3 ;

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
                .advisor(a1)
                .build());
        tempStudent.setAdvisor(a1);
        a1.getStudentList().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .id(4L)
                .studentId(642115004L)
                .name("KITDANAI")
                .surname("PALEE")
                .advisor(a1)
                .build());
        tempStudent.setAdvisor(a1);
        a1.getStudentList().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .id(5L)
                .studentId(642115005L)
                .name("KITTIPAT")
                .surname("TACHAMANOKUL")
                .advisor(a2)
                .build());
        tempStudent.setAdvisor(a2);
        a2.getStudentList().add(tempStudent);
        tempStudent = studentRepository.save(Student.builder()
                .id(6L)
                .studentId(642115006L)
                .name("JAKKAPHAT")
                .surname("PLOYLAKE")
                .advisor(a2)
                .build());
        tempStudent.setAdvisor(a2);
        a2.getStudentList().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .id(7L)
                .studentId(642115008L)
                .name("JIRAPAT")
                .surname("NAMWONG")
                .advisor(a2)
                .build());
        tempStudent.setAdvisor(a2);
        a2.getStudentList().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .id(8L)
                .studentId(642115009L)
                .name("JULALUCK")
                .surname("KYETAATPARK")
                .advisor(a2)
                .build());
        tempStudent.setAdvisor(a2);
        a2.getStudentList().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .id(9L)
                .studentId(642115011L)
                .name("YANWARUT")
                .surname("SUKSAWAT")
                .advisor(a3)
                .build());
        tempStudent.setAdvisor(a3);
        a3.getStudentList().add(tempStudent);


        tempStudent = studentRepository.save(Student.builder()
                .id(10L)
                .studentId(642115015L)
                .name("YADA")
                .surname("LAKHONJUN")
                .advisor(a3)
                .build());
        tempStudent.setAdvisor(a3);
        a3.getStudentList().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .id(11L)
                .studentId(642115016L)
                .name("DANAIKRIT")
                .surname("JAIWONG")
                .advisor(a3)
                .build());
        tempStudent.setAdvisor(a3);
        a3.getStudentList().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .id(12L)
                .studentId(642115017L)
                .name("DUSIT")
                .surname("CHUNVISET")
                .advisor(a3)
                .build());
        tempStudent.setAdvisor(a3);
        a3.getStudentList().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .id(13L)
                .studentId(642115019L)
                .name("TANINWAT")
                .surname("PHUTTICHAIWARANGKUL")
                .advisor(a1)
                .build());
        tempStudent.setAdvisor(a3);
        a3.getStudentList().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .id(14L)
                .studentId(642115020L)
                .name("THIWAKON")
                .surname("SAKUNCHAO")
                .advisor(a2)
                .build());
        tempStudent.setAdvisor(a3);
        a3.getStudentList().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .id(15L)
                .studentId(642115021L)
                .name("TANAKORN")
                .surname("WALEECHAROENPONG")
                .advisor(a3)
                .build());
        tempStudent.setAdvisor(a3);
        a3.getStudentList().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .id(16L)
                .studentId(642115022L)
                .name("TANAPONG")
                .surname("YAMKAMOL")
                .advisor(a1)
                .build());
        tempStudent.setAdvisor(a3);
        a3.getStudentList().add(tempStudent);


        addUser();
//        a1.setUser(user1);
//        user1.setAdvisor(a1);
        a1.setUser(user1);
        user1.setAdvisor(a1);
//        a1.setUser(user3);
//        user3.setAdvisor(a1);
    }

    User user1, user2, user3;
    private void addUser() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        user1 = User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user2 = User.builder()
                .username("advisor")
                .password(encoder.encode("advisor"))
                .firstname("advisorUser")
                .lastname("advisorUser")
                .email("advisor@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user3 = User.builder()
                .username("student")
                .password(encoder.encode("student"))
                .firstname("studentUSer")
                .lastname("studentUSer")
                .email("student@cmu.ca.th")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();


        user1.getRoles().add(Role.ROLE_ADMIN);
        user2.getRoles().add(Role.ROLE_ADVISOR);
        user3.getRoles().add(Role.ROLE_STUDENT);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }


}
