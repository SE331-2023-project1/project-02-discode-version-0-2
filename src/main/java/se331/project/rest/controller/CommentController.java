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

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommentController {
    final CommentService commentService;
    @GetMapping("comments")
    public ResponseEntity<?> getCommentMessageLists(@RequestParam(value ="_limit", required = false) Integer perPage,
                                                    @RequestParam(value = "_page", required = false) Integer page,
                                                    @RequestParam(value = "title", required = false) String title) {

        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Comment> pageOutput;
        if (title == null) {
            pageOutput = commentService.getComment(perPage,page);
        }else{
            pageOutput = commentService.getComments(title,PageRequest.of(page-1,perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(DiscodeMapper.INSTANCE.getCommentDTO(pageOutput.getContent()),responseHeader,HttpStatus.OK);

    }

    @GetMapping("comments/{id}")
    public ResponseEntity<?> getCommentMessage(@PathVariable("id") Long id) {
        Comment output = commentService.getCommentById(id);
        if (output != null){
            return ResponseEntity.ok(DiscodeMapper.INSTANCE.getCommentDTO(output));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }

    @PostMapping("/comments")
    public ResponseEntity<?> addCommentMessage(@RequestBody Comment CommentMessage){
        Comment output = commentService.save(CommentMessage);
        return ResponseEntity.ok(DiscodeMapper.INSTANCE.getCommentDTO(output));
    }

}

