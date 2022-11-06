package com.joojeongyong.authentication.server.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UserEntity {
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;
}
