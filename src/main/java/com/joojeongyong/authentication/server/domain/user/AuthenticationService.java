package com.joojeongyong.authentication.server.domain.user;

import com.joojeongyong.authentication.server.domain.otp.OtpEntity;

public interface AuthenticationService {
	void authenticate(UserEntity user);
	
	void checkOtp(OtpEntity otp);
	
	void addUser(UserEntity user);
}
