package com.jay.interview.usermanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResourceDto {

    @Schema(description = "user name", example = "Jay")
    private String name;

    @Schema(description = "user email", example = "jay@gmail.com")
    private String email;

    @Schema(description = "user mobile number", example = "0912345678")
    private String phone;
}
