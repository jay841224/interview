package com.jay.interview.usermanager.adapter.converter;

import com.jay.interview.usermanager.domain.model.PageResultDo;
import com.jay.interview.usermanager.domain.model.UserDo;
import com.jay.interview.usermanager.adapter.in.model.PageResultDto;
import com.jay.interview.usermanager.adapter.in.model.UserDto;
import com.jay.interview.usermanager.adapter.in.model.UserResourceDto;
import com.jay.interview.usermanager.repository.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    UserDto doToDto(UserDo userDo);

    UserEntity doToEntity(UserDo userDo);

    UserDo entityToDo(UserEntity userEntity);

    UserDo dtoToDo(UserDto userDto);

    UserDo dtoToDo(UserResourceDto userResourceDto);

    @Mapping(target = "id", source = "id")
    UserDo idAndDtoToDo(Long id, UserResourceDto userResourceDto);

    PageResultDo<UserDo> pageEntityToPageResultDo(Page<UserEntity> page);

    PageResultDto<UserDto> doToDto(PageResultDo<UserDo> pageResultDo);
    
}
