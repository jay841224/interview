package com.jay.interview.usermanager.domainobject;

import com.jay.interview.usermanager.validate.group.CreateGroup;
import com.jay.interview.usermanager.validate.group.UpdateGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDo {

    @NotNull(message = "id can not be null", groups = UpdateGroup.class)
    @Null(message = "id must be null", groups = CreateGroup.class)
    private Long id;

    @NotNull(message = "name can not be null", groups = {CreateGroup.class, UpdateGroup.class})
    private String name;

    @NotNull(message = "email can not be null", groups = {CreateGroup.class, UpdateGroup.class})
    @Email(message = "incorrect format of email", groups = {CreateGroup.class, UpdateGroup.class})
    private String email;

    @NotNull(message = "phone can not be null", groups = {CreateGroup.class, UpdateGroup.class})
    @Pattern(regexp = "^[0-9]{10}$", message = "incorrect format of phone")
    private String phone;
}
