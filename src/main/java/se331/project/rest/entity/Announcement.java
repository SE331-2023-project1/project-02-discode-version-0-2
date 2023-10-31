package se331.project.rest.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;

    @ManyToOne
    @JoinColumn(name = "advisor_id")
    Advisor advisor;

    String title;
    String description;

    @ElementCollection
    List<String> files;

}
