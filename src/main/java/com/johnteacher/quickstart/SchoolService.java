package com.johnteacher.quickstart;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    public SchoolDTO createSchool(SchoolDTO dto) {
        School school = schoolMapper.toSchool(dto);
        schoolRepository.save(school); // save the school to repository
        return dto; // Spring converts the returned object into JSON format
    }

    public List<SchoolDTO> getSchools() {
        // interesting, calls a finalALL(), but applies a method to the stream, lol
        return schoolRepository.findAll().stream().map(schoolMapper::toSchoolDTO).collect(Collectors.toList()); // finds all JSON school objects
    }

}
