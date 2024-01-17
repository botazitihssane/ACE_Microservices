package ma.emsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.emsi.model.Visiteur;

@Repository
public interface VisiteurRepository extends JpaRepository<Visiteur, Integer> {
	Visiteur findByEmail(String email);

	Visiteur findById(int id);

	Visiteur findByNom(String nom);
}