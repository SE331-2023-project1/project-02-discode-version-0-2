package se331.project.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.project.rest.entity.Comment;
import se331.project.rest.entity.Student;
import se331.project.rest.service.CommentService;
import se331.project.rest.util.DiscodeMapper;

@Controller
@RequiredArgsConstructor
public class CommentController {
    final CommentService commentService;

    @GetMapping("comments")
    public ResponseEntity<?> getCommentList (@RequestParam(value = "_limit",
            required = false) Integer perPage
            , @RequestParam(value = "_page", required = false) Integer page
            , @RequestParam(value = "title", required = false) String title
    ){

        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;

        Page<Comment> pageOutput;

        if(title == null){
            pageOutput = commentService.getComment(page-1, perPage);
        }
        else {
            pageOutput = commentService.getComments(title, PageRequest.of(page-1,perPage));
        }

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));

        System.out.println(pageOutput);
        System.out.println(title);
        return new
                ResponseEntity<>(DiscodeMapper.INSTANCE.getCommentDTO (
                pageOutput.getContent()), responseHeader, HttpStatus.OK);
    }

    @GetMapping("comments/{id}")
    public ResponseEntity<?> getComment(@PathVariable("id") Long id) {
        Comment output = commentService.getCommentById(id);
        if (output != null) {
            return ResponseEntity.ok(DiscodeMapper.INSTANCE.getCommentDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/comments")
    public ResponseEntity<?> addComment (@RequestBody Comment comment) {
        Comment output = commentService.save(comment);
        return ResponseEntity.ok(DiscodeMapper.INSTANCE.getCommentDTO(output));
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<?> updateComment(@PathVariable("id") Long id, @RequestBody Comment updateComment) {
        Comment existingcComment = commentService.getCommentById(id);
        if (existingcComment != null) {
            if (updateComment.getText() != null) {
                existingcComment.setText(updateComment.getText());
            }
            Comment output = commentService.save(existingcComment);
            return ResponseEntity.ok(DiscodeMapper.INSTANCE.getCommentDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }
}

