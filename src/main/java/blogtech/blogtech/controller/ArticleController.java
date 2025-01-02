package blogtech.blogtech.controller;

import blogtech.blogtech.entity.Article;
import blogtech.blogtech.entity.User;
import blogtech.blogtech.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path = "article")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public List<Article> readAll(){
        return this.articleService.readAll();
    }

    @GetMapping(path = "/{id}")
    public Article getArticleById(@PathVariable int id){
        return this.articleService.getArticleById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createArticle(@RequestBody Article article){
        this.articleService.createArticle(article);
    }
}
