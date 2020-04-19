package com.plesniarski.gradebook.service.serviceImpl;

import com.plesniarski.gradebook.domain.converter.Converter;
import com.plesniarski.gradebook.domain.dto.UniversityDto;
import com.plesniarski.gradebook.domain.entity.University;
import com.plesniarski.gradebook.domain.repository.UniversityRepository;
import com.plesniarski.gradebook.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {
    private final UniversityRepository universityRepository;
    private final Converter<University, UniversityDto> universityDtoConverter;
    private final Converter<UniversityDto, University> dtoUniversityConverter;

    @Autowired
    public UniversityServiceImpl(UniversityRepository universityRepository, Converter<University, UniversityDto> universityDtoConverter, Converter<UniversityDto, University> dtoUniversityConverter) {
        this.universityRepository = universityRepository;
        this.universityDtoConverter = universityDtoConverter;
        this.dtoUniversityConverter = dtoUniversityConverter;
    }


    @Override
    public List<University> findAll() {
        return universityRepository.findAll();
    }

    @Override
    public University addUniversity(UniversityDto universityDto) {
        University university = dtoUniversityConverter.convert(universityDto);
        universityRepository.save(university);
        System.out.println(university.getUniversityId()+" "+university.getUniversityName());
        return university;
    }

}
