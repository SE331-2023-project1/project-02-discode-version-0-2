package se331.project.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.project.rest.entity.HistoryComment;
import se331.project.rest.repository.CommentHistoryRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class HistoryCommentDaoImpl implements HistoryCommentDao{
    final CommentHistoryRepository commentHistoryRepository;

    @Override
    public Page<HistoryComment> getHistoryComment(Pageable pageRequest) {
        return commentHistoryRepository.findAll(pageRequest);
    }

    @Override
    public Optional<HistoryComment> findById(Long id) {
        return commentHistoryRepository.findById(id);
    }

    @Override
    public HistoryComment save(HistoryComment commentHistory) {
        return commentHistoryRepository.save(commentHistory);
    }

    @Override
    public Page<HistoryComment> getHistoryComments(Long studentId, Long AdvisorId, Pageable pageReq) {
        return commentHistoryRepository.findByStudentIdContainingOrAdvisorId(studentId, AdvisorId, pageReq);
    }
}
