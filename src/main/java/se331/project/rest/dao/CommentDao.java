package se331.project.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.project.rest.entity.Comment;

import java.util.Optional;

public interface CommentDao {
    Page<Comment> getComment(Pageable pageRequest);
    Optional<Comment> findById(Long id);
    Comment save(Comment comment);

    Page<Comment> getComments (String author, Pageable pageReq);
}
