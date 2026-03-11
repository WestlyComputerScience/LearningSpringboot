package com.johnteacher.quickstart.controllers_services_repositories.school;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // signals this class is meant to handle HTTP requests!
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/schools")
    public SchoolDTO createSchool(@RequestBody SchoolDTO dto) {
        return this.schoolService.createSchool(dto);
    }

    @GetMapping("/schools")
    public List<SchoolDTO> getSchools() {
       return this.schoolService.getSchools();
    }

}
