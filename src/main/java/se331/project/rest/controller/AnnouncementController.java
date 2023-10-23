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
import se331.project.rest.entity.Announcement;
import se331.project.rest.service.AnnouncementService;
import se331.project.rest.util.DiscodeMapper;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AnnouncementController {
    List<Announcement> announcementList;
    final AnnouncementService announcementService;
    @GetMapping("anns")
    public ResponseEntity<?> getAnnouncementLists(@RequestParam(value ="_limit", required = false) Integer perPage,
                                                  @RequestParam(value = "_page", required = false) Integer page,
                                                  @RequestParam(value = "id", required = false) Long id) {

        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Announcement> pageOutput;
        if (id == null) {
            pageOutput = announcementService.getAnnouncement(perPage,page);
        }else{
            pageOutput = announcementService.getAnnouncements(id, PageRequest.of(page-1,perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(DiscodeMapper.INSTANCE.getAnnouncementDTO(pageOutput.getContent()),responseHeader,HttpStatus.OK);

    }

    @GetMapping("anns/{id}")
    public ResponseEntity<?> getAnnouncement(@PathVariable("id") Long id) {
        Announcement output = announcementService.getAnnouncementById(id);
        if (output != null){
            return ResponseEntity.ok(DiscodeMapper.INSTANCE.getAnnouncementDTO(output));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }

    @PostMapping("/anns")
    public ResponseEntity<?> addAnnouncement(@RequestBody Announcement announcement){
        Announcement output = announcementService.save(announcement);
        return ResponseEntity.ok(DiscodeMapper.INSTANCE.getAnnouncementDTO(output));
    }

}
