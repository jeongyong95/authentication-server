package com.joojeongyong.authentication.server.repository.otp;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Otp {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID otpId;
	
	private String username;
	
	private String code;
	
	@CreatedDate
	private LocalDateTime createdAt;
	
	public static Otp createOtp(String username, String code) {
		return Otp.builder()
			.username(username)
			.code(code)
			.build();
	}
	
	public void updateCode(String code) {
		this.code = code;
	}
}
