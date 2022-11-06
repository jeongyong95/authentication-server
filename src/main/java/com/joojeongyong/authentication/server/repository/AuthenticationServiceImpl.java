package com.joojeongyong.authentication.server.repository;

import com.joojeongyong.authentication.server.domain.otp.OtpEntity;
import com.joojeongyong.authentication.server.domain.user.AuthenticationService;
import com.joojeongyong.authentication.server.domain.user.UserEntity;
import com.joojeongyong.authentication.server.repository.otp.Otp;
import com.joojeongyong.authentication.server.repository.otp.OtpGenerateUtils;
import com.joojeongyong.authentication.server.repository.otp.OtpRepository;
import com.joojeongyong.authentication.server.repository.user.User;
import com.joojeongyong.authentication.server.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.joojeongyong.authentication.server.domain.constant.ExceptionMessages.Authentication.UNAUTHORIZATION;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	private final UserRepository userRepository;
	private final OtpRepository otpRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public void checkOtp(OtpEntity otp) {
		var target = otpRepository.findByUsername(otp.getUsername());
		
		boolean isSuccess = false;
		if (target.isPresent()) {
			String targetCode = target.get().getCode();
			isSuccess = StringUtils.equals(targetCode, otp.getCode());
		}
		if (isSuccess) return;
		
		throw new BadCredentialsException(UNAUTHORIZATION);
	}
	
	@Override
	@Transactional
	public void authenticate(UserEntity user) {
		userRepository.findByUsername(user.getUsername())
			.ifPresentOrElse(target -> {
				if (passwordEncoder.matches(user.getPassword(), target.getPassword())) {
					renewOtp(user);
				} else {
					throw new BadCredentialsException(UNAUTHORIZATION);
				}
			}, () -> {
				throw new BadCredentialsException(UNAUTHORIZATION);
			});
	}
	
	private void renewOtp(UserEntity user) {
		String code = OtpGenerateUtils.generateOtp();
		
		otpRepository.findByUsername(user.getUsername())
			.ifPresentOrElse(otp -> otp.updateCode(code),
				() -> otpRepository.save(Otp.createOtp(user.getUsername(), code))
			);
	}
	
	@Override
	@Transactional
	public void addUser(UserEntity user) {
		userRepository.save(User.from(user, passwordEncoder));
	}
}
