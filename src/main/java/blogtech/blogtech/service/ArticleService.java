package blogtech.blogtech.service;

import blogtech.blogtech.entity.Article;
import blogtech.blogtech.entity.User;
import blogtech.blogtech.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final UserService userService;

    public List<Article> readAll(){
        return this.articleRepository.findAll();
    }

    public Article getArticleById(int id) {
        Optional<Article> optionalUser = this.articleRepository.findById(id);
        return optionalUser.orElse(null);
    }

    public void createArticle(Article article) {
        User author = this.userService.getUser(article.getAuthor());
        article.setAuthor(author);
        article.setCreatedAt(LocalDateTime.now());
        article.setUpdatedAt(LocalDateTime.now());
        this.articleRepository.save(article);
    }

    public void modifyArticle(int id, Article article) {
        Optional<Article> optionalArticle = this.articleRepository.findById(id);
        if(optionalArticle.isPresent()){
            Article modifyArticle = optionalArticle.get();
            modifyArticle.setTitle(article.getTitle());
            modifyArticle.setContent(article.getContent());
            modifyArticle.setUpdatedAt(LocalDateTime.now());
            this.articleRepository.save(modifyArticle);
        }
        else {
            throw new RuntimeException("Client with ID " + id + " not found.");
        }
    }

    public void deleteArticle(int id) {
        this.articleRepository.deleteById(id);
        /**
         * Article article = getArticleById(articleId);
         *         if (article.getAuthor().getId() != userId) {
         *             throw new RuntimeException("You're not the author of this article");
         *         }
         *
         *         this.articleRepository.deleteById(articleId);
         * **/
    }

    public Page<Article> searchArticles(String keyword, Pageable pageable) {
        return this.articleRepository.findByTitleContainingIgnoreCase(keyword, pageable);
    }
}
