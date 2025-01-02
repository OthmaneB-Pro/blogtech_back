package blogtech.blogtech.controller;

import blogtech.blogtech.entity.Article;
import blogtech.blogtech.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
