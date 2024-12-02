package com.jay.interview.usermanager.domain.port;

import com.jay.interview.usermanager.domain.model.PageResultDo;
import com.jay.interview.usermanager.common.exception.ActionException;
import com.jay.interview.usermanager.domain.model.UserDo;

public interface UserPort {

    Long createUser(UserDo userDo);

    UserDo getUserById(Long id) throws ActionException;

    void deleteUser(Long id);

    void updateUser(UserDo userDo) throws ActionException;

    PageResultDo<UserDo> getAllUsers(int page, int size);
}
