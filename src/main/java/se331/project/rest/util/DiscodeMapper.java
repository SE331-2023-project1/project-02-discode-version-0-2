package se331.project.rest.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.project.rest.entity.Advisor;
import se331.project.rest.entity.AdvisorDTO;
import se331.project.rest.entity.Student;
import se331.project.rest.entity.StudentDTO;

import java.util.List;

@Mapper
public interface DiscodeMapper {
    DiscodeMapper INSTANCE = Mappers.getMapper(DiscodeMapper.class);
    StudentDTO getStudentDTO (Student student);
    List<StudentDTO> getStudentDTO (List<Student> studentsList);
    AdvisorDTO getAdvisorDTO (Advisor advisor);
    List<AdvisorDTO> getAdvisorDTO (List<Advisor> advisorList);
}
