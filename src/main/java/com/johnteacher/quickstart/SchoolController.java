package com.johnteacher.quickstart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController // signals this class is meant to handle HTTP requests!
public class SchoolController {

    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public SchoolDTO createSchool(@RequestBody SchoolDTO dto) {
        School school = toSchool(dto);
        schoolRepository.save(school); // save the school to repository
        return dto; // Spring converts the returned object into JSON format
    }

    private School toSchool(SchoolDTO dto) {
        return new School(dto.name());
    }

    // converts School into DTO
    private SchoolDTO toSchoolDTO(School school) {
        return new SchoolDTO(school.getName());
    }

    @GetMapping("/schools")
    public List<SchoolDTO> getSchools() {
        // interesting, calls a finalALL(), but applies a method to the stream, lol
        return schoolRepository.findAll().stream().map(this::toSchoolDTO).collect(Collectors.toList()); // finds all JSON school objects
    }

}
