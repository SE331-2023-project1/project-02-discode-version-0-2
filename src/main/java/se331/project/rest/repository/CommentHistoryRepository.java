package se331.project.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.project.rest.entity.HistoryComment;

import java.util.List;

public interface CommentHistoryRepository extends JpaRepository<HistoryComment, Long> {
    List<HistoryComment> findAll();
}
