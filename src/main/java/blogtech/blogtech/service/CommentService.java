package blogtech.blogtech.service;

import blogtech.blogtech.entity.Article;
import blogtech.blogtech.entity.Comment;
import blogtech.blogtech.entity.User;
import blogtech.blogtech.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserService userService;
    private final ArticleService articleService;

    public void createComment(int articleId, Comment comment){
        User author = this.userService.getUser(comment.getAuthor());
        Article article = this.articleService.getArticleById(articleId);
        comment.setAuthor(author);
        comment.setArticle(article);
        comment.setCreatedAt(LocalDateTime.now());
        this.commentRepository.save(comment);
    }

    public List<Comment> allComment(int articleId) {
        Article article = this.articleService.getArticleById(articleId);
        return commentRepository.findByArticle(article);
    }

    public void deleteComment(int id) {
        this.commentRepository.deleteById(id);
    }

    public List<Comment> getCommentsByArticle(int articleId) {
        Article article = this.articleService.getArticleById(articleId);
        return commentRepository.findByArticle(article);
    }
}
