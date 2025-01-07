package blogtech.blogtech.repository;

import blogtech.blogtech.entity.Article;
import blogtech.blogtech.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByArticle(Article article);
}
