package se331.project.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.project.rest.entity.Advisor;
import se331.project.rest.entity.Student;
import se331.project.rest.service.AdvisorService;
import se331.project.rest.util.DiscodeMapper;

@RestController
@RequiredArgsConstructor
public class AdvisorController {
    final AdvisorService advisorService;

    @GetMapping("advisors")
    public ResponseEntity<?> getAdvisorList (@RequestParam(value = "_limit",
            required = false) Integer perPage
            , @RequestParam(value = "_page", required = false) Integer page
            , @RequestParam(value = "title", required = false) String title
    ){

        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;

        Page<Advisor> pageOutput;

        if(title == null){
            pageOutput = advisorService.getAdvisor(page-1, perPage);
        }
        else {
            pageOutput = advisorService.getAdvisors(title, title, PageRequest.of(page-1,perPage));
        }

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));

        System.out.println(pageOutput);
        System.out.println(title);
        return new
                ResponseEntity<>(DiscodeMapper.INSTANCE.getAdvisorDTO (
                pageOutput.getContent()), responseHeader, HttpStatus.OK);
    }

    @GetMapping("advisors/{id}")
    public ResponseEntity<?> getAdvisor(@PathVariable("id") Long id) {
        Advisor output = advisorService.getAdvisorById(id);
        if (output != null) {
            return ResponseEntity.ok(DiscodeMapper.INSTANCE.getAdvisorDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/advisors")
    public ResponseEntity<?> addAdvisor (@RequestBody Advisor advisor) {
        Advisor output = advisorService.save(advisor);
        return ResponseEntity.ok(DiscodeMapper.INSTANCE.getAdvisorDTO(output));
    }
}
