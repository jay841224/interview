package com.jay.interview.usermanager.adapter.in;

import com.jay.interview.usermanager.adapter.converter.UserConverter;
import com.jay.interview.usermanager.domain.model.PageResultDo;
import com.jay.interview.usermanager.domain.model.UserDo;
import com.jay.interview.usermanager.adapter.in.model.PageResultDto;
import com.jay.interview.usermanager.adapter.in.model.UserDto;
import com.jay.interview.usermanager.adapter.in.model.UserResourceDto;
import com.jay.interview.usermanager.common.exception.ActionException;
import com.jay.interview.usermanager.domain.usecase.UserUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User API", description = "API for user")
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserUseCase userUseCase;

    /**
     * create new user
     */
    @PostMapping
    @Operation(summary = "create new user", description = "create user")
    public ResponseEntity<Long> createUser(@RequestBody UserResourceDto userResourceDto) {
        Long id = userUseCase.createUser(UserConverter.INSTANCE.dtoToDo(userResourceDto));
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    /**
     * get all user
     */
    @GetMapping
    @Operation(summary = "get all user", description = "get user with pagination")
    public ResponseEntity<PageResultDto<UserDto>> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        PageResultDo<UserDo> pageResultDo = userUseCase.getAllUsers(page, size);

        return ResponseEntity.ok(UserConverter.INSTANCE.doToDto(pageResultDo));
    }

    /**
     * get user
     */
    @GetMapping("/{id}")
    @Operation(summary = "get user", description = "get user by id")
    public ResponseEntity<UserDto> getUserById(
            @Parameter(description = "unique id", required = true)
            @PathVariable Long id) throws ActionException {
        UserDo userDo = userUseCase.getUserById(id);
        return ResponseEntity.ok(UserConverter.INSTANCE.doToDto(userDo));
    }

    /**
     * update user
     */
    @PutMapping("/{id}")
    @Operation(summary = "update user", description = "update user by id")
    public ResponseEntity<Void> updateUser(
            @Parameter(description = "unique id", required = true)
            @PathVariable Long id,
            @RequestBody UserResourceDto userResourceDto) throws ActionException {
        userUseCase.updateUser(UserConverter.INSTANCE.idAndDtoToDo(id, userResourceDto));
        return ResponseEntity.noContent().build();
    }

    /**
     * delete user
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "delete user", description = "delete user by id")
    public ResponseEntity<Void> deleteUser(
            @Parameter(description = "unique id", required = true)
            @PathVariable Long id) {
        userUseCase.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
