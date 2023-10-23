package se331.project.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.project.rest.entity.HistoryComment;

import java.util.List;
import java.util.Optional;

public interface HistoryCommentRepository extends JpaRepository<HistoryComment, Long> {
    List<HistoryComment> findAll();

    Page<HistoryComment> findByStudentIdContainingOrAdvisorId(Long studentId, Long advisorId, Pageable pageReq);

}
