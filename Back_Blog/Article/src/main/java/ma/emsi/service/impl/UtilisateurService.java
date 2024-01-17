package ma.emsi.service.impl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ma.emsi.model.Visiteur;

@FeignClient(name = "service-utilisateur")
public interface UtilisateurService {

	@GetMapping("blog/visiteur/email/{email}")
	Visiteur getVisiteurByEmail(@PathVariable("email") String email);

	@GetMapping("blog/visiteur/{id}")
	Visiteur getVisiteurById(@PathVariable("id") int id);

	@PostMapping("blog/visiteur")
	void addVisiteur(@RequestBody Visiteur v);
}
