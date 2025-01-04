package blogtech.blogtech.controller;

import blogtech.blogtech.entity.Comment;
import blogtech.blogtech.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(name = "articles/{id}/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public void createComment(Comment comment){
        this.commentService.createComment(comment);
    }

}
