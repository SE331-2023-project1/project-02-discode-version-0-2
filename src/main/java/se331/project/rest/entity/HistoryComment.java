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
public class HistoryComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    Long studentId;
    Long advisorId;


    @OneToMany(mappedBy = "commentHistory")
    @Builder.Default
    List<Comment> history = new ArrayList<>();

}