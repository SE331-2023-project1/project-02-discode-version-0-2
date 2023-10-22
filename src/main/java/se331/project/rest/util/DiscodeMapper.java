package se331.project.rest.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import se331.project.rest.entity.*;

import java.util.List;

@Mapper
public interface DiscodeMapper {
    DiscodeMapper INSTANCE = Mappers.getMapper(DiscodeMapper.class);
    StudentDTO getStudentDTO (Student student);
    List<StudentDTO> getStudentDTO (List<Student> studentsList);
    AdvisorDTO getAdvisorDTO (Advisor advisor);
    List<AdvisorDTO> getAdvisorDTO (List<Advisor> advisorList);
    CommentDTO getCommentDTO (Comment comment);
    List<CommentDTO> getCommentDTO (List<Comment> commentList);
    HistoryCommentDTO getHistoryCommentDTO(HistoryComment historyComment);
    List<HistoryCommentDTO> getHistoryCommentDTO(List<HistoryComment> historyComments);


    @Mapping(target = "roles", source = "user.roles")
    AdvisorAuthDTO getAdvisorAuthDTO(Advisor advisor);
    @Mapping(target = "roles", source = "user.roles")
    StudentAuthDTO getStudentAuthDTO(Student student);

}
