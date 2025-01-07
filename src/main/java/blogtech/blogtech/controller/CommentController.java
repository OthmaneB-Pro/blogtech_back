package blogtech.blogtech.controller;

import blogtech.blogtech.entity.Comment;
import blogtech.blogtech.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "articles/{articleId}/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public void createComment(@PathVariable int articleId, @RequestBody Comment comment){
        this.commentService.createComment(articleId, comment);
    }

    @GetMapping
    public List<Comment> allComment(@PathVariable int articleId){
        return this.commentService.getCommentsByArticle(articleId);
    }
    @DeleteMapping(path = "{id}")
    public void deleteComment(@PathVariable int id){
         this.commentService.deleteComment(id);
    }

}
