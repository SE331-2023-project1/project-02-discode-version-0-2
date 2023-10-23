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
public class HistoryCommentDTO {
    Long id;

    @Builder.Default
    List<HistoryCommentTextDTO> commentHistory = new ArrayList<>();
    Long studentId;
    Long advisorId;
}
