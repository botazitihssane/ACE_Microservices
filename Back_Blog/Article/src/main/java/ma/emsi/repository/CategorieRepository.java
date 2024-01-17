package ma.emsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.emsi.model.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
	Categorie findById(int id);

	Categorie findByNom(String nom);
}
