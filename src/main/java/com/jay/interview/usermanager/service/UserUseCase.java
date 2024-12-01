package com.jay.interview.usermanager.service;

import com.jay.interview.usermanager.domainobject.PageResultDo;
import com.jay.interview.usermanager.exception.ActionException;
import com.jay.interview.usermanager.adapter.UserPort;
import com.jay.interview.usermanager.domainobject.UserDo;
import com.jay.interview.usermanager.validate.ValidateService;
import com.jay.interview.usermanager.validate.group.CreateGroup;
import com.jay.interview.usermanager.validate.group.UpdateGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserUseCase {

    private final UserPort userPort;

    private final ValidateService validateService;

    public Long createUser(UserDo userDo) {
        validateService.validate(userDo, CreateGroup.class);
        return userPort.createUser(userDo);
    }

    public UserDo getUserById(Long id) throws ActionException {
        validateService.validateNotNull(id, "id can not be null");

        return userPort.getUserById(id);
    }

    public PageResultDo<UserDo> getAllUsers(int page, int size) {
        return userPort.getAllUsers(page, size);
    }

    public void updateUser(UserDo userDo) throws ActionException {
        validateService.validate(userDo, UpdateGroup.class);
        userPort.updateUser(userDo);
    }

    public void deleteUser(Long id) {
        validateService.validateNotNull(id, "id can not be null");
        userPort.deleteUser(id);
    }
}
