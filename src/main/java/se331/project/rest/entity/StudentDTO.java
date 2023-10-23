package se331.project.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    Long id;
    Long studentId;
    String name;
    String surname;
    String[] courseList;
    StudentAdvisorDTO advisor;
    List<String> images;
    List<CommentDTO> comments;
}
