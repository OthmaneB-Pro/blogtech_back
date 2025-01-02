package blogtech.blogtech.service;

import blogtech.blogtech.entity.Article;
import blogtech.blogtech.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<Article> readAll(){
        return this.articleRepository.findAll();
    }

    public Article getArticleById(int id) {
        Optional<Article> optionalUser = this.articleRepository.findById(id);
        return optionalUser.orElse(null);
    }
}
