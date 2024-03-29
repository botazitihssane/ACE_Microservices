package ma.emsi.service;

import java.util.List;

import ma.emsi.model.Commentaire;

public interface CommentaireService {

	void create(Commentaire c);

	void update(Commentaire c);

	void delete(int id);

	List<Commentaire> findAll();

	Commentaire findById(int id);

	List<Commentaire> findByArticle(int id);

}
