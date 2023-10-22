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
import se331.project.rest.entity.HistoryComment;
import se331.project.rest.service.HistoryCommentService;
import se331.project.rest.util.DiscodeMapper;

@Controller
@RequiredArgsConstructor
public class HistoryCommentController {
    final HistoryCommentService historyCommentService;
    @GetMapping("historyComments")
    public ResponseEntity<?> getHistoryCommentList (@RequestParam(value = "_limit",
            required = false) Integer perPage
            , @RequestParam(value = "_page", required = false) Integer page
            , @RequestParam(value = "Id", required = false) Long Id
    ){

        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;

        Page<HistoryComment> pageOutput;

        if(Id == null){
            pageOutput = historyCommentService.getHistoryComment(page-1, perPage);
        }
        else {
            pageOutput = historyCommentService.getHistoryComments(Id, Id, PageRequest.of(page-1,perPage));
        }

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));

        System.out.println(pageOutput);
        System.out.println(Id);
        return new
                ResponseEntity<>(DiscodeMapper.INSTANCE.getHistoryCommentDTO (
                pageOutput.getContent()), responseHeader, HttpStatus.OK);
    }

    @GetMapping("historyComments/{id}")
    public ResponseEntity<?> getComment(@PathVariable("id") Long id) {
        HistoryComment output = historyCommentService.getHistoryCommentById(id);
        if (output != null) {
            return ResponseEntity.ok(DiscodeMapper.INSTANCE.getHistoryCommentDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/historyComments")
    public ResponseEntity<?> addComment (@RequestBody HistoryComment historyComment) {
        HistoryComment output = historyCommentService.save(historyComment);
        return ResponseEntity.ok(DiscodeMapper.INSTANCE.getHistoryCommentDTO(output));
    }
}
