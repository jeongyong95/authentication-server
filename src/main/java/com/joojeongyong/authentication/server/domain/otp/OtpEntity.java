package com.joojeongyong.authentication.server.domain.otp;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class OtpEntity {
	@NotBlank
	private String username;
	
	@NotBlank
	private String code;
}
