package com.jay.interview.usermanager.domain.model;

import com.jay.interview.usermanager.adapter.validate.group.CreateGroup;
import com.jay.interview.usermanager.adapter.validate.group.UpdateGroup;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDo {

    @NotBlank(message = "id can not be null", groups = UpdateGroup.class)
    @Null(message = "id must be null", groups = CreateGroup.class)
    private Long id;

    @NotNull(message = "name can not be null", groups = {CreateGroup.class, UpdateGroup.class})
    private String name;

    @NotBlank(message = "email can not be null", groups = {CreateGroup.class, UpdateGroup.class})
    @Email(message = "incorrect format of email", groups = {CreateGroup.class, UpdateGroup.class})
    private String email;

    @NotBlank(message = "phone can not be null", groups = {CreateGroup.class, UpdateGroup.class})
    @Pattern(regexp = "^[0-9]{10}$", message = "incorrect format of phone")
    private String phone;
}
