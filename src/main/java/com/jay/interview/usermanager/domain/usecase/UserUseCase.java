package com.jay.interview.usermanager.domain.usecase;

import com.jay.interview.usermanager.domain.model.PageResultDo;
import com.jay.interview.usermanager.common.exception.ActionException;
import com.jay.interview.usermanager.domain.port.UserPort;
import com.jay.interview.usermanager.domain.model.UserDo;
import com.jay.interview.usermanager.adapter.validate.ValidateService;
import com.jay.interview.usermanager.adapter.validate.group.CreateGroup;
import com.jay.interview.usermanager.adapter.validate.group.UpdateGroup;
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
