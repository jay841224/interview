package com.jay.interview.usermanager.adapter.out;

import com.jay.interview.usermanager.domain.port.UserPort;
import com.jay.interview.usermanager.adapter.converter.UserConverter;
import com.jay.interview.usermanager.domain.model.PageResultDo;
import com.jay.interview.usermanager.domain.model.UserDo;
import com.jay.interview.usermanager.repository.entity.UserEntity;
import com.jay.interview.usermanager.common.exception.ActionException;
import com.jay.interview.usermanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserAdapter implements UserPort {

    private final UserRepository userRepository;

    @Override
    public Long createUser(UserDo userDo) {
        UserEntity userEntity = userRepository.save(UserConverter.INSTANCE.doToEntity(userDo));
        return userEntity.getId();
    }

    @Override
    public UserDo getUserById(Long id) throws ActionException {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new ActionException("user not found with id: " + id));
        return UserConverter.INSTANCE.entityToDo(userEntity);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(UserDo userDo) throws ActionException {
        userRepository.findById(userDo.getId())
                .orElseThrow(() -> new ActionException("user not found with id: " + userDo.getId()));
        userRepository.save(UserConverter.INSTANCE.doToEntity(userDo));
    }

    @Override
    public PageResultDo<UserDo> getAllUsers(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<UserEntity> entityPage = userRepository.findAll(pageRequest);

        return UserConverter.INSTANCE.pageEntityToPageResultDo(entityPage);
    }
}
