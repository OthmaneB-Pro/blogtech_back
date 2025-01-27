package blogtech.blogtech.controller;

import blogtech.blogtech.entity.Article;
import blogtech.blogtech.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "article")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public List<Article> readAll(){
        return this.articleService.readAll();
    }

    @GetMapping(path = "{id}")
    public Article getArticleById(@PathVariable int id) {
        return this.articleService.getArticleById(id);
    }

    @GetMapping(path = "/search")
    public Page<Article> searchArticle(@RequestParam String keyword, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        return articleService.searchArticles(keyword, pageable);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createArticle(@RequestBody Article article){
        this.articleService.createArticle(article);
    }

    @PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void modifyArticle(@PathVariable int id,@RequestBody Article article){
        this.articleService.modifyArticle(id, article);
    }

    @DeleteMapping(path = "{id}")
    public void deleteArticle(@PathVariable int id){
        this.articleService.deleteArticle(id);
    }
}
