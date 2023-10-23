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
import se331.project.rest.entity.Comment;
import se331.project.rest.entity.HistoryComment;
import se331.project.rest.entity.Student;
import se331.project.rest.repository.AdvisorRepository;
import se331.project.rest.repository.CommentHistoryRepository;
import se331.project.rest.repository.CommentRepository;
import se331.project.rest.repository.StudentRepository;
import se331.project.rest.security.user.Role;
import se331.project.rest.security.user.User;
import se331.project.rest.security.user.UserRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    final StudentRepository studentRepository;
    final AdvisorRepository advisorRepository;
    final UserRepository userRepository;
    final CommentHistoryRepository commentHistoryRepository;
    final CommentRepository commentRepository;

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
                .images(List.of("https://i1.rgstatic.net/ii/profile.image/280166027808778-1443808194990_Q512/Chartchai-Doungsa-Ard.jpg"))
                .build());

        a2 = advisorRepository.save(Advisor.builder()
                .id(2L)
                .name("Eve")
                .surname("Apic")
                .email("Eve_Apic@gmail.com")
                .studentList(new ArrayList<>())
                .images(List.of("https://service.camt.cmu.ac.th/person_imgs/apichaka2.jpg"))
                .build());

        a3 = advisorRepository.save(Advisor.builder()
                .id(3L)
                .name("Ball")
                .surname("Parin")
                .email("Ball_Parin@gmail.com")
                .studentList(new ArrayList<>())
                .images(List.of("https://service.camt.cmu.ac.th/person_imgs/parinya.jpg"))
                .build());

        HistoryComment hist1, hist2 ,his3 ;
        Comment c1, c2, c3;


        Student tempStudent;
        tempStudent = studentRepository.save(Student.builder()
                .id(1L)
                .studentId("642115001")
                .name("KORNKANOK")
                .surname("KANCHANA")
                .advisor(a1)
                .images(List.of("https://media.discordapp.net/attachments/1087569641553010780/1165229392155381760/IMG_2925.png?ex=65461770&is=6533a270&hm=401335325e288c0fef7fb8c8b48779de952870e72fe9421bb455598bb97c0bb8&=&width=609&height=636"))
                .build());
        tempStudent.setAdvisor(a1);
        a1.getStudentList().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .id(2L)
                .studentId("642115002")
                .name("KRITTAYOCH")
                .surname("JONGCHAISITTIKUL")
                .advisor(a1)
                .images(List.of("https://th.bing.com/th/id/R.31292b03456379bf84c527e5c7722045?rik=A%2fq7m2EVhRogbg&pid=ImgRaw&r=0"))
                .build());
        tempStudent.setAdvisor(a1);
        a1.getStudentList().add(tempStudent);
        hist1 = commentHistoryRepository.save(HistoryComment.builder()
                .studentId(tempStudent.getId())
                .advisorId(tempStudent.getAdvisor().getId())
                .build());
        c1 = commentRepository.save(Comment.builder()
                .text("Hello World")
                .author(tempStudent.getAdvisor().getName())
                .advisor(a1)
                .student(tempStudent)
                .build());
        c1.setCommentHistory(hist1);
        hist1.getCommentHistory().add(c1);
        c2 = commentRepository.save(Comment.builder()
                .text("Hello Prof")
                .author(tempStudent.getName())
                .advisor(a1)
                .student(tempStudent)
                .build());
        c2.setCommentHistory(hist1);
        hist1.getCommentHistory().add(c2);

        tempStudent = studentRepository.save(Student.builder()
                .id(3L)
                .studentId("642115003")
                .name("KAN")
                .surname("KATPARK")
                .advisor(a1)
                .images(List.of("https://th.bing.com/th/id/R.31292b03456379bf84c527e5c7722045?rik=A%2fq7m2EVhRogbg&pid=ImgRaw&r=0"))
                .build());
        tempStudent.setAdvisor(a1);
        a1.getStudentList().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .id(4L)
                .studentId("642115004")
                .name("KITDANAI")
                .surname("PALEE")
                .advisor(a1)
                .images(List.of("https://th.bing.com/th/id/R.31292b03456379bf84c527e5c7722045?rik=A%2fq7m2EVhRogbg&pid=ImgRaw&r=0"))
                .build());
        tempStudent.setAdvisor(a1);
        a1.getStudentList().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .id(5L)
                .studentId("642115005")
                .name("KITTIPAT")
                .surname("TACHAMANOKUL")
                .advisor(a2)
                .images(List.of("https://th.bing.com/th/id/R.31292b03456379bf84c527e5c7722045?rik=A%2fq7m2EVhRogbg&pid=ImgRaw&r=0"))
                .build());
        tempStudent.setAdvisor(a2);
        a2.getStudentList().add(tempStudent);
        tempStudent = studentRepository.save(Student.builder()
                .id(6L)
                .studentId("642115006")
                .name("JAKKAPHAT")
                .surname("PLOYLAKE")
                .advisor(a2)
                .images(List.of("https://th.bing.com/th/id/R.31292b03456379bf84c527e5c7722045?rik=A%2fq7m2EVhRogbg&pid=ImgRaw&r=0"))
                .build());
        tempStudent.setAdvisor(a2);
        a2.getStudentList().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .id(7L)
                .studentId("642115008")
                .name("JIRAPAT")
                .surname("NAMWONG")
                .advisor(a2)
                .images(List.of("https://th.bing.com/th/id/R.31292b03456379bf84c527e5c7722045?rik=A%2fq7m2EVhRogbg&pid=ImgRaw&r=0"))
                .build());
        tempStudent.setAdvisor(a2);
        a2.getStudentList().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .id(8L)
                .studentId("642115009")
                .name("JULALUCK")
                .surname("KYETAATPARK")
                .advisor(a2)
                .images(List.of("https://th.bing.com/th/id/R.31292b03456379bf84c527e5c7722045?rik=A%2fq7m2EVhRogbg&pid=ImgRaw&r=0"))
                .build());
        tempStudent.setAdvisor(a2);
        a2.getStudentList().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .id(9L)
                .studentId("642115011")
                .name("YANWARUT")
                .surname("SUKSAWAT")
                .advisor(a3)
                .images(List.of("https://th.bing.com/th/id/R.31292b03456379bf84c527e5c7722045?rik=A%2fq7m2EVhRogbg&pid=ImgRaw&r=0"))
                .build());
        tempStudent.setAdvisor(a3);
        a3.getStudentList().add(tempStudent);


        tempStudent = studentRepository.save(Student.builder()
                .id(10L)
                .studentId("642115015")
                .name("YADA")
                .surname("LAKHONJUN")
                .advisor(a3)
                .images(List.of("https://th.bing.com/th/id/R.31292b03456379bf84c527e5c7722045?rik=A%2fq7m2EVhRogbg&pid=ImgRaw&r=0"))
                .build());
        tempStudent.setAdvisor(a3);
        a3.getStudentList().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .id(11L)
                .studentId("642115016")
                .name("DANAIKRIT")
                .surname("JAIWONG")
                .advisor(a3)
                .images(List.of("https://th.bing.com/th/id/R.31292b03456379bf84c527e5c7722045?rik=A%2fq7m2EVhRogbg&pid=ImgRaw&r=0"))
                .build());
        tempStudent.setAdvisor(a3);
        a3.getStudentList().add(tempStudent);

        Student s17 = studentRepository.save(Student.builder()
                .id(12L)
                .studentId("642115017")
                .name("DUSIT")
                .surname("CHUNVISET")
                .advisor(a3)
                .images(List.of("https://th.bing.com/th/id/R.31292b03456379bf84c527e5c7722045?rik=A%2fq7m2EVhRogbg&pid=ImgRaw&r=0"))
                .build());
        s17.setAdvisor(a3);
        a3.getStudentList().add(s17);


        tempStudent = studentRepository.save(Student.builder()
                .id(13L)
                .studentId("642115019")
                .name("TANINWAT")
                .surname("PHUTTICHAIWARANGKUL")
                .advisor(a1)
                .images(List.of("https://th.bing.com/th/id/R.31292b03456379bf84c527e5c7722045?rik=A%2fq7m2EVhRogbg&pid=ImgRaw&r=0"))
                .build());
        tempStudent.setAdvisor(a1);
        a1.getStudentList().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .id(14L)
                .studentId("642115020")
                .name("THIWAKON")
                .surname("SAKUNCHAO")
                .advisor(a2)
                .images(List.of("https://th.bing.com/th/id/R.31292b03456379bf84c527e5c7722045?rik=A%2fq7m2EVhRogbg&pid=ImgRaw&r=0"))
                .build());
        tempStudent.setAdvisor(a2);
        a2.getStudentList().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .id(15L)
                .studentId("642115021")
                .name("TANAKORN")
                .surname("WALEECHAROENPONG")
                .advisor(a3)
                .images(List.of("https://th.bing.com/th/id/R.31292b03456379bf84c527e5c7722045?rik=A%2fq7m2EVhRogbg&pid=ImgRaw&r=0"))
                .build());
        tempStudent.setAdvisor(a3);
        a3.getStudentList().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .id(16L)
                .studentId("642115022")
                .name("TANAPONG")
                .surname("YAMKAMOL")
                .advisor(a1)
                .images(List.of("https://th.bing.com/th/id/R.31292b03456379bf84c527e5c7722045?rik=A%2fq7m2EVhRogbg&pid=ImgRaw&r=0"))
                .build());
        tempStudent.setAdvisor(a3);
        a3.getStudentList().add(tempStudent);


        addUser();

        a1.setUser(user1);
        user1.setAdvisor(a1);

        a2.setUser(user2);
        user2.setAdvisor(a2);
        user2.setFirstname(a2.getName());
        user2.setLastname(a2.getSurname());

        s17.setUser(user3);
        user3.setStudent(s17);
        user3.setStudentId("642115017");
        user3.setFirstname(s17.getName());
        user3.setLastname(s17.getSurname());

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
                .username("teacher")
                .password(encoder.encode("teacher"))
                .firstname("advisorUser")
                .lastname("advisorUser")
                .email("advisor@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user3 = User.builder()
                .username("user")
                .password(encoder.encode("user"))
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
