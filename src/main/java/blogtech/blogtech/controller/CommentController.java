package blogtech.blogtech.controller;

import blogtech.blogtech.entity.Comment;
import blogtech.blogtech.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(name = "articles/{id}/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public void createComment(@RequestBody Comment comment){
        this.commentService.createComment(comment);
    }

    @GetMapping
    public List<Comment> allComment(){
        return this.commentService.allComment();
    }
    @DeleteMapping(path = "{id}")
    public void deleteComment(@PathVariable int id){
         this.commentService.deleteComment(id);
    }

}
