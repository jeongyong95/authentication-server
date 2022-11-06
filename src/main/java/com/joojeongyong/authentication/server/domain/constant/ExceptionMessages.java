package com.joojeongyong.authentication.server.domain.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExceptionMessages {
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	public static final class Authentication {
		public static final String UNAUTHORIZATION = "인증에 실패하였습니다.";
	}
}
