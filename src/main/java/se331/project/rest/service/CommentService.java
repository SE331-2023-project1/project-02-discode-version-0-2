package se331.project.rest.service;

import org.hibernate.annotations.Comments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.project.rest.entity.Comment;


import java.util.List;

public interface CommentService {
    List<Comment> getAllComment();
    Page<Comment> getComment(Integer pageSize, Integer page);
    Comment getCommentById (Long id);
    Page<Comment> getComments (String author, Pageable pageReq);
    Comment save(Comment comment);
}
