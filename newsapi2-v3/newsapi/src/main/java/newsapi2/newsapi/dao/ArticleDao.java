package newsapi2.newsapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import newsapi2.newsapi.entities.Articles;

public interface ArticleDao extends JpaRepository<Articles, Long>{

}
