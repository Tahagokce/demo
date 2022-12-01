package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ADSignInDto {
    private String username;
    private String password;
    private String domainName;
    private String serverName;
}
