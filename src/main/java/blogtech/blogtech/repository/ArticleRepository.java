package blogtech.blogtech.repository;

import blogtech.blogtech.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    List<Article> findByTitleContainingIgnoreCase(String keyword);
}
