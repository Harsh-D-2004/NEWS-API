package newsapi2.newsapi.service;

import java.util.List;

import newsapi2.newsapi.entities.Articles;

public interface Services {
	
	public List<Articles> getArticles();
	
	public Articles addArticle(Articles article);
}
