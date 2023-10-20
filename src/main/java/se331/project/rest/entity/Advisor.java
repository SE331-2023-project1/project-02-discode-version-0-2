package se331.project.rest.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Advisor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String name;
    String surname;
    String email;

    @OneToMany(mappedBy = "advisor")
    @Builder.Default
    List<Student> studentList = new ArrayList<>();

    @ElementCollection
    List<String> images;
}
