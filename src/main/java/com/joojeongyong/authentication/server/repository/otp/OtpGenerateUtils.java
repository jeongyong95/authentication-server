package com.joojeongyong.authentication.server.repository.otp;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OtpGenerateUtils {
	public static String generateOtp() {
		try {
			SecureRandom random = SecureRandom.getInstanceStrong();
			int c = random.nextInt(900_000) + 100_000;
			return String.valueOf(c);
		} catch (NoSuchAlgorithmException e) {
			log.error("OTP 생성 실패.");
			throw new RuntimeException(e);
		}
	}
}
