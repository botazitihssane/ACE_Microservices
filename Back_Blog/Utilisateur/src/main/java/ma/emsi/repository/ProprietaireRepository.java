package ma.emsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.emsi.model.Proprietaire;

@Repository
public interface ProprietaireRepository extends JpaRepository<Proprietaire, Integer> {

	Proprietaire findById(int id);
}