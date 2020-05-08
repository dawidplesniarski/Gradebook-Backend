package com.plesniarski.gradebook.domain.mapper;

import com.plesniarski.gradebook.domain.converter.Converter;
import com.plesniarski.gradebook.domain.dto.AllUsersDto;
import com.plesniarski.gradebook.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserToAllMapper implements Converter<User, AllUsersDto> {


    @Override
    public AllUsersDto convert(User from) {
        return new AllUsersDto.Builder()
                .id(from.getUserId())
                .name(from.getName())
                .lastName(from.getLastName())
                .albumNo(from.getAlbumNo())
                .admin(from.isAdmin())
                .universityId(from.getUniversityId())
                .course(from.getCourseId())
                .login(from.getLogin())
                .build();
    }
}

/*        return new User.Builder()
                .name(from.getName())
                .lastName(from.getLastName())
                .albumNo(from.getAlbumNo())
                .admin(from.isAdmin())
                .universityId(from.getUniversityId())
                .login(from.getLogin())
                .password(from.getPassword())
                .course(from.getCourse())
                .build();
* */
