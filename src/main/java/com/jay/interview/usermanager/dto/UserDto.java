package com.jay.interview.usermanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "user info")
@Getter
@Setter
public class UserDto {

    @Schema(description = "unique id", example = "1")
    private Long id;

    @Schema(description = "user name", example = "Jay")
    private String name;

    @Schema(description = "user email", example = "jay@gmail.com")
    private String email;

    @Schema(description = "user mobile number", example = "0912345678")
    private String phone;
}
