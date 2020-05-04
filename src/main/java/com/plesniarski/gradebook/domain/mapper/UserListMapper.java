package com.plesniarski.gradebook.domain.mapper;

import com.plesniarski.gradebook.domain.converter.Converter;
import com.plesniarski.gradebook.domain.dto.AllUsersDto;
import com.plesniarski.gradebook.domain.entity.User;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserListMapper implements Converter<List<User>,List<AllUsersDto>> {

    @Override
    public List<AllUsersDto> convert(List<User> from) {
        return from.stream()
                .map(dto -> {
                    return new AllUsersDto.Builder()
                            .name(dto.getName())
                            .lastName(dto.getLastName())
                            .albumNo(dto.getAlbumNo())
                            .admin(dto.isAdmin())
                            .course(dto.getCourse())
                            .id(dto.getUserId())
                            .login(dto.getLogin())
                            .universityId(dto.getUniversityId())
                            .build();
                })
                .collect(Collectors.toList());
    }
}
