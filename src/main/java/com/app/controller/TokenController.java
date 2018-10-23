/**
 * 
 */
package com.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.bean.User;
import com.app.security.token.JwtGen;

/**
 * @author TTTDEMIRCI
 *
 */

@RestController
@RequestMapping("/token")
public class TokenController {

	private JwtGen generator;

	public TokenController(JwtGen generator) {

		this.generator = generator;
	}

	@PostMapping
	public String generate(@RequestBody final User user) {

		return generator.generate(user);
	}

}
