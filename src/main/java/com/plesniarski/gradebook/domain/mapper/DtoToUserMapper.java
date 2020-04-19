package com.plesniarski.gradebook.domain.mapper;

import com.plesniarski.gradebook.domain.converter.Converter;
import com.plesniarski.gradebook.domain.dto.UserDto;
import com.plesniarski.gradebook.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class DtoToUserMapper implements Converter<UserDto, User> {

    @Override
    public User convert(UserDto from) {
        return new User.Builder()
                .name(from.getName())
                .lastName(from.getLastName())
                .albumNo(from.getAlbumNo())
                .admin(from.isAdmin())
                .universityId(from.getUniversityId())
                .build();
    }
}
