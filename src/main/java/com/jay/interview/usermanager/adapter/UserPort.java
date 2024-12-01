package com.jay.interview.usermanager.adapter;

import com.jay.interview.usermanager.domainobject.PageResultDo;
import com.jay.interview.usermanager.exception.ActionException;
import com.jay.interview.usermanager.domainobject.UserDo;
import com.jay.interview.usermanager.entity.UserEntity;

import java.util.List;

public interface UserPort {

    Long createUser(UserDo userDo);

    UserDo getUserById(Long id) throws ActionException;

    void deleteUser(Long id);

    void updateUser(UserDo userDo) throws ActionException;

    PageResultDo<UserDo> getAllUsers(int page, int size);
}
