package com.plesniarski.gradebook.domain.mapper;

import com.plesniarski.gradebook.domain.converter.Converter;
import com.plesniarski.gradebook.domain.dto.UserDto;
import com.plesniarski.gradebook.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserToDtoMapper implements Converter<User, UserDto> {

    @Override
    public UserDto convert(User from) {
        return new UserDto.Builder()
                .id(from.getUserId())
                .name(from.getName())
                .lastName(from.getLastName())
                .albumNo(from.getAlbumNo())
                .build();
    }
}
