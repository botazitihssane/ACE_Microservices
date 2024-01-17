package ma.emsi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.emsi.model.Commentaire;
import ma.emsi.model.Visiteur;
import ma.emsi.repository.CommentaireRepository;
import ma.emsi.service.ArticleService;
import ma.emsi.service.CommentaireService;

@Service
public class CommentaireServiceImpl implements CommentaireService {

	@Autowired
	private CommentaireRepository commentaireRepository;

	@Autowired
	private ArticleService articleService;

	@Autowired
	private UtilisateurService utilisateurService;

	@Override
	public void create(Commentaire c) {
		if (c.getVisiteur() != null && c.getVisiteur().getEmail() != null) {
			Visiteur existingVisiteur = utilisateurService.getVisiteurByEmail(c.getVisiteur().getEmail());
			if (existingVisiteur == null) {
				Visiteur newVisiteur = new Visiteur();
				newVisiteur.setEmail(c.getVisiteur().getEmail());
				newVisiteur.setNom(c.getVisiteur().getNom());
				utilisateurService.addVisiteur(newVisiteur);
				c.setVisiteur_id(newVisiteur.getId());
			} else {
				c.setVisiteur_id(existingVisiteur.getId());
				utilisateurService.addVisiteur(existingVisiteur);
			}
		}
		commentaireRepository.save(c);
		articleService.addCommentaire(c);
	}

	@Override
	public void update(Commentaire c) {
		Commentaire newCommentaire = findById(c.getId());
		if (newCommentaire != null) {
			newCommentaire.setDate(c.getDate());
			newCommentaire.setTexte(c.getTexte());
			commentaireRepository.save(newCommentaire);
		}
	}

	@Override
	public void delete(int id) {
		Commentaire c = findById(id);
		articleService.deleteCommentaire(c);
		commentaireRepository.deleteById(id);
	}

	@Override
	public List<Commentaire> findAll() {
		return commentaireRepository.findAll();
	}

	@Override
	public Commentaire findById(int id) {
		return commentaireRepository.findById(id);
	}

	@Override
	public List<Commentaire> findByArticle(int id) {
		List<Commentaire> commentaires = commentaireRepository.findByArticle(id);
		commentaires.forEach(commentaire -> {
			int visiteurId = commentaire.getVisiteur_id();
			Visiteur visiteur = utilisateurService.getVisiteurById(visiteurId);
			commentaire.setVisiteur(visiteur);
		});
		return commentaires;

	}

}
