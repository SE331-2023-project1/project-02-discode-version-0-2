package se331.project.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    Long id;
    String text;
    Long studentId;
    Long advisorId;
//    List<CommentHistoryDTO> commentsHistory = new ArrayList<>();
}
