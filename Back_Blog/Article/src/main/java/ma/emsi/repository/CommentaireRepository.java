package ma.emsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.emsi.model.Commentaire;

public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {
	Commentaire findById(int id);

	@Query("SELECT a FROM Commentaire a WHERE a.article.id = :id")
	List<Commentaire> findByArticle(@Param("id") int id);
}
