package ma.emsi.service;

import java.time.LocalDate;
import java.util.List;

import ma.emsi.model.Article;
import ma.emsi.model.Commentaire;

public interface ArticleService {

	public void create(Article a);

	public List<Article> findAll();

	public Article findById(int id) throws Exception;

	public List<Article> sortByDate();

	public List<Article> sortByComments();

	public List<Article> findByDate(LocalDate date);

	public List<Article> searchByKeyword(String keyword);

	public List<Article> searchByCategory(int id);

	public void addCommentaire(Commentaire c);

	public void deleteCommentaire(Commentaire c);

	public void update(Article a);

	public void delete(int id);
}
