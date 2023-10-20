package se331.project.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.project.rest.entity.Advisor;
import se331.project.rest.service.AdvisorService;
import se331.project.rest.util.DiscodeMapper;

@RestController
@RequiredArgsConstructor
public class AdvisorController {
    final AdvisorService advisorService;

    @GetMapping("/advisors")
    ResponseEntity<?> getAdvisors() {
        System.out.println(DiscodeMapper.INSTANCE.getAdvisorDTO(advisorService.getAllAdvisor()));
        return ResponseEntity.ok(DiscodeMapper.INSTANCE.getAdvisorDTO(advisorService.getAllAdvisor()));

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
