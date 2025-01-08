package blogtech.blogtech.repository;

import blogtech.blogtech.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Page<Article> findByTitleContainingIgnoreCase(String keyword, Pageable pageable);
}
