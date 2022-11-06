package com.joojeongyong.authentication.server.api;

import com.joojeongyong.authentication.server.domain.user.AuthenticationService;
import com.joojeongyong.authentication.server.domain.user.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@RestController
public class UserController {
	private final AuthenticationService authenticationService;
	
	@PostMapping
	public void addUser(@RequestBody @Valid UserEntity user) {
		authenticationService.addUser(user);
	}
}
