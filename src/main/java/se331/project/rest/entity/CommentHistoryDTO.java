package se331.project.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentHistoryDTO {
    Long id;
    String Text;
    Long studentId;
    Long advisorId;
}
