package fr.doranco.ecommerce.service;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import fr.doranco.ecommerce.entities.Article;
import fr.doranco.ecommerce.repository.ArticleRepository;  

@Service  
public class ArticleService {
	
	@Autowired  
	ArticleRepository articlesRepository;  
	//getting all articles record by using the method findaAll() of CrudRepository  
	public List<Article> getAllArticles()   {  
		List<Article> articles = new ArrayList<Article>();  
		articlesRepository.findAll().forEach(articles1 -> articles.add(articles1));  
		return articles;  
		}  
	
	//getting a specific record by using the method findById() of CrudRepository  
	public Article getArticlesById(long id)   {  
		return articlesRepository.findById(id).get();
		}
	
	//saving a specific record by using the method save() of CrudRepository  
	public void saveOrUpdate(Article articles)   {  
		articlesRepository.save(articles);  
		}  
	
	//deleting a specific record by using the method deleteById() of CrudRepository  
	public void delete(long id)   {  
		articlesRepository.deleteById(id);  
		}  
	
	//updating a record  
	public void update(Article articles, long id)   {  
		articlesRepository.save(articles);  
		}  
}  
