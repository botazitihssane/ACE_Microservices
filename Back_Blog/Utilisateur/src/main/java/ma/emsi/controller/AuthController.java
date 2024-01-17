package ma.emsi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.emsi.model.Proprietaire;
import ma.emsi.model.Utilisateur;
import ma.emsi.response.ApiResponse;
import ma.emsi.response.LoginResponse;
import ma.emsi.service.ProprietaireService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/blog/auth")
public class AuthController {

	@Autowired
	ProprietaireService proprietaireService;

	@Autowired
	PasswordEncoder encoder;

	@PostMapping("/signin")
	public ResponseEntity<?> login(@RequestBody Utilisateur user) {
		LoginResponse loginResponse = proprietaireService.login(user);
		if (loginResponse.isSuccess()) {
			return ResponseEntity.ok(loginResponse);
		} else {
			return ResponseEntity.status(401).body(loginResponse);
		}
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody Proprietaire newUser) {
		try {
			proprietaireService.create(newUser);
			return ResponseEntity.ok(new ApiResponse("User registered successfully", true));
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), false));
		}
	}

	@PostMapping("/logout")
	public ResponseEntity<?> logout() {
		return ResponseEntity.ok(new ApiResponse("Logout successful", true));
	}

}
