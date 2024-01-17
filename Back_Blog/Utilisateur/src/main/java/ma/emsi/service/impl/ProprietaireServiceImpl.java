package ma.emsi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ma.emsi.model.Proprietaire;
import ma.emsi.model.Utilisateur;
import ma.emsi.repository.ProprietaireRepository;
import ma.emsi.repository.UtilisateurRepository;
import ma.emsi.response.LoginResponse;
import ma.emsi.service.ProprietaireService;

@Service
public class ProprietaireServiceImpl implements ProprietaireService {
	@Autowired
	private ProprietaireRepository proprietaireRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UtilisateurRepository userRepository;

	@Override
	public void create(Proprietaire p) {
		if (validateAndCheckUniqueness(p)) {
			p.setPassword(passwordEncoder.encode(p.getPassword()));
			proprietaireRepository.save(p);
		}
	}

	@Override
	public void update(Proprietaire p) {
		if (validateAndCheckUniqueness(p)) {
			Proprietaire existingProprietaire = findById(p.getId());
			if (existingProprietaire != null) {
				existingProprietaire.setBiographie(p.getBiographie());
				existingProprietaire.setPhoto(p.getPhoto());
				existingProprietaire.setEmail(p.getEmail());
				existingProprietaire.setPassword(passwordEncoder.encode(p.getPassword()));
				proprietaireRepository.save(existingProprietaire);
			}
		}
	}

	@Override
	public void delete(int id) {
		proprietaireRepository.deleteById(id);
	}

	@Override
	public List<Proprietaire> findAll() {
		return proprietaireRepository.findAll();
	}

	@Override
	public Proprietaire findById(int id) {
		return proprietaireRepository.findById(id);
	}

	private boolean validateAndCheckUniqueness(Proprietaire p) {
		if (userRepository.existsByEmail(p.getEmail())) {
			throw new RuntimeException("Error: Email is already in use!");
		}
		return true;
	}

	@Override
	public LoginResponse login(Utilisateur utilisateur) {
		Utilisateur user = userRepository.getUserByEmail(utilisateur.getEmail());
		if (user != null) {
			String password = utilisateur.getPassword();
			String encodedPassword = user.getPassword();
			Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
			if (isPwdRight) {
				Optional<Utilisateur> u = userRepository.findByEmailAndPassword(utilisateur.getEmail(),
						encodedPassword);
				if (u.isPresent())
					return new LoginResponse(user.getId(), user.getEmail());

			}
		}
		return new LoginResponse();
	}
}
