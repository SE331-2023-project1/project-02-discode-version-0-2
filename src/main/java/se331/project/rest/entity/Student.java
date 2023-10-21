package se331.project.rest.entity;

import jakarta.persistence.*;
import lombok.*;
import se331.project.rest.security.user.User;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    Long studentId;
    String name;
    String surname;

    @OneToOne
    User user;

    @ManyToOne
    Advisor advisor;

    @ElementCollection
    List<String> images;

//    public void updateForm(Student newStudent) {
//        if (newStudent.getName() != null) {
//            this.name = newStudent.getName();
//        }
//
//        if (newStudent.getSurname() != null) {
//            this.surname = newStudent.getSurname();
//        }
//
//        if (newStudent.getStudentId() != 0) {
//            this.studentId = newStudent.getStudentId();
//        }
//
//        if (newStudent.getImages() != null) {
//            this.images = newStudent.getImages();
//        }
//    }

}
