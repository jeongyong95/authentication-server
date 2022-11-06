package com.joojeongyong.authentication.server.repository.user;

import com.joojeongyong.authentication.server.domain.user.UserEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "joojoo_user")
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID userId;
	
	private String username;
	
	private String password;
	
	@CreatedDate
	private LocalDateTime registeredAt;
	
	public static User from(UserEntity user, PasswordEncoder passwordEncoder) {
		return User.builder()
			.username(user.getUsername())
			.password(passwordEncoder.encode(user.getPassword()))
			.build();
	}
}
